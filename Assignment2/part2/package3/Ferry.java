package part2.package3;

import part2.package1.PublicTransportation;

/**
 * Ferry class which inherits from PublicTransportation class
 */
public class Ferry extends PublicTransportation {
    private int buildYear;
    private String shipName;

    /**
     * get buildYear of Ferry object
     * @return buildYear of Ferry object
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**
     * set new value to buildYear
     * @param buildYear stores new buildYear
     */
    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    /**
     * get shipName of Ferry object
     * @return shipName of Ferry object
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * set new value to shipName
     * @param shipName stores new shipName
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     * Default constructor of Ferry
     */
    public Ferry(){
        super();
        this.buildYear = 0;
        this.shipName = "";
    }

    /**
     * Constructor that initializes the Metro object with specific values
     * @param ticketPrice stores initial ticketPrice
     * @param noOfStops stores initial noOfStops
     * @param buildYear  stores initial buildYear
     * @param shipName stores initial shipName
     */
    public Ferry(double ticketPrice, int noOfStops, int buildYear, String shipName) {
        super(ticketPrice, noOfStops);
        this.buildYear = buildYear;
        this.shipName = shipName;
    }

    /**
     * Copy constructor that initializes Ferry object by copying an existing Ferry object
     * @param f stores Ferry to be copied from
     */
    public Ferry(Ferry f){
        super(f.getTicketPrice(), f.getNoOfStops());
        this.buildYear = f.buildYear;
        this.shipName = f.shipName;
    }

    /**
     * toString method displaying attributes of the Ferry object
     * @return String with attributes of the Ferry Object
     */
    @Override
    public String toString(){
        return "This Ferry has " + getNoOfStops() + " stops, and costs $"+ getTicketPrice() +'.' +
                " Build year is " + buildYear +" and the ship name is "+ shipName;
    }

    /**
     * equals method comparing two objects
     * @param obj stores other object being compared to
     * @return boolean value of true if both objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || this.getClass()==obj.getClass()) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Ferry ferry = (Ferry) obj;
        return this.getTicketPrice() == ferry.getTicketPrice() &&
                this.getNoOfStops() == ferry.getNoOfStops() &&
                this.buildYear == ferry.buildYear &&
                this.shipName.equals(ferry.shipName);
    }
}
