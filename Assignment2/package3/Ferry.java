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
}
