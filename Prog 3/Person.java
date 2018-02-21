/**
* Represents a person
* @author pchetia3
* @version 1.0
*/

public class Person {

    private String name;
    private int age;
    private String homeTown;


    /**
    * a method to return the name of the person
    * @return name the name of the person
    */


    public String getName() {
        return this.name;
    }

    /**
    * a method to return the age of the person
    * @return age the age of the person
    */

    public int getAge() {
        return this.age;
    }

    /**
    * a method to return the homeTown of the person
    * @return homeTown the homeTown of the person
    */

    public String getHomeTown() {
        return this.homeTown;
    }

    /**
    * a method to return a string
    * @return a string of the form "name is age years old from homeTown"
    */

    public String toString() {
        return this.name + " is " + this.age + " years old from "
            + this.homeTown;
    }

    /**
    * a method that overrides the equals method to check name, age and homeTown
    * @return a boolean that returns true if the name, age and hometown is
    * equal for two persons.
    */

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Person)) {
            return false;
        }
        Person that = (Person) other;
        return this.name.equals(that.name) && this.age == that.age
            && this.homeTown.equals(that.homeTown);
    }

    /**
    * a person constructor that takes in the name of the person
    * @param name the name of the person
    */

    public Person(String name) {
        this.name = name;
        this.age = 18;
        this.homeTown = "Atlanta";
    }

    /**
    * a person constructor that takes in the name and age of the person
    * @param name the name of the person
    * @param age the age of the person
    */


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.homeTown = "Atlanta";
    }

    /**
    * a person constructor that takes in the name, age and homeTown of the
    * person
    * @param name the name of the person
    * @param age the age of the person
    * @param homeTown the hometown of the person
    */

    public Person(String name, int age, String homeTown) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
    }



}


