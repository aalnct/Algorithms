package certification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitAgarwal on 1/15/20.
 */

/**
 * Immutable classes - declared as final and also no setter method
 */
public final class Person {
    private final String name;
    private final List<String> nickNames;


    public Person(String fullName, List<String> nickNames){
        this.name = fullName;
        this.nickNames = nickNames;
    }

    public String getNames(){return name;}

    public List<String> getNickNames(){return new ArrayList<String>(nickNames);}

    public static void main(String [] args){
        /**
         * Instantiating the inner class
         */
        Person outer= new Person("",new ArrayList<String>());
        Person.innerClass innerClass = outer.new innerClass();

    }

    /**
     *
     */
    private final class innerClass {
        private String address;
        private String apartmentNumber;


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getApartmentNumber() {
            return apartmentNumber;
        }

        public void setApartmentNumber(String apartmentNumber) {
            this.apartmentNumber = apartmentNumber;
        }
    }
}
