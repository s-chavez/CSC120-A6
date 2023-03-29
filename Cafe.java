public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    /**
     * Constructor for Cafe
     * @param name The name of the Cafe
     * @param address The address of the Cafe
     * @param nFloors The number of floors in the Cafe
     * @param nCoffeeOunces The number of coffee ounces remaining in the Cafe's inventory
     * @param nSugarPackets The number of sugar packets remaining in the Cafe's inventory
     * @param nCreams The number of "splashes" of cream remaining in the Cafe's inventory
     * @param nCups The number of cups remaining in the Cafe's inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      super(name, address, nFloors);
      this.nCoffeeOunces = nCoffeeOunces;
      this.nSugarPackets = nSugarPackets;
      this.nCreams = nCreams;
      this.nCups = nCups;
      System.out.println("You have built a cafe!");
    }
    /**
     * Decreases inventory in each category by given parameters and restocks if necessary
     * @param size The size of coffee requested 
     * @param nSugarPackets The number of sugar packets requested
     * @param nCreams The number of creams requested
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
      if (this.nCoffeeOunces < size) {
        this.restock(50, 0, 0, 0);
      }
      if (this.nSugarPackets < nSugarPackets) {
        this.restock(0, 50, 0, 0);
      }
      if (this.nCreams < nCreams) {
        this.restock(0, 0, 50, 0);
      }
      if (this.nCups < nCups) {
        this.restock(0, 0, 0, 50);
      } else {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups = nCups - 1;
      }
      System.out.println("Here is your " + size + " oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams, enjoy!");
    }
    /**
     * Restocks inventory in each of the given parameters 
     * @param nCoffeeOunces The number of coffee ounces to be restocked
     * @param nSugarPackets The number of sugar packets to be restocked
     * @param nCreams The number of creams to be restocked
     * @param nCups The number of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
    }
    /**
     * Main method created to test methods
     * @param args The command line arguments
     */
    public static void main(String[] args) {
      Cafe compassCafe = new Cafe("Compass", "Smith", 1, 100, 100, 100, 100);
      compassCafe.sellCoffee(10, 3, 2);
      System.out.println("There are " + compassCafe.nCoffeeOunces + " ounces of coffee left.");
      System.out.println("There are " + compassCafe.nSugarPackets + " sugar packets left.");
      System.out.println("There are " + compassCafe.nCreams + " creams left.");
      System.out.println("There are " + compassCafe.nCups + " cups left.");
      compassCafe.sellCoffee(91, 98, 100);
      System.out.println("There are " + compassCafe.nCoffeeOunces + " ounces of coffee left.");
      System.out.println("There are " + compassCafe.nSugarPackets + " sugar packets left.");
      System.out.println("There are " + compassCafe.nCreams + " creams left.");
      System.out.println("There are " + compassCafe.nCups + " cups left.");
    }
}