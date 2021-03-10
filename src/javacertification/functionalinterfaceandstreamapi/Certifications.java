package javacertification.functionalinterfaceandstreamapi;

public class Certifications {
    String studentId;
    String test;
    int marks;

    Certifications (String studentId, String test, int marks) {
        this.marks = marks;
        this.studentId = studentId;
        this.test = test;
    }

    @Override
    public String toString() {
        return "Certifications{" +
                "sudentId='" + studentId + '\'' +
                ", test='" + test + '\'' +
                ", marks=" + marks +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
