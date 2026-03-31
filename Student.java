import java.util.ArrayList;

/**
 * Represents a student with a name, ID, class year, and a list of enrolled courses.
 */
public class Student {

    /** The student's full name */
    private String name; 
    /** The student's unique identification number */
    private String id; 
    /** The year the student is expected to graduate */
    private int classYear; 
    /** The list of Course objects the student is currently taking */
    private ArrayList<Course> classes; 

    /**
     * Constructor for Student.
     * @param name The student's full name
     * @param id The unique student ID
     * @param classYear The graduation year
     */
    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<Course>(); 
    }

    /**
     * Adds a course to the student's current schedule.
     * @param c The Course object to add
     */
    public void takeCourse(Course c) {
        this.classes.add(c);
    }

    /** @return the student's name */
    public String getName() {
        return this.name; 
    }

    /** @return the student's unique ID */
    public String getId() {
        return this.id;
    }

    /** @return the student's graduation year */
    public int getClassYear() {
        return this.classYear;
    }

    /**
     * Provides a description of the student.
     * @return Formatted string with name, ID, and year
     */
    @Override
    public String toString() {
        return this.name + " (ID: " + this.id + ", Class of " + this.classYear + ")";
    }

    /**
     * Main method for testing the Student class.
     */
    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2029);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        
        ab.takeCourse(csc120);
        
        System.out.println(ab);
        System.out.println("Enrolled in: " + ab.classes);
    }
}