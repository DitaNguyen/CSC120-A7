import java.util.Hashtable;

/**
 * Represents a Library building that manages a collection of books
 * using a Hashtable to track availability.
 */
public class Library extends Building implements LibraryRequirements {

  /** The collection of books: Key = Title (String), Value = Available (Boolean) */
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for Library.
   * @param name The name of the library
   * @param address The address of the library
   * @param nFloors The number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Adds a new title to the collection. 
   * New books are available (true) by default.
   * @param title The title and author of the book
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Removes a title from the collection.
   * @param title The title to be removed
   * @return The title that was removed
   * @throws RuntimeException if the title is not in the collection
   */
  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      return title;
    } else {
      throw new RuntimeException("Error: '" + title + "' is not in the collection.");
    }
  }

  /**
   * Checks out a book by setting its availability to false.
   * @param title The title to check out
   */
  public void checkOut(String title) {
    if (this.isAvailable(title)) {
      this.collection.replace(title, false);
      System.out.println("You have checked out: " + title);
    } else {
      System.out.println("Sorry, " + title + " is currently unavailable.");
    }
  }

  /**
   * Returns a book by setting its availability to true.
   * @param title The title to return
   */
  public void returnBook(String title) {
    if (this.containsTitle(title)) {
      this.collection.replace(title, true);
      System.out.println("Thank you for returning: " + title);
    }
  }

  /**
   * Checks if the library owns a specific title.
   * @param title The title to look for
   * @return true if the title exists in the Hashtable
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Checks if a title is currently available for checkout.
   * @param title The title to check
   * @return true if available, false if checked out or not in collection
   */
  public boolean isAvailable(String title) {
    return this.collection.getOrDefault(title, false);
  }

  /**
   * Prints the entire library collection and its status in a readable format.
   */
  public void printCollection() {
    System.out.println("--- " + this.getName() + " Collection ---");
    if (this.collection.isEmpty()) {
      System.out.println("The collection is currently empty.");
    } else {
      this.collection.forEach((title, available) -> {
        String status = available ? "[Available]" : "[Checked Out]";
        System.out.println(status + " " + title);
      });
    }
  }

  /**
   * Main method for testing the Library class.
   */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
    neilson.addTitle("The Lorax by Dr. Seuss");
    neilson.addTitle("Java Programming by John Smith");
    
    neilson.checkOut("The Lorax by Dr. Seuss");
    neilson.printCollection();
  }
}