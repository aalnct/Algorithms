package javacertification.functionalinterfaceandstreamapi;

public class Person {
    int id;
    String name;

    Person (int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals (Object obj) {
        if (obj instanceof Person) {
            Person p = (Person)obj;
            return this.id == p.id;
        }
        return false;
    }

    public int hashCode (){
        return new Integer(this.id).hashCode();
    }
}
