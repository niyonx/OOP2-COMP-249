import java.io.*;
import java.util.Scanner;
public class AuthorBibCreator {
    public static int processBibFiles(PrintWriter pwIEEE, PrintWriter pwACM, PrintWriter pwNJ, Scanner sc, String authorName){
        String s="";
        String author= "", journal= "", title= "", volume= "", pages= "", doi= "", month= "", year= "", number= "";
        int count=0;
        Article[] articles = new Article[100];
        for (int i = 1; i <= 10; i++){
            try{
                sc = new Scanner(new FileInputStream("Latex"+i+".bib"));
                while(sc.hasNextLine()){
                    s = sc.nextLine();
                    if (s.toLowerCase().contains(authorName.toLowerCase())) {
                        count++;
                    }
                }

                sc.close();

                sc = new Scanner(new FileInputStream("Latex"+i+".bib"));
                articles = new Article[count];
                System.out.println(count);
                sc.useDelimiter("}");
                int j = 0;
                while(sc.hasNextLine()) {
                    if (!s.toLowerCase().contains(authorName.toLowerCase())){
                        s = sc.next();
                    }
                    System.out.println(s+"yyyyyyyyy");
                    if (s.toLowerCase().contains(authorName.toLowerCase())) {
                        System.out.println(s+"xxxxxxxxxxxxxxxxxx");
//                        count++;
                        author = s;
                        s = sc.next();
                        while (!s.toUpperCase().contains("@ARTICLE{") && sc.hasNext()) {
                            System.out.println(s+"oooooo");
                            if (s.toLowerCase().contains("journal")) {
                                journal = s;
                            } else if (s.toLowerCase().contains("title")) {
                                title = s;
                            } else if (s.toLowerCase().contains("year")) {
                                year = s;
                            } else if (s.toLowerCase().contains("volume")) {
                                volume = s;
                            } else if (s.toLowerCase().contains("number")) {
                                number = s;
                            } else if (s.toLowerCase().contains("pages")) {
                                pages = s;
                            } else if (s.toLowerCase().contains("doi")) {
                                doi = s;
                            } else if (s.toLowerCase().contains("month")) {
                                month = s;
                            }
                            s= sc.next();
                            System.out.println(s+"kkkkkkkkkkkkkkk");
                        }
                        Article a = new Article(author, journal, title, volume, pages, doi, month, year, number);
                        articles[j] = a;
                        j++;
                    }
                }
                for (int k = 0; k < articles.length; k++) {
                    if (articles[k] != null) {
                        pwIEEE.println(articles[k].toStringIEEE());
                        pwACM.println(articles[k].toStringACM());
                        pwNJ.println(articles[k].toStringNJ());
                    }
                }
            }catch(FileNotFoundException e){
                System.out.println("Could not open input file Latex"+i+".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
        }
        pwIEEE.close();
        pwACM.close();
        pwNJ.close();
        return count;
    }
    public static void main(String[] args) {
        String authorName;
        int matches=0;
        Scanner keyIn = new Scanner(System.in);
        Scanner sc = null;
        System.out.println("\nWelcome to BibCreator!\n");
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
                throw new FileExistsException("A file already exists with the name: "+authorName+"-IEEE-BU.json\n"+
                        "File will be renamed as: "+authorName+"-IEEE-BU.json and any old BUs will be deleted.\n\n"+
                        "A file already exists with the name: "+authorName+"-ACM-BU.json\n"+
                        "File will be renamed as: "+authorName+"-ACM-BU.json and any old BUs will be deleted.\n\n"+
                        "A file already exists with the name: "+authorName+"-NJ-BU.json\n"+
                        "File will be renamed as: "+authorName+"-NJ-BU.json and any old BUs will be deleted.\n");
            }
        }catch (FileExistsException e){
            System.out.println(e.getMessage());
            File fIEEE = new File(authorName+"-IEEE-BU.json"), fACM = new File(authorName+"-ACM-BU.json"), fNJ = new File(authorName+"-NJ-BU.json");
            if (fIEEE.exists()){
//                System.out.println("A file already exists with the name: "+authorName+"-IEEE-BU.json");
//                System.out.println("File will be renamed as: "+authorName+"-IEEE-BU.json and any old BUs will be deleted.\n");
                fIEEE.delete();
            }
            File fIEEEBU = new File(authorName+"-IEEE.json");
            fIEEEBU.renameTo( new File(authorName+"-IEEE-BU.json\n"));
            if (fACM.exists()){
//                System.out.println("A file already exists with the name: "+authorName+"-ACM-BU.json");
//                System.out.println("File will be renamed as: "+authorName+"-ACM-BU.json and any old BUs will be deleted.\n");
                fACM.delete();
            }
            File fACMBU = new File(authorName+"-ACM.json");
            fACMBU.renameTo( new File(authorName+"-ACM-BU.json"));
            if (fNJ.exists()){
//                System.out.println("A file already exists with the name: "+authorName+"-NJ-BU.json");
//                System.out.println("File will be renamed as: "+authorName+"-NJ-BU.json and any old BUs will be deleted.");
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
        matches = processBibFiles(pwIEEE,pwACM,pwNJ,sc,authorName);
        if (!opened || matches ==0){
            File fIEEE = new File(authorName + "-IEEE.json"), fACM = new File(authorName + "-ACM.json"), fNJ = new File(authorName + "-NJ.json");
            fIEEE.delete();
            fACM.delete();
            fNJ.delete();
        }
        if (matches == 0){
            System.out.println("No records were found for author(s) with name: "+authorName);
            System.out.println("No files have been created!");
        }else{
            System.out.println("A total of "+matches+" records were found for author(s) with name: "+authorName);
            System.out.println("Files "+authorName + "-IEEE.json, "+authorName + "-ACM.json and"+ authorName + "-NJ.json have been created!");
        }
        System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using AuthorBibCreated!");
    }
}
