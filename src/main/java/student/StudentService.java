package student;

import service.Filter;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    Student putStudentDetail(Student student) throws IOException;
    Student getStudentDetail(List<Filter> studentFilters) throws IOException;
    Student updateStudentDetail(String id, List<Filter> studentFilters) throws IOException;
    Student removeStudentDetail(String id) throws IOException;
    void clearDB();
}
