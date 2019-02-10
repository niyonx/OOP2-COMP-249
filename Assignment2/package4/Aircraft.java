package package4;

import package1.PublicTransportation;

public class Aircraft extends PublicTransportation {
    private Class thisClass;
    private maintenance thisMaintenance;

    public enum Class{
        Helicopter, Airline, Glider, Balloon
    }

    public enum maintenance{
        Weekly, Monthly, Yearly
    }

    public Class getThisClass() {
        return thisClass;
    }

    public maintenance getThisMaintenance(){
        return thisMaintenance;
    }

    public void setThisClass(Class theClass){
        thisClass = theClass;
    }

    public void setThisMaintenance(maintenance theMaintenance){
        thisMaintenance = theMaintenance;
    }

    public Aircraft() {
        super();
        thisClass= null;
        thisMaintenance = null;
    }

    public Aircraft(double ticketPrice, int noOfStops, Class theClass, maintenance theMaintenance) {
        super(ticketPrice, noOfStops);
        thisClass = theClass;
        thisMaintenance = theMaintenance;
    }

    public Aircraft(Aircraft a) {
        super(a.getTicketPrice(), a.getNoOfStops());
        thisClass = a.getThisClass();
        thisMaintenance = a.getThisMaintenance();
    }

    @Override
    public String toString(){
        return "This "+getThisClass()+" is an Aircraft and has " + getNoOfStops() + " stops, and costs $"+getTicketPrice()+'.' +
                " It goes into maintenance on a "+getThisMaintenance()+" basis.";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || !(this.getClass()==obj.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Aircraft aircraft = (Aircraft) obj;
        return this.getTicketPrice() == aircraft.getTicketPrice() &&
                this.getNoOfStops() == aircraft.getNoOfStops() &&
                this.getThisMaintenance() == getThisMaintenance() &&
                this.getThisClass() == aircraft.getThisClass();
    }

}
