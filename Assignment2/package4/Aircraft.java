package package4;

import package1.PublicTransportation;

public class Aircraft extends PublicTransportation {
    private enum Class{
        Helicopter, Airline, Glider, Balloon
    }

    private enum maintenance{
        Weekly, Monthly, Yearly
    }

    public Aircraft() {
    }

    public Aircraft(double ticketPrice, int noOfStops) {
        super(ticketPrice, noOfStops);
    }

    public Aircraft(Aircraft a) {
        super(a);
    }
}
