package part1.package1;

public class PublicTransportation {
    protected double ticketPrice;
    protected int noOfStops;

    public PublicTransportation(){
        ticketPrice = 0;
        noOfStops = 0;
    }

    public PublicTransportation(double ticketPrice, int noOfStops){
        this.ticketPrice = ticketPrice;
        this.noOfStops = noOfStops;
    }

    public PublicTransportation(PublicTransportation pt){
        this.ticketPrice = pt.ticketPrice;
        this.noOfStops = pt.noOfStops;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setNoOfStops(int noOfStops) {
        this.noOfStops = noOfStops;
    }

    public int getNoOfStops() {
        return noOfStops;
    }

    @Override
    public String toString(){
        return "This Public Transportation has " + noOfStops + " stops, and costs $"+ticketPrice+'.';
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || this.getClass()==obj.getClass()) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        PublicTransportation publicTransportation = (PublicTransportation)obj;
        return this.ticketPrice == publicTransportation.ticketPrice &&
                this.noOfStops == publicTransportation.noOfStops;
    }
}
