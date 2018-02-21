import java.util.Comparator;
//import java.lang.Comparable;


/**
* Minion class.
* @author pchetia3
* @version 1
*/
public class Minion implements Comparable<Minion> {
    private String name;
    private double height;
    private int iQLevel;

    /**
    * a constructor of the Minion class.
    * @param name the name of the Minion
    * @param height the height of the Minion
    * @param iQLevel the IQ level of the Minion
    */

    public Minion(String name, double height, int iQLevel) {
        this.name = name;
        this.height = height;
        this.iQLevel = iQLevel;
    }

    /**
    * a getter method that returns the name of the Minion
    * @return name the name of the Minion
    */
    public String getName() {
        return this.name;
    }

    /**
    * a getter method that returns the height of the Minion
    * @return height the height of the Minion
    */

    public double getHeight() {
        return this.height;
    }

    /**
    * a getter method that returns the IQ of the Minion
    * @return iQLevel the iQLevel of the Minion
    */

    public int getIQLevel() {
        return this.iQLevel;
    }

    //Minions should be compared by name for natural ordering.
    @Override
    public int compareTo(Minion m) {
        return name.compareTo(m.getName());
    }


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Minion)) {
            return false;
        }
        Minion minion = (Minion) other;
        return this.getName().equals(minion.getName())
            &&  this.getHeight() == minion.getHeight()
            &&  this.getIQLevel() == minion.getIQLevel();
    }
    /*Properly overridden toString method.
    This should return a String in the format
    “name has IQ of iQLevel and height of height cm.”.
    The height must be rounded to 2 decimal places.*/
    @Override
    public String toString() {
        return this.getName() + " has IQ of " + this.getIQLevel()
            + " and height of " + Math.round(this.getHeight() * 100.0) / 100.0
            + " cm.";
    }

    /*properly overridden hashCode method.
    If object1 and object2 are equal according to their equals method,
    they must also have the same hashCode.
    A good hash function will give different hashCodes
    for objects that are not equal.
    */
    @Override
    public int hashCode() {
        int result1 = 0;
        int result2;
        for (int i = 0; i < this.getName().length(); i++) {
            result1 += this.getName().charAt(i) - 'A';
        }
        result2 = (int) this.getHeight() * 31 + this.getIQLevel() * 17;

        return result1 + result2;
    }
    /**
    * A MinionComparatorbyHeight class that compares minions by height
    *
    */
    class MinionComparatorbyHeight implements Comparator<Minion> {
        public int compare(Minion m1, Minion m2) {
            return (int) m1.getHeight() - (int) m2.getHeight();
        }
    }

    /**
    * A MinionComparatorbyIQ class that compares minions by IQ
    *
    */

    class MinionComparatorbyIQ implements Comparator<Minion> {
        public int compare(Minion m3, Minion m4) {
            return m3.getIQLevel() - m4.getIQLevel();
        }
    }


    /**
    * A comparator with Minion type parameter compares minions by height
    * @return MinionComparatorbyHeight that has the compare method to compare
    * minions by height
    */

    public Comparator<Minion> compareByHeight() {
        return new MinionComparatorbyHeight();
    }
    /**
    * A comparator with Minion type parameter compares minions by IQ
    * @return MinionComparatorbyIQ that has the compare method to compare
    * minions by IQ
    */
    public Comparator<Minion> compareByIQ() {
        return new MinionComparatorbyIQ();
    }





}