package package3;

import package1.PublicTransportation;

public class Ferry extends PublicTransportation {
    private int buildYear;
    private String shipName;

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Ferry(){
        super();
        this.buildYear = 0;
        this.shipName = "";
    }

    public Ferry(double ticketPrice, int noOfStops, int buildYear, String shipName) {
        super(ticketPrice, noOfStops);
        this.buildYear = buildYear;
        this.shipName = shipName;
    }

    public Ferry(Ferry f){
        super(f.getTicketPrice(), f.getNoOfStops());
        this.buildYear = f.getBuildYear();
        this.shipName = f.getShipName();
    }

    @Override
    public String toString(){
        return "This Ferry has " + getNoOfStops() + " stops, and costs $"+getTicketPrice()+'.' +
                " Build year is " + getBuildYear() +" and the ship name is "+ getShipName();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || this.getClass()==obj.getClass()) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Ferry ferry = (Ferry) obj;
        return this.getTicketPrice() == ferry.getTicketPrice() &&
                this.getNoOfStops() == ferry.getNoOfStops() &&
                this.getBuildYear() == ferry.getBuildYear() &&
                this.getShipName().equals(ferry.getShipName());
    }
}
