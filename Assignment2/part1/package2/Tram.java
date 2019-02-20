package part1.package2;

/**
 * Tram class which inherits from CityBus class
 */
public class Tram extends CityBus {
    private int maxSpeed;

    /**
     * set new value to maxSpeed
     * @param maxSpeed stores new maxSpeed
     */
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    /**
     * get maxSpeed of Tram object
     * @return maxSpeed of Tram object
     */
    public int getMaxSpeed(){
        return maxSpeed;
    }

    /**
     * Default constructor of Tram
     */
    public Tram(){
        super();
        this.maxSpeed = 0;
    }

    /**
     * Constructor that initializes the Metro object with specific values
     * @param ticketPrice stores initial ticketPrice value
     * @param noOfStops stores initial noOfStops value
     * @param routeNo stores initial routeNo value
     * @param beginOperationYear stores initial beginOperationYear value
     * @param lineName stores initial lineName value
     * @param driverName stores initial driverName value
     * @param maxSpeed stores initial maxSpeed value
     */
    public Tram(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName, int maxSpeed) {
        super(ticketPrice, noOfStops, routeNo, beginOperationYear, lineName, driverName);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Copy constructor that initializes Tram object by copying an existing Tram object
     * @param t stores Tram to be copied from
     */
    public Tram(Tram t){
        super(t.ticketPrice,t.noOfStops,t.routeNo,t.beginOperationYear,t.lineName,t.driverName);
        this.maxSpeed = t.maxSpeed;
    }

    /**
     * toString method displaying attributes of the Tram object
     * @return String with attributes of the Tram Object
     */
    @Override
    public String toString() {
        return "This Tram has "+ noOfStops +
                " stops and costs $"+ ticketPrice+
                ". Its route number is "+ noOfStops +
                " and line name is " + lineName +
                ". The begin operation year is "+ beginOperationYear +
                " and driver's name is " + driverName +". The max speed is "+ maxSpeed +".";
    }

    /**
     * equals method comparing two CityBus objects
     * @param o stores other object being compared to
     * @return boolean value of true if both objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false;
        // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Tram tram = (Tram) o;
        return this.routeNo == tram.routeNo &&
                this.beginOperationYear == tram.beginOperationYear &&
                this.lineName.equals(tram.lineName) &&
                this.driverName.equals(tram.driverName) &&
                this.noOfStops == tram.noOfStops &&
                this.ticketPrice == tram.ticketPrice &&
                this.maxSpeed == tram.maxSpeed;
    }
}
