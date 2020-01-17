package repository;

import org.springframework.stereotype.Service;
import service.Filter;

import java.util.List;

@Service
public class MongoRepositoryService implements RepositoryService {

    @Override
    public <T> T save(T object) {
        return null;
    }

    @Override
    public <T> List<T> get(List<Filter> filters) {
        return null;
    }

    @Override
    public Class<?> getAnnotationClass() {
        return Mongo.class;
    }
}