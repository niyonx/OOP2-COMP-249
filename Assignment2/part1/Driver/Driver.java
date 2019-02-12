package part1.Driver;

import part1.package1.PublicTransportation;
import part1.package2.CityBus;
import part1.package2.Metro;
import part1.package2.Tram;
import part1.package3.Ferry;
import part1.package4.Aircraft;


@SuppressWarnings("ALL")
public class Driver {
    public static void main(String[] args) {
        double maxPrice=0, minPrice=999;
        int indexMaxPrice=0, indexMinPrice=0;
        // creating objects and displaying them
        PublicTransportation pt1 = new PublicTransportation(13, 22);
        System.out.println(pt1);
        PublicTransportation pt2 = new PublicTransportation(16,33);
        System.out.println(pt2);

        CityBus cb1 = new CityBus(14,30,223,2018,"Wonderland", "Zack");
        System.out.println(cb1);
        CityBus cb2 = new CityBus(5.25, 4,215,2004,"Angrignon","Jacob");
        System.out.println(cb2);
        System.out.println();

        Metro m1 = new Metro(3.25, 3,513,2005,"Longueuil","Sam",22,"Longueuil");
        System.out.println(m1);
        Metro m2 = new Metro(5.25, 4,215,2004,"Angrignon","Jacob",53,"Montreal");
        System.out.println(m2);
        Metro m3 = new Metro(m2);
        System.out.println(m3);
        System.out.println();

        Tram t1 = new Tram(33,22,121,2009,"Cote Vertu","Pascal",300);
        System.out.println(t1);
        Tram t2 = new Tram(33,22,121,2009,"Cote Vertu","Pascal",300);
        System.out.println(t2);
        System.out.println();

        Ferry f1 = new Ferry(9,33,2000,"Titan");
        System.out.println(f1);
        Ferry f2 = new Ferry(11,29,2007,"Great white shark");
        System.out.println(f2);
        System.out.println();

        Aircraft a1 = new Aircraft(22,32, Aircraft.Class.Helicopter, Aircraft.maintenance.Weekly);
        System.out.println(a1);
        Aircraft a2 = new Aircraft(a1);
        System.out.println(a2);
        Aircraft a3 = new Aircraft(43,11, Aircraft.Class.Airline, Aircraft.maintenance.Yearly);
        System.out.println(a3);
        Aircraft a4 = new Aircraft(100,3, Aircraft.Class.Balloon, Aircraft.maintenance.Monthly);
        System.out.println(a4);
        System.out.println();

        // testing equals method
        System.out.println(a2.equals(a1));
        System.out.println(a2.equals(a3));
        System.out.println(m2.equals(m3));
        System.out.println(cb1.equals(m2));
        System.out.println(t1.equals(t2));
        System.out.println();

        // creating array of 15 PublicTransportation objects
        PublicTransportation[] arrayPublicTransportation = new PublicTransportation[15];
        arrayPublicTransportation[0]= pt1;
        arrayPublicTransportation[1]= pt2;
        arrayPublicTransportation[2]= cb1;
        arrayPublicTransportation[3]= cb2;
        arrayPublicTransportation[4] = m1;
        arrayPublicTransportation[5] = m2;
        arrayPublicTransportation[6] = m3;
        arrayPublicTransportation[7] = t1;
        arrayPublicTransportation[8] = t2;
        arrayPublicTransportation[9] = f1;
        arrayPublicTransportation[10] = f2;
        arrayPublicTransportation[11] = a1;
        arrayPublicTransportation[12] = a2;
        arrayPublicTransportation[13] = a3;
        arrayPublicTransportation[14] = a4;

        for (int i = 0; i < arrayPublicTransportation.length; i++) {
            if (arrayPublicTransportation[i].getTicketPrice() < minPrice) {
                minPrice = arrayPublicTransportation[i].getTicketPrice();
                indexMinPrice = i;
            }
            if (arrayPublicTransportation[i].getTicketPrice() > maxPrice){
                maxPrice = arrayPublicTransportation[i].getTicketPrice();
                indexMaxPrice = i;
            }
        }

        System.out.println("At index location " + indexMaxPrice+ ": " + arrayPublicTransportation[indexMaxPrice]);
        System.out.println("At index location " + indexMinPrice+ ": " + arrayPublicTransportation[indexMinPrice]);

    }
}
