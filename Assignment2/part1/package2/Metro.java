package part1.package2;

/**
 * Metro class which inherits from CityBus class
 */
public class Metro extends CityBus {
    private int noOfVehicles;
    private String cityName;

    /**
     * set new value to noOfVehicles
     * @param noOfVehicles stores new noOfVehicles
     */
    public void setNoOfVehicles(int noOfVehicles) {
        this.noOfVehicles = noOfVehicles;
    }

    /**
     * get noOfVehicles of Metro object
     * @return noOfVehicles of Metro object
     */
    public int getNoOfVehicles() {
        return noOfVehicles;
    }

    /**
     * set new value to cityName
     * @param cityName stores new cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * get cityName of Metro object
     * @return cityName of Metro object
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Default constructor of CityBus
     */
    public Metro(){
        super();
        this.noOfVehicles = 0;
        this.cityName = "";
    }

    /**
     * This is a constructor that initializes the Metro object with specific values
     * @param ticketPrice stores initial ticketPrice value
     * @param noOfStops stores initial noOfStops value
     * @param routeNo stores initial routeNo value
     * @param beginOperationYear stores initial beginOperationYear value
     * @param lineName stores initial lineName value
     * @param driverName stores initial driverName value
     * @param cityName stores initial cityName value
     * @param noOfVehicles stores initial noOfVehicles value
     */
    public Metro(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName, int noOfVehicles, String cityName) {
        super(ticketPrice, noOfStops, routeNo, beginOperationYear, lineName, driverName);
        this.noOfVehicles = noOfVehicles;
        this.cityName = cityName;
    }

    /**
     * Copy constructor that initializes Metro object by copying an existing Metro object
     * @param m stores Metro to be copied from
     */
    public Metro(Metro m){
        super(m.ticketPrice, m.noOfStops, m.routeNo,m.beginOperationYear, m.lineName, m.driverName);
        this.noOfVehicles = m.noOfVehicles;
        this.cityName = m.cityName;
    }

    /**
     * toString method displaying attributes of the Metro object
     * @return String with attributes of the Metro Object
     */
    @Override
    public String toString() {
        return "This Metro has "+ noOfStops +
                " stops and costs $"+ ticketPrice +
                ". Its route number is "+ noOfStops +
                " and line name is " + lineName +
                ". The begin operation year is "+ beginOperationYear +
                " and driver's name is " + driverName +"." +
                " Number of vehicles is " + noOfVehicles +
                " and city name is " + cityName +'.';
    }

    /**
     * equals method comparing two objects
     * @param o stores other object being compared to
     * @return boolean value of true if both objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false;
        // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Metro metro = (Metro) o;
        return this.routeNo == metro.routeNo &&
                this.beginOperationYear == metro.beginOperationYear &&
                this.lineName.equals(metro.lineName) &&
                this.driverName.equals(metro.driverName) &&
                this.noOfStops == metro.noOfStops &&
                this.ticketPrice == metro.ticketPrice &&
                this.noOfVehicles == metro.noOfVehicles &&
                this.cityName.equals(metro.cityName);
    }
}
