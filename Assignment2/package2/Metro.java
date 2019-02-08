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
}
