package maps;

/**
 * Created by AmitAgarwal on 3/13/19.
 */
public class Employee {

    public Employee(String name, short age){
        this.name = name;
        this.age = age;
    }

    private String name;

    private short age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
