package part2.package4;

import part2.package1.PublicTransportation;

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
        super(a.ticketPrice, a.noOfStops);
        thisClass = a.thisClass;
        thisMaintenance = a.thisMaintenance;
    }

    @Override
    public String toString(){
        return "This "+thisClass+" is an Aircraft and has " + noOfStops + " stops, and costs $"+ticketPrice+'.' +
                " It goes into maintenance on a "+thisMaintenance+" basis.";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // if two objects points to the same reference
        if (obj == null || !(this.getClass()==obj.getClass())) return false; // null verification will make sure there's no null pointer exception while comparing the classes for the program not to crash
        Aircraft aircraft = (Aircraft) obj;
        return this.ticketPrice == aircraft.ticketPrice &&
                this.noOfStops == aircraft.noOfStops &&
                this.thisMaintenance == aircraft.thisMaintenance &&
                this.thisClass == aircraft.thisClass;
    }

}
