package part1.package4;

import part1.package1.PublicTransportation;

/**
 * Aircraft class which inherits from PublicTransportation class
 */
public class Aircraft extends PublicTransportation {
    private Class thisClass;
    private maintenance thisMaintenance;

    /**
     * Classification of aircrafts
     */
    public enum Class{
        Helicopter, Airline, Glider, Balloon
    }

    /**
     * Basis of maintenance
     */
    public enum maintenance{
        Weekly, Monthly, Yearly
    }

    /**
     * get the classification of the object
     * @return thisClass of the object
     */
    public Class getThisClass() {
        return thisClass;
    }

    /**
     * get the maintenance basis of the object
     * @return thisMaintenance of the object
     */
    public maintenance getThisMaintenance(){
        return thisMaintenance;
    }

    /**
     * set thisClass to a new value
     * @param theClass stores new value of thisClass
     */
    public void setThisClass(Class theClass){
        thisClass = theClass;
    }

    /**
     * set thisMaintenance of a new value
     * @param theMaintenance stores new value of theMaintenance
     */
    public void setThisMaintenance(maintenance theMaintenance){
        thisMaintenance = theMaintenance;
    }

    /**
     * Default constructor of Aircraft
     */
    public Aircraft() {
        super();
        thisClass= null;
        thisMaintenance = null;
    }

    /**
     * Constructor that initializes the Aircraft object with specific values
     * @param ticketPrice stores initial ticketPrice
     * @param noOfStops stores initial noOfStops
     * @param theClass stores initial thisClass
     * @param theMaintenance stores initial thisMaintenance
     */
    public Aircraft(double ticketPrice, int noOfStops, Class theClass, maintenance theMaintenance) {
        super(ticketPrice, noOfStops);
        thisClass = theClass;
        thisMaintenance = theMaintenance;
    }

    /**
     * Copy constructor that initializes Aircraft object by copying an existing Aircraft object
     * @param a stores Aircraft to be copied from
     */
    public Aircraft(Aircraft a) {
        super(a.ticketPrice, a.noOfStops);
        thisClass = a.thisClass;
        thisMaintenance = a.thisMaintenance;
    }

    /**
     * toString method displaying attributes of the Aircraft object
     * @return String with attributes of the Aircraft Object
     */
    @Override
    public String toString(){
        return "This "+thisClass+" is an Aircraft and has " + noOfStops + " stops, and costs $"+ticketPrice+'.' +
                " It goes into maintenance on a "+thisMaintenance+" basis.";
    }

    /**
     * equals method comparing two objects
     * @param obj stores other object being compared to
     * @return boolean value of true if both objects are the same and false otherwise
     */
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
