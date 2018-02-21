/**
* Represents a professor
* @author pchetia3
* @version 1.0
*/

public class Professor extends Person {

    private int classSize; // the class size of the professors class
    private String[] classes; // array of classes they teach

    /**
    * a Professor constructor that takes in the class size, an array of
    * classes and instance variables from the person super class
    * @param classSize the classSize of the class the professor is teaching
    * @param classes an array of classes the professor is teaching
    * @param n the name of the student
    * @param a the age of the student
    * @param h the homeTown of the student
    */

    public Professor(int classSize, String[] classes, String n,
        int a, String h) {
        super(n, a, h);
        this.classSize = classSize;
        this.classes = new String[10];
    }

    /**
    * a method to return the array of classes the professor is teaching
    * @return classes the array of classes the professor is teaching
    */

    public String[] getClasses() {
        return this.classes;
    }

    /**
    * a method that returns a string
    * @return a string that is of the format "Professor Smith has a class of 50
    * students"
    */

    public String toString() {
        return "Professor " + super.getName() + " has a class of " + classSize
            + " students";
    }

    /**
    * a method that overrides the equals method to check name, age, homeTown
    * and classSize.
    * @return a boolean that returns true if the name, age, hometown and
    * classSize is equal for two professors.
    */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Professor)) {
            return false;
        }
        Professor professor = (Professor) other;
        return super.equals(professor) && this.classSize == professor.classSize;
    }


}