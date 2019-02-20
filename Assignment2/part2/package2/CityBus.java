package part2.package2;

import part2.package1.PublicTransportation;

/**
 * CityBus class which inherits from PublicTransportation
 */
public class CityBus extends PublicTransportation {
    private long routeNo;
    private int beginOperationYear;
    private String lineName;
    private String driverName;

    /**
     * get routeNo of CityBus object
     * @return routeNo of CityBus object
     */
    public long getRouteNo() {
        return routeNo;
    }

    /**
     * set new value to routeNo
     * @param routeNo stores new routeNo
     */
    public void setRouteNo(long routeNo) {
        this.routeNo = routeNo;
    }

    /**
     * get beginOperationYear of CityBus object
     * @return beginOperationYear of CityBus object
     */
    public int getBeginOperationYear() {
        return beginOperationYear;
    }

    /**
     * set beginOperationYear to a new value
     * @param beginOperationYear stores the new value of beginOperationYear
     */
    public void setBeginOperationYear(int beginOperationYear) {
        this.beginOperationYear = beginOperationYear;
    }

    /**
     * get lineName of CityBus
     * @return lineName of CityBus
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * set lineName to a new value
     * @param lineName stores new value of lineName
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * get DriverName of CityBus object
     * @return DriverName of CityBus object
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * set driverName to a new value
     * @param driverName stores new value of driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Default constructor of CityBus
     */
    public CityBus(){
        super();
        beginOperationYear = 0;
        driverName = "";
        lineName = "";
        routeNo = 0;
    }

    /**
     * This is a constructor that initializes the CityBus object with specific values
     * @param ticketPrice stores initial ticketPrice value
     * @param noOfStops stores initial noOfStops value
     * @param routeNo stores initial routeNo value
     * @param beginOperationYear stores initial beginOperationYear value
     * @param lineName stores initial lineName value
     * @param driverName stores initial driverName value
     */
    public CityBus(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName) {
        super(ticketPrice, noOfStops);
        this.routeNo = routeNo;
        this.beginOperationYear = beginOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    /**
     * Copy constructor that initializes a CityBus object by copying an existing CityBus object
     * @param cb stores CityBus to be copied from
     */
    public CityBus(CityBus cb){
        super(cb.getTicketPrice(), cb.getNoOfStops());
        this.routeNo = cb.routeNo;
        this.beginOperationYear = cb.beginOperationYear;
        this.lineName = cb.lineName;
        this.driverName = cb.driverName;
    }

    /**
     * toString method displaying attributes of the CityBus object
     * @return String with attributes of the CityBus Object
     */
    @Override
    public String toString() {
        return "This City Bus has "+ getNoOfStops() +
                " stops and costs "+ getTicketPrice() +
                ". Its route number is "+ routeNo +
                " and line name is " + lineName +
                ". The begin operation year is "+ beginOperationYear +
                " and driver's name is " + driverName +".";
    }

    /**
     * equals method comparing two objects
     * @param o stores other object being compared to
     * @return boolean value of true if both objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        CityBus cityBus = (CityBus) o;
        return routeNo == cityBus.routeNo &&
                beginOperationYear == cityBus.beginOperationYear &&
                lineName.equals(cityBus.lineName) &&
                driverName.equals(cityBus.driverName) &&
                this.getNoOfStops() == cityBus.getNoOfStops() &&
                this.getTicketPrice() == cityBus.getTicketPrice();
    }
}
