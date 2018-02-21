/**
* Represents an undergrad student
* @author pchetia3
* @version 1.0
*/
public class Undergrad extends Student {


    private int sleepHours;

    /**
    * an undergrad constructor that takes in the sleep hours and instance
    * variables from the student super class
    * @param sleepHours the hours of sleep an undergrad gets
    * @param avgG the average GPA of the student
    * @param id the gtid of the student
    * @param cl an array of classes the student is currently taking
    * @param n the name of the student
    * @param a the age of the student
    * @param h the homeTown of the student
    */

    public Undergrad(int sleepHours, double avgG, int id, String[] cl, String n,
        int a, String h) {
        super(avgG, id, cl, n, a, h);
        this.sleepHours = sleepHours;
    }

    /**
    * a method that returns the number of hours of sleep an undergrad gets
    * @return sleepHours the hours of sleep an undergrad gets
    */

    public int getSleepHours() {
        return this.sleepHours;
    }

    /**
    * a method that overrides the toString method of the student super class
    * @return a string that is of the format "undergrad name is age years old
    * from homeTown with gtid gtID is only sleeping sleepHours hours per night "
    */

    @Override
    public String toString() {
        return "undergrad " + super.toString() + " is only sleeping "
            + sleepHours + " hours per night";

    }
    /**
    * a method that overrides the equals method to check name, age, homeTown
    * gtID and sleepHours
    * @return a boolean that returns true if the name, age, hometown, gtID and
    * sleepHours is equal for two persons.
    */

    @Override
    public boolean equals(Object object) {
        if (!(this instanceof Undergrad)) {
            return false;
        }
        Undergrad undergrad = (Undergrad) object;
        return super.equals(undergrad)
            && this.sleepHours == undergrad.sleepHours;
    }

}

