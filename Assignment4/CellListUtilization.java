import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CellListUtilization {
    public static void main(String[] args) {
        CellList list1 = new CellList();
        CellList list2 = new CellList();
        Scanner keyIn = new Scanner(System.in);
        long serialNo= 0;

        try{
            FileInputStream fis = new FileInputStream("Cell_Info.txt");
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()){
                long sn = sc.nextLong();
                String brand = sc.next();
                double price = sc.nextDouble();
                int year = sc.nextInt();

                CellPhone cp = new CellPhone(sn,brand,year,price);
                list1.addToStart(cp);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        list1.showContents();

        System.out.print("Please enter a few serial numbers (with a space in between) to search them through the list: ");
        while(keyIn.hasNext()){
            serialNo = keyIn.nextLong();
            CellList.CellNode that;
            that = list1.find(serialNo);
            System.out.println();
            if (that !=null)
                System.out.println(that.getCp());
            else
                System.out.println("CellPhone with serial number "+serialNo+" not found.");
        }


    }
}
