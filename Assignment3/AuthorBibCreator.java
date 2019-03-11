import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class AuthorBibCreator {
    public static void main(String[] args) {
        String authorName;
        Scanner keyIn = new Scanner(System.in);
        Scanner sc = null;

        System.out.println("Welcome to BibCreator!");
        System.out.println("Please enter the author name you are targeting: ");
        authorName = keyIn.nextLine();

        for (int i = 1; i <= 10; i++){
            try{
                sc = new Scanner(new FileInputStream("Latex"+i+".bib"));
                File f = new File("Latex"+i+".bib");
                if (f.exists()){
                    throw new FileExistsException();
                }
            }catch (FileExistsException e){
                System.out.println("Could not open input file Latex"+i+".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");
            }catch(FileNotFoundException e){

            }
        }

    }
}
