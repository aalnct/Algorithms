package maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by AmitAgarwal on 3/13/19.
 */
public class EmployeeMain {

    static Map<String, List<Employee>> map =  new HashMap<>();
    static Map<String, List<Employee>> elseMap =  new HashMap<>();

    static Map<String, Employee> newMap = new HashMap<>();

    public static void main(String [] args) {
        EmployeeService service = new EmployeeService("test", (short) 1);
        List<EmployeeService> list = new ArrayList<>();
        list.add(service);
        addListToMap(map);


        Map<Employee,Employee> map1 = new HashMap<>();
        map1.put(new Employee("key1",(short)50),new Employee("value1",(short)50));

        /**
         * populating newMap
         */

        newMap.put("key1", new Employee("name1", (short)10));
        newMap.put("key2", new Employee("name12", (short)10));
        newMap.put("key3", new Employee("name14", (short)10));

        newMap.values().stream().forEach(e->System.out.println(e.getName()));
        newMap.values().stream().forEach(e->System.out.println(e.getName()));
    }


    private static void addListToMap(Map<String, List<Employee>> map) {
        populateElseMap(elseMap);
        Optional.of(elseMap).orElse(map).entrySet().forEach(
                e -> System.out.println(e.getKey()));

        //Employee employee = Optional.of(elseMap).orElse(map).entrySet().forEach();
    }

    private static void populateElseMap(Map<String, List<Employee>> elseMap){
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee("FirstName", (short)1));
        employeesList.add(new Employee("secondName", (short)2));
        employeesList.add(new Employee("thirdName", (short)3));
        employeesList.add(new Employee("fourthName", (short)4));

        elseMap.put("1", employeesList);
        elseMap.put("2", employeesList);
        elseMap.put("3", employeesList);
        elseMap.put("4", employeesList);
    }

}
