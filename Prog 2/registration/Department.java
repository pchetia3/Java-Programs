package registration;
/**
 * Represents the department for the class
 *
 * @author pchetia3
 * @version 1.0
 */

public enum Department {
    COMPUTERSCIENCE ("CS"),
    MATHEMATICS ("MATH"),
    PHYSICS ("PHYS"),
    ELECTRICALENGINEERING ("EE"),
    LITERATUREMEDIAANDCOMMUNICATION ("LMC");

    /**
     * Creates a subject department
     *
     * @param department the department of the class
     *
     */
    private String department;
    Department(String department) {
        this.department = department;
    }

    /**
     * Creates a toString method to return the abbreviation of a department
     *
     *@return returns the abbreviation of the respective department
     *
     */

    public String toString() {
        return this.department;
    }


}
