package javacertification.genericsandcollections;

import maps.Employee;

public class Employees implements Comparable<Employees> {

    private String name;
    private int age;

    Employees(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employees emp) {
        return emp.age - this.age;
    }
}
