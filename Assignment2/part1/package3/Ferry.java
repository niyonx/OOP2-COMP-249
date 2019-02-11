package part1.package3;

import part1.package1.PublicTransportation;

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
        super(f.ticketPrice, f.noOfStops);
        this.buildYear = f.buildYear;
        this.shipName = f.shipName;
    }

    @Override
    public String toString(){
        return "This Ferry has " + noOfStops + " stops, and costs $"+ ticketPrice +'.' +
                " Build year is " + buildYear +" and the ship name is "+ shipName;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || this.getClass()==obj.getClass()) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Ferry ferry = (Ferry) obj;
        return this.ticketPrice == ferry.ticketPrice &&
                this.noOfStops == ferry.noOfStops &&
                this.buildYear == ferry.buildYear &&
                this.shipName.equals(ferry.shipName);
    }
}
