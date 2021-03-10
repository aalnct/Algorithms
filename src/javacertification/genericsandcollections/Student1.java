package javacertification.genericsandcollections;

import java.util.Comparator;

public class Student1 implements Comparator<Student1> {

    private String name;
    private String exam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public Student1() {
    }

    public Student1(String name, String exam) {
        this.name = name;
        this.exam = exam;
    }
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", exam='" + exam + '\'' +
                '}';
    }
    @Override
    public int compare(Student1 s1, Student1 s2) {
        return s1.name.compareToIgnoreCase(s2.name);
    }
}
