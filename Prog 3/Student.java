/**
* Represents a student
* @author pchetia3
* @version 1.0
*/
public class Student extends Person {

    private double avgGPA;
    private int gtID;
    private String[] classes;
    /**
    * a student constructor that takes in the average GPA, gtID, an array of
    * classes and instance variables from the person super class
    * @param avgGPA the average GPA of the student
    * @param gtID the gtid of the student
    * @param classes an array of classes the student is currently taking
    * @param n the name of the student
    * @param a the age of the student
    * @param h the homeTown of the student
    */

    public Student(double avgGPA, int gtID, String[] classes, String n,
        int a, String h) {
        super(n, a, h);
        this.avgGPA = avgGPA;
        this.gtID = gtID;
        this.classes = new String[5];
    }

    /**
    * a method that returns the average GPA of the student
    * @return avgGPA the average GPA of the student
    */

    public double getAvgGPA() {
        return this.avgGPA;
    }

    /**
    * a method that returns the array of classes the student is taking
    * @return classes the array of classes the student is taking
    */

    public String[] getClasses() {
        return this.classes;
    }

    /**
    * a method that returns the gtID of the student
    * @return gtID the gtid of the student
    */


    public int getGTID() {
        return this.gtID;
    }

    /**
    * a method that overrides the toString method of the person super class
    * @return a string that is of the format "name is age years old
    * from homeTown with gtid gtID"
    */

    @Override
    public String toString() {
        return super.toString() + " with gtid " + this.gtID;
    }
    /**
    * a method that overrides the equals method to check name, age, homeTown
    * and gtID
    * @return a boolean that returns true if the name, age, hometown and gtID is
    * equal for two persons.
    */
    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Student)) {
            return false;
        }
        Student student = (Student) object;
        return super.equals(student) && this.gtID == student.gtID;
    }

}