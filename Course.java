import java.util.ArrayList;

/**
 * Represents an academic course, including its schedule and enrolled students.
 */
public class Course {

    /* Attributes */
    private String name;
    private String subjectNumber;
    private String meetingTime; 
    private ArrayList<String> roster; // To track students, similar to House residents

    /**
     * Constructor for Course
     * @param name The full title of the course
     * @param subjectNumber The department code (e.g., CSC120)
     * @param meetingTime The days and times the course meets
     */
    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime; 
        this.roster = new ArrayList<String>();
    }

    /* Accessors */

    /** @return the course title */
    public String getName() {
        return this.name;
    }

    /** @return the department code and number */
    public String getSubjectNumber() {
        return this.subjectNumber;
    }

    /** @return the scheduled meeting time */
    public String getMeetingTime() {
        return this.meetingTime;
    }

    /* Methods */

    /**
     * Adds a student to the course roster
     * @param studentName Name of the student to enroll
     */
    public void enroll(String studentName) {
        this.roster.add(studentName);
    }

    /**
     * Provides a string representation of the course
     * @return Formatted string with code, name, and time
     */
    @Override
    public String toString() {
        return this.subjectNumber + ": " + this.name + " (" + this.meetingTime + ")"; 
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        Course csc120 = new Course("Object-Oriented Programming", "CSC120", "TR 10:50");
        csc120.enroll("Jordan");
        System.out.println(csc120);
    }
}