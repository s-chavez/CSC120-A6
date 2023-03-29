import java.util.Hashtable;

public class Library extends Building {

  private Hashtable < String, Boolean > collection;
  /**
   * Constructor for Library
   * @param name Name of the Library
   * @param address Address of the Library
   * @param nFloors Number of floors in the Library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable < String, Boolean > ();
    System.out.println("You have built a library!");
  }
  /**
   * Updates the Library's collection to add the title
   * @param title The title of the given book
   */
  public void addTitle(String title) {
    if (this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is already a part of the collection.");
    } else {
      this.collection.put(title, true);
    }
  }
  /**
   * Updates the Library's collection to remove the title
   * @param title The title of the given book
   * @return The title of the book that was removed
   */
  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      return title;
    } else {
      throw new RuntimeException(title + " was never in this collection.");
    }
  }
  /**
   * Checks out the book by changing boolean to false
   * @param title The title of the given book
   */
  public void checkOut(String title) {
    this.collection.replace(title, true, false);
  }
  /**
   * Returns the book by changing the boolean to true
   * @param title The title of the given book
   */
  public void returnBook(String title) {
    this.collection.replace(title, false, true);
  }
  /**
   * Checks the Library's collection for the given book's title
   * @param title The title of the given book
   * @return The boolean of whether the book appears as a key in the Library's collection
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Checks the Library's collection to see if the book is available
   * @param title The title of the given book
   * @return The boolean of whether the book is currently available
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      System.out.println(title + " is available.");
      return true;
    } else {
      System.out.println(title + " is not available.");
      return false;
    }
  }
  /**
   * Prints out the Library's collection including checkout status
   */
  public void printCollection() {
    for (String key: this.collection.keySet()) {
      if (this.collection.get(key) == true) {
        System.out.println(key + " is currently available.");
      } else {
        System.out.println(key + " is currently not available.");
      }
    }
  }
  /**
   * Main method created to test methods
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Library neilsonLibrary = new Library("neilson", "smith", 4);
    neilsonLibrary.addTitle("Harry Potter");
    neilsonLibrary.addTitle("Hunger Games");
    neilsonLibrary.addTitle("Pinnochio");
    System.out.println(neilsonLibrary.isAvailable("Harry Potter"));
    neilsonLibrary.checkOut("Harry Potter");
    System.out.println(neilsonLibrary.isAvailable("Harry Potter"));
    neilsonLibrary.printCollection();
  }
}