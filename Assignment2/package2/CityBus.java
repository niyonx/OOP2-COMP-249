package package2;

import package1.PublicTransportation;

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
}
