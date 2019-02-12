package part2.package2;

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
        this.maxSpeed = t.maxSpeed;
    }

    @Override
    public String toString() {
        return "This Tram has "+ getNoOfStops() +
                " stops and costs $"+ getTicketPrice()+
                ". Its route number is "+ getNoOfStops() +
                " and line name is " + getLineName() +
                ". The begin operation year is "+ getBeginOperationYear() +
                " and driver's name is " + getDriverName() +". The max speed is "+ maxSpeed +".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Tram tram = (Tram) o;
        return this.getRouteNo() == tram.getRouteNo() &&
                this.getBeginOperationYear() == tram.getBeginOperationYear() &&
                this.getLineName().equals(tram.getLineName()) &&
                this.getDriverName().equals(tram.getDriverName()) &&
                this.getNoOfStops() == tram.getNoOfStops() &&
                this.getTicketPrice() == tram.getTicketPrice() &&
                this.maxSpeed == tram.maxSpeed;
    }
}
