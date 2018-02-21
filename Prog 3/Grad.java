/**
* Represents a grad student
* @author pchetia3
* @version 1.0
*/
public class Grad extends Student {



    private String thesisTitle;

    /**
    * a grad constructor that takes in the thesisTitle and instance variables of
    * its student super class.
    * @param thesisTitle the title of his thesis
    * @param avgG the average GPA of the student
    * @param id the gtid of the student
    * @param cl an array of classes the student is currently taking
    * @param n the name of the student
    * @param a the age of the student
    * @param h the homeTown of the student
    */

    public Grad(String thesisTitle, double avgG, int id, String[] cl, String n,
        int a, String h) {
        super(avgG, id, cl, n, a, h);
        this.thesisTitle = thesisTitle;
    }

    /**
    * a method that returns the thesis title
    * @return thesisTitle the thesis title
    */

    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
    * a method that overrides the toString method of the student super class
    * @return a string that is of the format "grad name is age years old
    * from homeTown with gtid gtID "
    */

    @Override
    public String toString() {
        return "grad " + super.toString();
    }

    /**
    * a method that overrides the equals method to check name, age, homeTown
    * gtID and thesisTitle
    * @return a boolean that returns true if the name, age, hometown, gtID and
    * thesisTitle is equal for two persons.
    */

    @Override
    public boolean equals(Object object) {
        if (!(this instanceof Grad)) {
            return false;
        }
        Grad grad = (Grad) object;
        return super.equals(grad) && this.thesisTitle.equals(grad.thesisTitle);
    }
}