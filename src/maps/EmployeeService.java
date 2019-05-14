package maps;

/**
 * Created by AmitAgarwal on 3/13/19.
 */
public class EmployeeService {

    private static String name;
    private static short age;

    static Employee employee = new Employee(name,age);


    public EmployeeService(String name, short age){
        employee.setName(name);
        employee.setAge(age);
    }


    public static EmployeeService getDetails(){
        System.out.print("printing details");
        System.out.println(employee.getName() + " " + employee.getAge());
        return new EmployeeService(employee.getName(), employee.getAge());
    }



}
