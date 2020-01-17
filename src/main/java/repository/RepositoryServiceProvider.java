package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryServiceProvider {


    private final List<RepositoryService> allServices;


    @Autowired
    public RepositoryServiceProvider(List<RepositoryService> allServices) {
        this.allServices = allServices;
    }

    public RepositoryService getService(Class<?> clazz) {
        boolean mongoAnnotation = hasMongoAnnotation(clazz);
        if (mongoAnnotation) {
            return allServices.get(0);
        }
        return null;
    }

    private boolean hasMongoAnnotation(Class<?> clazz) {
        return true;
    }

}
