import java.io.*;
import java.util.Scanner;

public class AuthorBibCreator {
    public static int processBibFiles(PrintWriter pwIEEE, PrintWriter pwACM, PrintWriter pwNJ, Scanner sc, String authorName){
        String s;
        String author, journal, title, volume, pages, doi, month, year, number;


        int count=0;
        Article[] articles = null;
        for (int i = 1; i <= 10; i++){
            try{
                sc = new Scanner(new FileInputStream("Latex"+i+".bib"));
//                sc.useDelimiter("@ARTICLE");
                while(sc.hasNextLine()){
                    s = sc.nextLine();
                    if (s.toLowerCase().contains(authorName.toLowerCase())) {
                        System.out.println(s);
                        author = s;
                        s = sc.nextLine();
                        journal = s;
                        s = sc.nextLine();
                        title = s;
                        s = sc.nextLine();
                        year = s;
                        s = sc.nextLine();
                        volume = s;
                        s = sc.nextLine();
                        number = s;
                        s = sc.nextLine();
                        pages = s;
                        s = sc.nextLine();
                        s = sc.nextLine();
                        doi = s;
                        s = sc.nextLine();
                        s = sc.nextLine();
                        month = s;
                        Article a = new Article(author, journal, title, volume, pages, doi, month, year, number);
                        count++;
                    }
                    articles = new Article[count];

                }
            }catch(FileNotFoundException e){
                System.out.println("Could not open input file Latex"+i+".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String authorName;
        Scanner keyIn = new Scanner(System.in);
        Scanner sc = null;

        System.out.println("Welcome to BibCreator!");
        System.out.print("Please enter the author name you are targeting: ");
        authorName = keyIn.nextLine();

        System.out.println();
        for (int i = 1; i <= 10; i++){
            try{
                sc = new Scanner(new FileInputStream("Latex"+i+".bib"));
                sc.close();
            }catch(FileNotFoundException e){
                System.out.println("Could not open input file Latex"+i+".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
        }

        try{
            File fIEEE = new File(authorName+"-IEEE.json"), fACM = new File(authorName+"-ACM.json"), fNJ = new File(authorName+"-NJ.json");
            if (fIEEE.exists()||fACM.exists()||fNJ.exists()){
                throw new FileExistsException();
            }
        }catch (FileExistsException e){
            System.out.println(e.getMessage());
            File fIEEE = new File(authorName+"-IEEE-BU.json"), fACM = new File(authorName+"-ACM-BU.json"), fNJ = new File(authorName+"-NJ-BU.json");
            if (fIEEE.exists()){
                fIEEE.delete();
            }
            File fIEEEBU = new File(authorName+"-IEEE.json");
            fIEEEBU.renameTo( new File(authorName+"-IEEE-BU.json"));

            if (fACM.exists()){
                fACM.delete();
            }
            File fACMBU = new File(authorName+"-ACM.json");
            fACMBU.renameTo( new File(authorName+"-ACM-BU.json"));

            if (fNJ.exists()){
                fNJ.delete();
            }
            File fNJBU = new File(authorName+"-NJ.json");
            fNJBU.renameTo( new File(authorName+"-NJ-BU.json"));
        }

        // generate three files
        PrintWriter pwIEEE = null, pwACM = null, pwNJ = null;
        Boolean opened = true;

        try {
            pwIEEE = new PrintWriter(new FileOutputStream(authorName + "-IEEE.json"));
        } catch (FileNotFoundException e) {
            System.out.println(authorName+"-IEEE.json could not be opened/ created.");
            opened = false;
            e.printStackTrace();
        }

        try {
            pwACM = new PrintWriter(new FileOutputStream(authorName + "-ACM.json"));
        } catch (FileNotFoundException e) {
            System.out.println(authorName+"-ACM.json could not be opened/ created.");
            opened = false;
            e.printStackTrace();
        }

        try {
            pwNJ = new PrintWriter(new FileOutputStream(authorName + "-NJ.json"));
        } catch (FileNotFoundException e) {
            System.out.println(authorName+"-NJ.json could not be opened/ created.");
            opened = false;
            e.printStackTrace();
        }

        if (!opened){
            File fIEEE = new File(authorName + "-IEEE.json"), fACM = new File(authorName + "-ACM.json"), fNJ = new File(authorName + "-NJ.json");
            fIEEE.delete();
            fACM.delete();
            fNJ.delete();
        }

        System.out.println("\nA total of "+processBibFiles(pwIEEE,pwACM,pwNJ,sc,authorName)+" records were found for author(s) with name: Park");
    }
}
