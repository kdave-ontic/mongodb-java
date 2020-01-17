package user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Filter;

import java.io.IOException;

public class UserMain {
    public static void main(String[] args) throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService usrService = (UserService) context.getBean("UserService") ;
        User detail = new User.UserBuilder("kevaldawe@gmail.com").setName("Keval Dave").setCity("Rajkot").setCountry("India").setState("Gujarat").build();
        usrService.putUserDetail(detail);
        detail = new User.UserBuilder("kdave@ontic.ai").setCity("Noida").setName("Keval S Dave").setState("UP").build();
        usrService.putUserDetail(detail);
        detail = new User.UserBuilder("half@gmail.com").setCity("Noida").setName("Keval").build();
        usrService.putUserDetail(detail);
        Filter filterObj = new Filter();
        filterObj.add("id","kdave@ontic.ai");
        User found = usrService.getUserDetail(filterObj.getList());
        if(found != null){
            System.out.println(found.toString());
        }
    }
}
