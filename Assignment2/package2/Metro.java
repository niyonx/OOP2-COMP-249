package package2;

public class Metro extends CityBus {
    private int noOfVehicles;
    private String cityName;

    public void setNoOfVehicles(int noOfVehicles) {
        this.noOfVehicles = noOfVehicles;
    }

    public int getNoOfVehicles() {
        return noOfVehicles;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public Metro(){
        super();
        this.noOfVehicles = 0;
        this.cityName = "";
    }

    public Metro(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName, int noOfVehicles, String cityName) {
        super(ticketPrice, noOfStops, routeNo, beginOperationYear, lineName, driverName);
        this.noOfVehicles = noOfVehicles;
        this.cityName = cityName;
    }

    public Metro(Metro m){
        super(m.getTicketPrice(), m.getNoOfStops(), m.getRouteNo(),m.getBeginOperationYear(), m.getLineName(), m.getDriverName());
        this.noOfVehicles = m.getNoOfVehicles();
        this.cityName = m.getCityName();
    }

    @Override
    public String toString() {
        return "This Metro has "+ getNoOfStops()+
                " stops and costs "+ getTicketPrice()+
                ". Its route number is "+getNoOfStops()+
                " and line name is " + getLineName()+
                ". The begin operation year is "+getBeginOperationYear()+
                " and driver's name is " + getDriverName()+"." +
                " Number of vehicles is " + getNoOfVehicles() +
                " and city name is " + getCityName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Metro metro = (Metro) o;
        return getRouteNo() == metro.getRouteNo() &&
                getBeginOperationYear() == metro.getBeginOperationYear() &&
                getLineName().equals(metro.getLineName()) &&
                getDriverName().equals(metro.getDriverName()) &&
                getNoOfStops() == metro.getNoOfStops() &&
                getTicketPrice() == metro.getTicketPrice();
    }
}
