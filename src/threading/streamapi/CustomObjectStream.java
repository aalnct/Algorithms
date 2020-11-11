package threading.streamapi;

import java.util.ArrayList;
import java.util.List;

public class CustomObjectStream {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Adam", true));
        studentList.add(new Student("Daniel", false));
        studentList.add(new Student("Susan", true));
        studentList.add(new Student("Joe", false));
        studentList.add(new Student("Michale", true));

        studentList.stream().map(Student::getName).forEach(System.out::println);
        studentList.stream().map(Student::getName).filter(s -> s.equals("Adam")).forEach(System.out::println);

        System.out.println("**********");

        studentList.stream().filter(s -> s.isLocal()).map(Student::getName).forEach(System.out::println);
    }
}
