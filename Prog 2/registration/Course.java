package registration;
/**
*
* Represents a course the student can register or get waitlisted for
*
* @author pchetia3
* @version 1.0
*/

public class Course {
    private static int numCoursesOffered; // static variable counting the no. of
    //courses being offered by the uni
    private int courseNumber; // course no. of the course
    private Department dept; // department offering the class
    private int credits; // no. of credits the course is worth
    private int classSize; // max class size of the class, beyond class size
    //classSize students should be waitlisted
    private int waitlistCap; //max length of the waitlist
    private Student[] registeredStudents; // students signed up as well as those
    //waitlisted
    private int numStudentsRegistered; // num of students registered for class
    private LectureTime time; // time of the course
/**
 * Creates a course that a student can register for or get waitlisted for
 *
 * @param dept the department of the course
 * @param courseNumber the number for the course
 * @param credits the number of credits of the course
 * @param classSize the size of the class for the course
 * @param waitlistCap the size of the waitlist for the course
 * @param time the lecture time of the course
 *
 */

    public Course(Department dept, int courseNumber,
        int credits, int classSize, int waitlistCap, LectureTime time) {
        this.dept = dept;
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.classSize = classSize;
        this.waitlistCap = waitlistCap;
        this.time = time;
        this.registeredStudents = new Student[classSize + waitlistCap];
        this.numStudentsRegistered = 0;
        numCoursesOffered++;
    }

/**
     * @return the number of courses offered
     */
    public static int getNumCoursesOffered() { //use
        return numCoursesOffered;

    }
/**
     * @return the number of credits the course is worth
     */

    public int getCredits() {
        return this.credits;
    }
    /**
         * @return the department offering the class
         */
    public Department getDept() {
        return this.dept;
    }

    /**  * sets the department of the course
         * @param the department offering the class
         */


    //public void setDept(Department dept) {
        //this.dept = dept;
    //}
    /**
         * @return the list of students registered for the class.
         */
    public Student[] getRegisteredStudents() {
        return this.registeredStudents;

    }
    /**
         * @return the number of students that are registered for class
         */
    public int getNumStudentsRegistered() {
        return this.numStudentsRegistered;
    }
    /**
         * @return the time of the lecture
         */


    public LectureTime getTime() {
        return this.time;
    }

    /**
         * @return the max size of the class
         */

    public int getClassSize() {
        return this.classSize;
    }

    /**
         * sets the size of the class
         *
         * @param size the current size of the class
         * @return true size is less than the max size of the class
         */

    public boolean setClassSize(int size) {
        if (size <= classSize) {
            return false;

            //resize registeredStudents
            //promotedFromWaitlist()
        } else {


            Student[] temp = new Student[size + waitlistCap];
            for (int i = 0; i < registeredStudents.length; i++) {
                temp[i] = registeredStudents[i];
            }
            registeredStudents = temp;


            for (int i = classSize; i < size && i < numStudentsRegistered; i++)
            {
                registeredStudents[i].promotedFromWaitlist(this);
            } classSize = size;

        }
        return true;
    }

    /**
         * Determines the student at the ith position
         *
         * @param i the position of the student
         * @return the student at the ith position
         */

    public Student getRegisteredPosition(int i) {
        //student registered
        if (i >= registeredStudents.length || registeredStudents[i] == null) {
            return null;
        } else {
            return registeredStudents[i];
        }

    }

    /**
         * adds the student to the registeredStudents array anf returns true
         *
         * @param student the student who is added to the array
         * @return returns true if student is added and false if the operation
         *fails
         */
    protected boolean addStudent(Student student) {
        // add student and increase the
        //num of students resgistered
        if (registeredStudents.length <= numStudentsRegistered) {
            return false;
        } else if (student.getCredits() + this.credits > 18) {
            return false;
        } else if (student.registeredForCourse(this)) {
            return false;
        } else if (!student.availableAt(time)) {
            return false;
        } else if (student.getNumCoursesWaitlisted() >= 5
            && numStudentsRegistered >= classSize) {
            return false;
        } else if (numStudentsRegistered >= classSize) {
            registeredStudents[numStudentsRegistered] = student;
            student.waitlist(this);
            numStudentsRegistered++;
        } else {
            registeredStudents[numStudentsRegistered] = student;
            student.register(this);
            numStudentsRegistered++;
        }
        return true;
    }





    /**
         * a string that returns the department and its course number
         *
         * @return returns the department and its courseNumber as "CS1331"
         * where CS
         * is the department and 1331 the course number
         */

    public String toString() {

        return (dept.toString() + courseNumber);
    }
}