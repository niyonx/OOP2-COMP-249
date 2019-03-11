import java.io.*;
import java.util.Scanner;

public class AuthorBibCreator {
//    public static String processBibFiles(){
//
//    }


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
//                File f = new File("Latex"+i+".bib");
//                if (f.exists()){
//                    throw new FileExistsException();
//                }
//            }catch (FileExistsException e){
//                System.out.println(e.getMessage());
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
                File fIEEEBU = new File(authorName+"-IEEE.json");
                fIEEEBU.renameTo(fIEEE);
            }
            if (fACM.exists()){
                fACM.delete();
                File fIACMBU = new File(authorName+"-ACM.json");
                fIACMBU.renameTo(fACM);
            }
            if (fNJ.exists()){
                fNJ.delete();
                File fNJBU = new File(authorName+"-NJ.json");
                fNJBU.renameTo(fNJ);
            }
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
    }
}
