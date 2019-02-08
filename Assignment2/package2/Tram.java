package package2;

public class Tram extends CityBus {
    private int maxSpeed;

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }

    public Tram(){
        super();
        this.maxSpeed = 0;
    }

    public Tram(double ticketPrice, int noOfStops, long routeNo, int beginOperationYear, String lineName, String driverName, int maxSpeed) {
        super(ticketPrice, noOfStops, routeNo, beginOperationYear, lineName, driverName);
        this.maxSpeed = maxSpeed;
    }

    public Tram(Tram t){
        super(t.getTicketPrice(),t.getNoOfStops(),t.getRouteNo(),t.getBeginOperationYear(),t.getLineName(),t.getDriverName());
        this.maxSpeed = t.getMaxSpeed();
    }


}
