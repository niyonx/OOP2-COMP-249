import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDirectionary {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        String s = "";
        ArrayList<String> dict = new ArrayList<String>(500);

        System.out.print("\nWelcome to the Sub-Dictionary Generator!\n" +
                "Please enter the name of the input file: ");
        try{
            FileInputStream fis = new FileInputStream(keyIn.next());
//            FileInputStream fis = new FileInputStream("PersonOfTheCentury.txt");
            Scanner sc = new Scanner(fis);

            while(sc.hasNext()){
                s = sc.next().toUpperCase();

                if (s.contains(",")||s.contains(".")||s.contains("?")||s.contains(":")||s.contains(";")||s.contains("!")){
                    s = s.substring(0,s.length()-1);
                }
                if(s.contains("'")||s.contains("’")){
                    s = s.substring(0,s.length()-2);
                }
                if(s.matches(".*\\d+.*")||s.equals("=")||(s.length()==1 && !(s.equals("A") || s.equals("I")))){
                    s = "";
                }

                if(!dict.contains(s) && !s.equals("")){
                    dict.add(s);
                }
            }

            dict.sort(null);

            FileOutputStream fos = new FileOutputStream("SubDictionary.txt");
            PrintWriter pw = new PrintWriter(fos);

            pw.println("The document produced this sub-dictionary, which includes "+dict.size()+" entries.");

            int letter = 64;
            for (String str: dict) {
                if ((int)str.charAt(0)>letter){
                    letter = (int)str.charAt(0);
                    pw.println();
                    pw.println((char)letter);
                    pw.println("==");
                }
                pw.println(str);
            }
            pw.close();
            sc.close();
            System.out.println("SubDictionary.txt created successfully");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
