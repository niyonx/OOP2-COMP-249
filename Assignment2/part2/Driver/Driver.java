package part2.Driver;

import part1.package1.PublicTransportation;
import part1.package2.CityBus;
import part1.package2.Metro;
import part1.package2.Tram;
import part1.package3.Ferry;
import part1.package4.Aircraft;

@SuppressWarnings("ALL")
public class Driver {
    public static PublicTransportation[] copyCityBus(PublicTransportation[] arrayPublicTransport){
        PublicTransportation[] newArrayPublicTransport= new PublicTransportation[arrayPublicTransport.length];
        for (int i = 0; i < arrayPublicTransport.length; i++){
            newArrayPublicTransport[i]= new PublicTransportation(arrayPublicTransport[i]);
        }
        return newArrayPublicTransport;
    }

    public static void main(String[] args) {
        double maxPrice=0, minPrice=999;
        int indexMaxPrice=0, indexMinPrice=0;
        // creating objects for the array
        PublicTransportation pt1 = new PublicTransportation(13, 22);
        PublicTransportation pt2 = new PublicTransportation(16,33);

        CityBus cb1 = new CityBus(14,30,223,2018,"Wonderland", "Zack");
        CityBus cb2 = new CityBus(5.25, 4,215,2004,"Angrignon","Jacob");

        Metro m1 = new Metro(3.25, 3,513,2005,"Longueuil","Sam",22,"Longueuil");
        Metro m2 = new Metro(5.25, 4,215,2004,"Angrignon","Jacob",53,"Montreal");

        Tram t1 = new Tram(33,22,121,2009,"Cote Vertu","Pascal",300);
        Tram t2 = new Tram(33,22,121,2009,"Cote Vertu","Pascal",300);

        Ferry f1 = new Ferry(9,33,2000,"Titan");
        Ferry f2 = new Ferry(11,29,2007,"Great white shark");

        Aircraft a1 = new Aircraft(22,32, Aircraft.Class.Helicopter, Aircraft.maintenance.Weekly);
        Aircraft a2 = new Aircraft(100,3, Aircraft.Class.Balloon, Aircraft.maintenance.Monthly);

        // creating array of 12 PublicTransportation objects
        PublicTransportation[] arrayPublicTransportation = new PublicTransportation[12];
        arrayPublicTransportation[0]= pt1;
        arrayPublicTransportation[1]= pt2;
        arrayPublicTransportation[2]= cb1;
        arrayPublicTransportation[3]= cb2;
        arrayPublicTransportation[4] = m1;
        arrayPublicTransportation[5] = m2;
        arrayPublicTransportation[6] = t1;
        arrayPublicTransportation[7] = t2;
        arrayPublicTransportation[8] = f1;
        arrayPublicTransportation[9] = f2;
        arrayPublicTransportation[10] = a1;
        arrayPublicTransportation[11] = a2;

        System.out.println();
        for (int i = 0; i < arrayPublicTransportation.length; i++){
            System.out.println(arrayPublicTransportation[i]);
        }

        // calling copyCityBus method
        PublicTransportation[] copyArrayPublicTransportation = copyCityBus(arrayPublicTransportation);

        System.out.println();
        for (int i = 0; i < copyArrayPublicTransportation.length; i++){
            System.out.println(copyArrayPublicTransportation[i]);
        }

        System.out.println();
        System.out.println("The copying did not function properly. Polymorphism did not take place in the copy constructors as they were never overridden." +
                "\nCopy constructors are not polymorphic and cannot be overridden, as they are called by their own class names.");
    }
}
