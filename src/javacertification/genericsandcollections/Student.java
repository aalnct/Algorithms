package javacertification.genericsandcollections;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student stud = (Student) obj;
            return this.name.equals(stud.name) && this.age == stud.age;
        }
        return false;
    }

   /* public int hashCode () {
        return name.hashCode() + age;
    }*/

    public String getName () {
        return name;
    }

    public int getAge () {
        return age;
    }

    public static int compareByName (Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    @Override
    public int compareTo(Student s) {
        return s.getAge() - this.getAge();
    }
}
