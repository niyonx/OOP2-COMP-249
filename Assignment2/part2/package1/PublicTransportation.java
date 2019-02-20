package part2.package1;

/**
 * PublicTransportation class to store ticketPrice and noOfStops
 */
public class PublicTransportation {
    private double ticketPrice;
    private int noOfStops;

    /**
     * This is a default constructor that takes no arguments
     */
    public PublicTransportation(){
        ticketPrice = 0;
        noOfStops = 0;
    }

    /**
     * This is a constructor to initialize a PublicTransportation object
     * @param ticketPrice initial ticket price
     * @param noOfStops initial number of stops
     */
    public PublicTransportation(double ticketPrice, int noOfStops){
        this.ticketPrice = ticketPrice;
        this.noOfStops = noOfStops;
    }

    /**
     * This is a copy constructor that initializes a new PublicTransportation object with an existing object attributes value
     * @param pt PublicTransportation object being copied from
     */
    public PublicTransportation(PublicTransportation pt){
        this.ticketPrice = pt.getTicketPrice();
        this.noOfStops = pt.getNoOfStops();
    }

    /**
     * set ticketPrice of the PublicTransportation
     * @param ticketPrice stores new value of ticketPrice
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * get ticketPrice of the PublicTransportaion
     * @return ticketPrice of PublicTransportation
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * set noOfStops of the PublicTransportation
     * @param noOfStops stores new value of noOfStops
     */
    public void setNoOfStops(int noOfStops) {
        this.noOfStops = noOfStops;
    }

    /**
     * get noOfStops of the PublicTransportation
     * @return noOfStops of the PublicTransportation
     */
    public int getNoOfStops() {
        return noOfStops;
    }

    /**
     * toString method displaying values of the PublicTransportaion
     * @return String displaying values of the PublicTransportaion
     */
    @Override
    public String toString(){
        return "This Public Transportation has " + getNoOfStops() + " stops, and costs $"+getTicketPrice()+'.';
    }

    /**
     * equals method comparing two PublicTransportation attributes
     * @param obj stores other object being compared
     * @return boolean value of true of two objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || this.getClass()==obj.getClass()) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        PublicTransportation publicTransportation = (PublicTransportation)obj;
        return this.getTicketPrice() == publicTransportation.getTicketPrice() &&
                this.getNoOfStops() == publicTransportation.getNoOfStops();
    }
}
