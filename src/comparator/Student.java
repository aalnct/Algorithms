package comparator;

/**
 * Created by AmitAgarwal on 3/18/19.
 */
public class Student {

    public int id;
    public String firstName;
    public double cgpa;

    public Student(int id, String firstName, double cgpa){
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
