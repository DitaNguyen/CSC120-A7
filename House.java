import java.util.ArrayList;

/**
 * Represents a residential building that tracks its residents and dining facilities.
 */
public class House extends Building implements HouseRequirements {

    /** The list of Students currently residing in the house */
    private ArrayList<Student> residents; 
    /** Whether or not the house has a dining room */
    private boolean hasDiningRoom;

    /**
     * Constructor for House.
     * @param name The name of the house
     * @param address The address of the house
     * @param nFloors The number of floors in the house
     * @param hasDiningRoom Boolean indicating if the house has a dining room
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<Student>();
        this.hasDiningRoom = hasDiningRoom;
    }

    /**
     * Accessor for dining room status.
     * @return true if the house has a dining room, false otherwise
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Accessor for the number of residents.
     * @return the current count of residents
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Adds a student to the house's resident list.
     * @param s The Student object moving in
     */
    public void moveIn(Student s) {
        this.residents.add(s);
    }

    /**
     * Removes a student from the house's resident list.
     * @param s The Student object moving out
     * @return The Student object who moved out
     * @throws RuntimeException if the student is not a resident
     */
    public Student moveOut(Student s) {
        if (this.isResident(s)) {
            this.residents.remove(s);
            return s;
        } else {
            throw new RuntimeException(s + " does not live in this house.");
        }
    }

    /**
     * Checks if a specific Student is a resident of the house.
     * @param s The Student object to check
     * @return true if they are a resident, false otherwise
     */
    public boolean isResident(Student s) {
        return this.residents.contains(s);
    }

    /**
     * Provides a description of the house including dining info.
     * @return Formatted string describing the house
     */
    @Override
    public String toString() {
        String description = super.toString();
        description += ". It " + (this.hasDiningRoom ? "has" : "does not have") + " a dining room.";
        return description;
    }

    /**
     * Main method for testing the House class.
     */
    public static void main(String[] args) {
        House smith = new House("Smith House", "123 Elm St", 3, true);
        // Assuming you have a Student class constructor that takes a name
        // Student jordan = new Student("Jordan"); 
        // smith.moveIn(jordan);
        System.out.println(smith);
    }
}