package user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.RepoService;
import service.MongoRepoService;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "Database")
    public RepoService getMongo() {
        return new MongoRepoService();
    }

    @Bean(name = "UserService")
    public UserService getUserService(RepoService db) {
        return new UserServiceServiceImpl(db, repositoryServiceProvider);
    }
}
