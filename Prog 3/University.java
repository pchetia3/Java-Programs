/**
* Represents a university
* @author pchetia3
* @version 1.0
*/
public class University {


    private String name;
    private Student[] students;
    private Professor[] professors;

    /**
    * a university constructor that takes in the name of the university, an
    * array of students and professors in the university
    * @param name the name of the university
    * @param students the array of students in the university
    * @param professors the array of professors in the university
    *
    */

    public University(String name, Student[] students, Professor[] professors) {
        this.name = name;
        this.students = new Student[50];
        this.professors = new Professor[10];
    }

    /**
    * a method that adds a student to the student array if the student
    * isn't present
    * @param student the student that is to be added if not already present
    */

    public void addStudent(Student student) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {

            if (students[i] != null) {
                count++;
            }
        }
        if (count < students.length) {
            for (int j = 0; j < count; j++) {
                if (!(students[j].equals(student))) {
                    students[count] = student;
                }
            }


        } else if (count == students.length) {
            Student[] newStudents = new Student[students.length * 2];
            for (int k = 0; k < students.length; k++) {
                newStudents[k] = students[k];
            }
            students = newStudents;
            students[count] = student;
        }
    }
    /**
    * a method that adds a professor to the professors array if not already
    * present
    * @param professor that is to be added to the array if not present
    */
    public void addProfessor(Professor professor) {
        int count2 = 0;
        for (int i = 0; i < professors.length; i++) {

            if (professors[i] != null) {
                count2++;
            }
        }
        if (count2 < professors.length) {
            for (int j = 0; j < count2; j++) {
                if (!(professors[j].equals(professor))) {
                    professors[count2] = professor;
                }

            }
        } else if (count2 == professors.length) {
            Professor[] newProfessors = new Professor[professors.length * 2];
            for (int k = 0; k < professors.length; k++) {
                newProfessors[k] = professors[k];
            }
            professors = newProfessors;
            professors[count2] = professor;

        }

    }

    /**
    * a method that removes a student from the students array
    * @param student that is to be added to the array if not present
    * @return true if the student to be removed is present and hence is removed
    */

    public boolean removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && !(students[i].equals(student))) {
                return false;
            } else if (students[i] != null && students[i].equals(student)) {
                int j = i;
                while (students[j] != null && j < students.length) {
                    students[j] = students[j + 1];
                    j++;
                }

            }
        } return true;
    }

    /**
    * a method that returns a string
    * @return a string that is of the format "Professor Smith has a class of 50
    * students teaches Robert is 19 years old from Atlanta with gtid
    * 901317890 in Georgia Tech.
    */


    public String toString() {
        return professors.toString() + " teaches " + students.toString()
            + " in " + this.name + ".";
    }










}