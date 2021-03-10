package java8api.functionalInterfaces.data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {
    public static List<Student> getAllStudents () {
        // 2nd grade students
        Student student1 = new Student("Adam", 2, 3.6, "Male", Arrays.asList("Swimming", "basketball", "cricket"));
        Student student2 = new Student("Jenny", 2, 3.8, "Female", Arrays.asList("Soccer", "basketball", "cricket"));

        //3rd Grade Students
        Student student3 = new Student("Emily", 3, 4.0, "Female", Arrays.asList("Swimming", "basketball", "cricket"));
        Student student4 = new Student("Dave", 3, 3.9, "Male", Arrays.asList("Soccer", "basketball", "cricket"));

        //4th Grade Students
        Student student5 = new Student("Sophia", 4, 3.5, "Female", Arrays.asList("Swimming", "basketball", "cricket"));
        Student student6 = new Student("James", 4, 3.9, "Male", Arrays.asList("Soccer", "basketball", "cricket"));

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5,student6);

        return studentList;

    }
}
