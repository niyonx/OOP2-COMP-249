package part2.package2;

import part2.package1.PublicTransportation;

public class CityBus extends PublicTransportation {
    protected long routeNo;
    protected int beginOperationYear;
    protected String lineName;
    protected String driverName;

    public long getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(long routeNo) {
        this.routeNo = routeNo;
    }

    public int getBeginOperationYear() {
        return beginOperationYear;
    }

    public void setBeginOperationYear(int beginOperationYear) {
        this.beginOperationYear = beginOperationYear;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public CityBus(){
        super();
        beginOperationYear = 0;
        driverName = "";
        lineName = "";
        routeNo = 0;
    }

    public CityBus(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName) {
        super(ticketPrice, noOfStops);
        this.routeNo = routeNo;
        this.beginOperationYear = beginOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    public CityBus(CityBus cb){
        super(cb.ticketPrice, cb.noOfStops);
        this.routeNo = cb.routeNo;
        this.beginOperationYear = cb.beginOperationYear;
        this.lineName = cb.lineName;
        this.driverName = cb.driverName;
    }

    @Override
    public String toString() {
        return "This City Bus has "+ noOfStops +
                " stops and costs "+ ticketPrice +
                ". Its route number is "+ noOfStops +
                " and line name is " + lineName +
                ". The begin operation year is "+ beginOperationYear +
                " and driver's name is " + driverName +".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        CityBus cityBus = (CityBus) o;
        return routeNo == cityBus.routeNo &&
                beginOperationYear == cityBus.beginOperationYear &&
                lineName.equals(cityBus.lineName) &&
                driverName.equals(cityBus.driverName) &&
                noOfStops == cityBus.noOfStops &&
                ticketPrice == cityBus.ticketPrice;
    }

}
