/**
 * Represents a Cafe building that manages inventory and sells coffee.
 */
public class Cafe extends Building implements CafeRequirements {

    /** The number of ounces of coffee remaining in inventory */
    private int nCoffeeOunces;
    /** The number of sugar packets remaining in inventory */
    private int nSugarPackets;
    /** The number of "splashes" of cream remaining in inventory */
    private int nCreams;
    /** The number of cups remaining in inventory */
    private int nCups;

    /**
     * Constructor for the Cafe.
     * @param name The name of the cafe
     * @param address The address of the cafe
     * @param nFloors The number of floors (usually 1)
     * @param nCoffeeOunces Initial coffee inventory in ounces
     * @param nSugarPackets Initial sugar packet inventory
     * @param nCreams Initial cream inventory
     * @param nCups Initial cup inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Sells a cup of coffee by decreasing the inventory. 
     * If there are not enough ingredients, it triggers a restock.
     * @param size The amount of coffee requested (ounces)
     * @param nSugarPackets The number of sugar packets requested
     * @param nCreams The number of creams requested
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // Check if we have enough inventory. If not, restock before selling.
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || 
            this.nCreams < nCreams || this.nCups < 1) {
            this.restock(64, 50, 50, 20); // Arbitrary restock amounts
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        
        System.out.println("Coffee sold! Remaining coffee: " + this.nCoffeeOunces + "oz");
    }

    /**
     * Increases the inventory when stocks are low.
     * This method is private so it can only be called from within the Cafe class.
     * @param nCoffeeOunces Ounces of coffee to add
     * @param nSugarPackets Sugar packets to add
     * @param nCreams Creams to add
     * @param nCups Cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Inventory restocked.");
    }

    /**
     * Main method for testing the Cafe class.
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("The Compass", "Neilson Library", 1, 100, 100, 100, 100);
        myCafe.sellCoffee(12, 2, 3);
        System.out.println(myCafe);
    }
}