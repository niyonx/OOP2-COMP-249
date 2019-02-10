package package2;

import package1.PublicTransportation;

import java.util.Objects;

public class CityBus extends PublicTransportation {
    private long routeNo;
    private int beginOperationYear;
    private String lineName;
    private String driverName;

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
        this.setBeginOperationYear(0);
        this.setDriverName("");
        this.setLineName("");
        this.setRouteNo(0);
    }

    public CityBus(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName) {
        super(ticketPrice, noOfStops);
        this.routeNo = routeNo;
        this.beginOperationYear = beginOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    public CityBus(CityBus cb){
        super(cb.getTicketPrice(), cb.getNoOfStops());
        this.routeNo = cb.getRouteNo();
        this.beginOperationYear = cb.getBeginOperationYear();
        this.lineName = cb.getLineName();
        this.driverName = cb.getDriverName();
    }

    @Override
    public String toString() {
        return "This City Bus has "+ getNoOfStops()+
                " stops and costs "+ getTicketPrice()+
                ". Its route number is "+getNoOfStops()+
                " and line name is " + getLineName()+
                ". The begin operation year is "+getBeginOperationYear()+
                " and driver's name is " + getDriverName()+".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        CityBus cityBus = (CityBus) o;
        return getRouteNo() == cityBus.getRouteNo() &&
                getBeginOperationYear() == cityBus.getBeginOperationYear() &&
                getLineName().equals(cityBus.getLineName()) &&
                getDriverName().equals(cityBus.getDriverName()) &&
                getNoOfStops() == cityBus.getNoOfStops() &&
                getTicketPrice() == cityBus.getTicketPrice();
    }

}
