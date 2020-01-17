package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import repository.RepositoryService;
import repository.RepositoryServiceProvider;
import service.RepoService;
import service.Filter;

import java.io.IOException;
import java.util.List;

public class UserServiceServiceImpl implements UserService {

    private final RepoService db;

    private final RepositoryService repositoryService;

    @Autowired
    public UserServiceServiceImpl(RepoService db, RepositoryServiceProvider repositoryServiceProvider) {
        this.db = db;
        this.repositoryService = repositoryServiceProvider.getService(User.class);
    }

    @Override
    public User getUserDetail(List<Filter> usrFilters) throws IllegalArgumentException, IOException {
        if (usrFilters == null || usrFilters.size() == 0) {
            throw new IllegalArgumentException("usrFilters is null");
        }
        String json = db.get(usrFilters);
        ObjectMapper objMapper = new ObjectMapper();
        return (json != null ? objMapper.readValue(json, User.class) : null);
    }

    @Override
    public User putUserDetail(User user) throws IllegalArgumentException, IOException {
        if(user == null) {
            throw new IllegalArgumentException("user is null");
        }
        ObjectMapper objMapper = new ObjectMapper();
        String userJson = objMapper.writeValueAsString(user);
        String json = db.insert(userJson);
        return (json != null ? objMapper.readValue(json, User.class) : null);
    }

    @Override
    public User updateUserDetail(String id, List<Filter> usrFilters) throws IllegalArgumentException, IOException {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        ObjectMapper objMapper = new ObjectMapper();
        String json = db.update(id, usrFilters);
        return (json != null ? objMapper.readValue(json, User.class) : null);
    }

    @Override
    public User removeUser(String id) throws IllegalArgumentException, IOException {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        String json = db.remove(id);
        ObjectMapper objMapper = new ObjectMapper();
        return (json != null ? objMapper.readValue(json, User.class) : null);
    }

    @Override
    public void clearDB() {
        db.clearDB();
    }
}
