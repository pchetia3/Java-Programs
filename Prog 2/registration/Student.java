package registration;

/**
 * Represents of a student able to register for courses
 *
 * @author pchetia3
 * @version 1.0
 */
public class Student {
    private Course[] courses;  // problems with resizing
    private Course[] waitlists;
    private int numCoursesRegistered;
    private int numCoursesWaitlisted;
    private int credits;
    private String name;

    /**
    * Creates a student who has a name
    * @param name the name of the student
    *
    **/
    public Student(String name) {
        this.name = name;
        this.courses = new Course[5];  // problems with resizing
        this.waitlists = new Course[5];
        this.numCoursesRegistered = 0;
        this.numCoursesWaitlisted = 0;
        this.credits = 0;


    }

    /**
     * Creates a getter for name of the student
     *
     * @return this.name the name of the student
     */

    public String getName() {
        return this.name;
    }

    /**
     * Creates a getter method for the credits of the student
     *@return this.credits the total credits for the classes registered and the
     *classes waitlisted
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Creates a getter method for number of courses registered
     *
     * @return this.numCoursesRegistered the number of courses registered for
     */

    public int getNumCoursesRegistered() {
        return this.numCoursesRegistered;
    }

    /**
     * Creates a getter method for number of courses waitlisted
     *
     * @return this.numCoursesWaitlisted the number of courses waitlisted for
     */
    public int getNumCoursesWaitlisted() {
        return this.numCoursesWaitlisted;
    }

    /**
     * Creates a getter method for courses registered
     *
     * @return this.courses the courses registered for
     */
    public Course[] getCourses() {
        return this.courses;
    }

    /**
     * Creates a getter method for courses waitlisted
     *
     * @return this.waitlists the courses waitlisted for
     */
    public Course[] getWaitlists() {
        return this.waitlists;
    }
    /**
     * A method that determines if the student is available at the lecture time.
     *
     *@param time the time when the student is checked for availability
     *@return true is the student does not have class and false otherwise
     */

    public boolean availableAt(LectureTime time) {
        for (Course c : courses) {

            if (c != null && c.getTime().overlap(time)) {
                return false;
            }
        }

        for (Course w : waitlists) {
            if (w != null && w.getTime().overlap(time)) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method to resize the courses array if full
     *
     * @param courses The courses array that is full
     * @return Whether or not the operation was successful
     */



    /**
     * A method that adds course to courses array
     *
     *@param course the course the student registered for
     *
     */
    protected void register(Course course) {

        if (numCoursesRegistered < courses.length) {
            courses[numCoursesRegistered] = course;
            numCoursesRegistered++;
            this.credits += course.getCredits();
        } else if (numCoursesRegistered >= courses.length) {
            Course[] tmp = new Course[2 * courses.length];
            for (int i = 0; i < courses.length; i++) {
                tmp[i] = courses[i];
            }
            courses = tmp;
            courses[numCoursesRegistered] = course;
            numCoursesRegistered++;
            this.credits += course.getCredits();
        }
    }
    /**
     * Determines if the waitlists array has more than or equal to 5
     * courses
     *
     * @param course The course that the student is to be chceked whether
     * waitlisted for
     * @return Whether or not the waitlists has 5 or more courses
     * and adds the course if not
     */



    protected boolean waitlist(Course course) {


        if (numCoursesWaitlisted >= 5) {
            return false;
        } else {
            waitlists[numCoursesWaitlisted] = course;
            numCoursesWaitlisted++;
            this.credits += course.getCredits();
        }
        return true;
    }
    /**
     * Determines if a student is taking or waitlisted for a course
     *
     * @param course The course that we check if the student is registered for
     * or waitlisted
     * @return true is the student is taking or waitlisted for the course, false
     * otherwise
     */


    public boolean registeredForCourse(Course course) {
        for (Course c : courses) {
            if (c != null && c == course) {
                return true;
            }
        }
        for (Course w : waitlists) {
            if (w != null && w == course) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method to get the student's name
     *
     * @return student's name
     */

    public String toString() {
        return name;
    }

/**
     * A wrapper method for course's addStudent method
     *
     * @param course The course that the student is attempting to register for
     * @return Whether or not the operation was successful
     */
    public boolean signUp(Course course) {
        return course.addStudent(this);
    }
    /**
     * Removes a course from waitlists classes and add it to courses
     *
     * @param course the course in which the student has been
     * promoted from the waitlist
     *
     * @return Whether or not the operation was successful
     */
    protected boolean promotedFromWaitlist(Course course) {
        for (int i = 0; i < numCoursesWaitlisted; i++) {
            if (course == waitlists[i]) {
                for (int j = i + 1; j < numCoursesWaitlisted; j++) {
                    waitlists[j - 1] = waitlists[j];
                }
                numCoursesWaitlisted--;
                waitlists[numCoursesWaitlisted] = null;
                credits -= course.getCredits();
                register(course);
                return true;
            }
        }
        return false;
    }
}
