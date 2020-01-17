package student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import service.Filter;
import service.RepoService;

import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final RepoService db;

    @Autowired
    public StudentServiceImpl(RepoService db) {
        this.db = db;
    }

    @Override
    public Student putStudentDetail(Student student) throws IOException {
        if(student != null) {
            ObjectMapper objMapper = new ObjectMapper();
            String studentJson = objMapper.writeValueAsString(student);
            String json = db.insert(studentJson);
            return (json != null ? objMapper.readValue(json, Student.class) : null);
        } else {
            return null;
        }
    }

    @Override
    public Student getStudentDetail(List<Filter> studentFilters) throws IOException {
        if(studentFilters != null) {
            ObjectMapper objMapper = new ObjectMapper();
            String json = db.get(studentFilters);
            return (json != null ? objMapper.readValue(json, Student.class) : null);
        } else {
            return null;
        }
    }

    @Override
    public Student updateStudentDetail(String id, List<Filter> studentFilters) throws IOException {
        if(id != null && studentFilters != null) {
            ObjectMapper objMapper = new ObjectMapper();
            String json = db.update(id, studentFilters);
            return (json != null ? objMapper.readValue(json, Student.class) : null);
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudentDetail(String id) throws IOException {
        if(id != null) {
            ObjectMapper objMapper = new ObjectMapper();
            String json = db.remove(id);
            return (json != null ? objMapper.readValue(json, Student.class) : null);
        } else {
            return null;
        }
    }

    @Override
    public void clearDB() {
        db.clearDB();
    }
}
