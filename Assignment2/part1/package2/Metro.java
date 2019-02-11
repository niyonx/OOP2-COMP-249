package part1.package2;

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
        super(m.ticketPrice, m.noOfStops, m.routeNo,m.beginOperationYear, m.lineName, m.driverName);
        this.noOfVehicles = m.noOfVehicles;
        this.cityName = m.cityName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Metro metro = (Metro) o;
        return this.routeNo == metro.getRouteNo() &&
                this.beginOperationYear == metro.getBeginOperationYear() &&
                this.lineName.equals(metro.getLineName()) &&
                this.driverName.equals(metro.getDriverName()) &&
                getNoOfStops() == metro.getNoOfStops() &&
                getTicketPrice() == metro.getTicketPrice() &&
                this.noOfVehicles == metro.getNoOfVehicles() &&
                this.cityName.equals(metro.getCityName());
    }
}
