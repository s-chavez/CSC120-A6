public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;
    /**
     * Constructor for Building
     * @param name The name of the Building
     * @param address The address of the Building
     * @param nFloors The Building's number of floors
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
    /**
     * Accessor for Building's name
     * @return Name of the building
     */
    public String getName() {
      return this.name;
    }
    /**
     * Accessor for Building's address
     * @return Address of the building
     */
    public String getAddress() {
      return this.address;
    }
    /**
     * Accessor for Building's number of floors
     * @return Number of floors
     */
    public int getFloors() {
      return this.nFloors;
    }
    /**
     * Creates a formatted description of the Building
     * @return The formatted description
     */
    public String toString() {
      return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }
    /**
     * Main method created to test methods
     * @param args The command line arguments
     */
    public static void main(String[] args) {
      Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
      System.out.println(fordHall);
    }
}