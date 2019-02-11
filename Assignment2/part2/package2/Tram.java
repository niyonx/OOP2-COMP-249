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
        super(t.ticketPrice,t.noOfStops,t.routeNo,t.beginOperationYear,t.lineName,t.driverName);
        this.maxSpeed = t.maxSpeed;
    }

    @Override
    public String toString() {
        return "This Tram has "+ noOfStops +
                " stops and costs $"+ ticketPrice+
                ". Its route number is "+ noOfStops +
                " and line name is " + lineName +
                ". The begin operation year is "+ beginOperationYear +
                " and driver's name is " + driverName +". The max speed is "+ maxSpeed +".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if two objects points to the same reference
        if (o == null || !(this.getClass() == o.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Tram tram = (Tram) o;
        return this.routeNo == tram.routeNo &&
                this.beginOperationYear == tram.beginOperationYear &&
                this.lineName.equals(tram.lineName) &&
                this.driverName.equals(tram.driverName) &&
                this.noOfStops == tram.noOfStops &&
                this.ticketPrice == tram.ticketPrice &&
                this.maxSpeed == tram.maxSpeed;
    }
}
