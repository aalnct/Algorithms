package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by AmitAgarwal on 3/18/19.
 */
public class StudentComparator{

    public static void main(String[] args) {
        StudentComparator comp = new StudentComparator();
        List<Student> listOfStudent = comp.compare();
        System.out.println("Before sorting list");
        for(int i=0;i<listOfStudent.size();i++){
            System.out.println(listOfStudent.get(i).getFirstName() + "  " + listOfStudent.get(i).getId()
                    + " " + listOfStudent.get(i).getCgpa());
        }


        listOfStudent.iterator().forEachRemaining(System.out :: println);

        /**
         * Lamda way for comparing
         */

        Comparator<Student> student = (st1,st2)->{
            return new Integer(st1.getId()).compareTo(st2.getId());
        };

        /***
         * Sorting the student list
         */

        Collections.sort(listOfStudent,student);
        System.out.println("---- After sorting-----");
        for(int i=0;i<listOfStudent.size();i++){
            System.out.println(listOfStudent.get(i).getFirstName() + "  " + listOfStudent.get(i).getId()
            + " " + listOfStudent.get(i).getCgpa());
        }

    }

    private List<Student> compare() {

        Student student1 = new Student(8, "Amit", 3.9);
        Student student2 = new Student(1, "Sumit", 4.9);
        Student student3 = new Student(5, "Sachin", 6.9);

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        return studentList;
    }
}
