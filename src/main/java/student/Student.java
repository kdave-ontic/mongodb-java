package student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private Double cpiSem1 = 0.0;
    private Double cpiSem2 = 0.0;

    public Student() {

    }

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.cpiSem1 = builder.cpiSem1;
        this.cpiSem2 = builder.cpiSem2;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getCpiSem1() {
        return cpiSem1;
    }

    public Double getCpiSem2() {
        return cpiSem2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpiSem1=" + cpiSem1.toString() +
                ", cpiSem2=" + cpiSem2.toString() +
                '}';
    }

    public static class StudentBuilder {
        private String id;
        private String firstName;
        private String lastName;
        private Double cpiSem1 = 0.0;
        private Double cpiSem2 = 0.0;

        public StudentBuilder() {

        }
        public StudentBuilder(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder setCpiSem1(Double cpiSem1) {
            this.cpiSem1 = cpiSem1;
            return this;
        }

        public StudentBuilder setCpiSem2(Double cpiSem2) {
            this.cpiSem2 = cpiSem2;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

