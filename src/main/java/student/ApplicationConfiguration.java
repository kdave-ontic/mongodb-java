package student;

import org.springframework.context.annotation.Bean;
import service.MongoRepoService;
import service.RepoService;

public class ApplicationConfiguration {

    @Bean(name = "RepoService")
    public RepoService getMongoRepoService() {
        return new MongoRepoService();
    }

    @Bean(name = "StudentService")
    public StudentService getStudentService() {
        return new StudentServiceImpl(getMongoRepoService());
    }
}
