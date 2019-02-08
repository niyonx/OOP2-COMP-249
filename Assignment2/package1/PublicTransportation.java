package package1;

public class PublicTransportation {
    private double ticketPrice;
    private int noOfStops;

    public PublicTransportation(){
        ticketPrice = 0;
        noOfStops = 0;
    }

    public PublicTransportation(double ticketPrice, int noOfStops){
        this.ticketPrice = ticketPrice;
        this.noOfStops = noOfStops;
    }

    public PublicTransportation(PublicTransportation pt){
        this.ticketPrice = pt.getTicketPrice();
        this.noOfStops = pt.getNoOfStops();
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



}
