package student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Filter;

import java.io.IOException;


public class StudentDriver {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        StudentService studentService = (StudentService) context.getBean("StudentService") ;
        Student detail = new student.Student.StudentBuilder("201601170", "Keval","Dave").setCpiSem1(8.23).setCpiSem2(7.22).build();
        studentService.putStudentDetail(detail);
        detail = new student.Student.StudentBuilder("201601253", "Jaimin","Chaudhary").setCpiSem1(4.12).setCpiSem2(8.22).build();
        studentService.putStudentDetail(detail);
        detail = new student.Student.StudentBuilder("201601166", "Chagan","Magan").setCpiSem1(1.11).setCpiSem2(2.22).build();
        studentService.putStudentDetail(detail);
        Filter filterObj = new Filter();
        filterObj.add("id","201601170");
        Student found = studentService.getStudentDetail(filterObj.getList());
        if(found != null){
            System.out.println(found.toString());
        } else {
            System.out.println("No document found!");
        }
    }
}
