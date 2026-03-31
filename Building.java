/**
 * Represents a general building with a name, address, and number of floors.
 * This serves as the parent class for more specific building types.
 */
public class Building implements BuildingRequirements {

    /** The name of the building */
    protected String name = "<Name Unknown>";
    /** The physical address of the building */
    protected String address = "<Address Unknown>";
    /** The number of floors in the building (must be >= 1) */
    protected int nFloors = 1;

    /**
     * Constructor for Building
     * @param name The name of the building
     * @param address The physical location
     * @param nFloors The total number of floors
     * @throws RuntimeException if nFloors is less than 1
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { 
            this.name = name; 
        }
        if (address != null) { 
            this.address = address; 
        } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /** @return the building's name */
    public String getName() {
        return this.name;
    }

    /** @return the building's address */
    public String getAddress() {
        return this.address;
    }

    /** @return the number of floors in the building */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Provides a description of the building
     * @return Formatted string with name, floor count, and address
     */
    @Override
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Main method for testing the Building class
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }
}