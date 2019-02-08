// -----------------------------------------------------
// Assignment 1
// Question: Part 1
// Written by: Nigel Yong Sao Young, 40089856
// -----------------------------------------------------

/* This program is a book tracker. The user will be able to enter new books onto the system and change information of any books. The user will be also able to
* display all books by a specific author and all books under a certain price. Information kept on the books are the title, the author, the ISBN and
* the price of the book.
*
* Also, a password is required for entering a new book and updating information of an existing book. */

import java.util.Scanner;

/**
 * Created by Nigel Yong on 31/01/19
 * Book class to store title, author, ISBN and price information
 */
public class Book {
    private String title;
    private String author;
    private long ISBN;
    private double price;
    public static int noBooks = 0;

    /**
     * This is a copy constructor to initialize a Book object.
     * @param b stores the other book being copied
     */
    public Book(Book b) {
        this.setPrice(b.getPrice());
        this.setISBN(b.getISBN());
        this.setTitle(b.getTitle());
        this.setAuthor(b.getAuthor());
    }

    /**
     * This is a constructor to initialize a Book object.
     * @param title initial title name
     * @param author initial author name
     * @param ISBN initial ISBN
     * @param price initial price
     */
    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        noBooks++;
    }

    /**
     * get title of the book
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * get author of the book
     * @return author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * get ISBN of the book
     * @return ISBN of the book
     */
    public long getISBN() {
        return ISBN;
    }

    /**
     * get Price of the book
     * @return price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     *  set title of the book
     * @param title new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * set author of the book
     * @param author new author of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * set ISBN of the book
     * @param ISBN new ISBN of the book
     */
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    /** set price of the book
     * @param price new price of the book
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * toString method
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Book{" +
                "title=\"" + title + '\"' +
                ", author=\"" + author + '\"' +
                ", ISBN=" + ISBN +
                ", price=" + price +
                '}';
    }

    /**
     * findNumberOfCreatedBooks method
     * @return the number of created books
     */
    public static int findNumberOfCreatedBooks() {
        return noBooks;
    }

    /**
     * equals method
     * @param obj stores the object being compared
     * @return Indicates whether some other object is "equal to" this one
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book book = (Book) obj;
        return getISBN() == book.getISBN() &&
                getPrice()==book.getPrice() &&
                getTitle().equals(book.getTitle()) &&
                getAuthor().equals(book.getAuthor());
    }

    /**
     * findBookBy method
     * @param author stores the wanted author of the book
     * @param inventory stores the array of books
     * @return an array of books by the wanted author
     */
    public static Book[] findBookBy(String author, Book[] inventory) {
        Book[] bookBy = new Book[inventory.length];
        int matchCount = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && author.equalsIgnoreCase(inventory[i].getAuthor())) {
                bookBy[matchCount] = inventory[i];
                matchCount++;
            }
        }
        return bookBy;
    }

    /**
     * findCheaperThan
     * @param price stores the maximum price of books the user wants
     * @param inventory stores the array of books
     * @return an array of books cheaper than the price
     */
    public static Book[] findCheaperThan(Double price, Book[] inventory) {
        Book[] bookCheap = new Book[inventory.length];
        int matchCount = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && price > inventory[i].getPrice()) {
                bookCheap[matchCount] = inventory[i];
                matchCount++;
            }
        }
        return bookCheap;
    }

    /**
     * This is the main method that will run the program
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        int maxBooks; // stores the maximum number of books
        int choice = 0; // stores the menu choice
        int pwCount = 0, pwCount2 = 0; // stores failed attempts for the option 1 and 2
        int newBooks = 0; // stores number of new books to be entered for option 1
        int update = 0; // stores which book number to update for option 2
        boolean unlock, empty = true;
        final String password = "password";


        // Banner message
        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("						  Welcome to the Book Tracker! (By Nigel Yong)");
        System.out.println("------------------------------------------------------------------------------------------------");

        System.out.print("What is the maximum number of books that your bookstore can contain? ");
        maxBooks = keyIn.nextInt();

        Book[] inventory = new Book[maxBooks]; // creates array of books

        do {
            unlock = false;
            do {
                System.out.print("\nWhat do you want to do?\n" +
                        "1. Enter new books (password required)\n" +
                        "2. Change information of a book (password required)\n" +
                        "3. Display all books by a specific author\n" +
                        "4. Display all books under a certain price.\n" +
                        "5. Quit\n" +
                        "Please enter your choice > ");
                choice = keyIn.nextInt();
            } while (choice < 1 || choice > 5);

            if (choice == 1) { // Enter new books (password required)
                do {
                    System.out.print("Please enter your password: ");
                    if (keyIn.next().equals(password)) {
                        unlock = true;
                        pwCount = 0;
                    }else{
                        pwCount++;
                    }

                    if ((pwCount) == 12) { // terminates program if 12 failed attempts
                        System.out.println("\nProgram detected suspicious activities and will terminate immediately!\n");
                        System.exit(0);
                    } else if ((pwCount) % 3 == 0 && pwCount != 0) {
                        break; // goes to the main menu
                    }

                } while (!unlock);

                if (!unlock){ // goes to the main menu
                    continue;
                }

                System.out.print("How many books do you wish to enter? ");
                newBooks = keyIn.nextInt();

                if(newBooks == 0){
                    System.out.println("No new books entered, back to the main menu.");
                } else if (newBooks <= inventory.length - Book.findNumberOfCreatedBooks()) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] == null) {
                            keyIn.nextLine(); // to consume the rest of the new line
                            System.out.println("\nBook number " + (findNumberOfCreatedBooks() + 1));
                            inventory[i] = new Book("", "", 0, 0);
                            System.out.print("\nEnter the book's title: ");
                            inventory[i].setTitle(keyIn.nextLine());
                            System.out.print("Enter the author's name: ");
                            inventory[i].setAuthor(keyIn.nextLine());
                            System.out.print("Enter the book's ISBN: ");
                            inventory[i].setISBN(keyIn.nextLong());
                            System.out.print("Enter the book's price: ");
                            inventory[i].setPrice(keyIn.nextDouble());

                            newBooks--; // reduces the number of books to be entered
                        }
                        if (newBooks == 0) {
                            break; // goes to the main menu
                        }
                    }
                } else {
                    System.out.println("There is only " + (inventory.length - Book.findNumberOfCreatedBooks()) + " free places on the shelf.");
                }

            } else if (choice == 2) { // Change information of a book (password required)
                pwCount2 = 0;
                do {
                    System.out.print("Please enter your password: ");
                    if (keyIn.next().equals(password)) {
                        unlock = true;
                        pwCount2 = 0;
                    }else{
                        pwCount2++;
                    }
                    if ((pwCount2) % 3 == 0 && pwCount2 != 0) {
                        break; // gets out of the while loop and then goes back to the main menu
                    }
                } while (!unlock);

                if (!unlock){
                    continue; // goes to main menu
                }

                do {
                    System.out.print("Which book number do you wish to update? ");
                    update = keyIn.nextInt();

                    if (inventory[update - 1] == null) {
                        System.out.println("Sorry there is no book at this location.");
                        System.out.println("Please enter another book number if you wish to update or enter -1 to quit and go to the main menu.");
                        update = keyIn.nextInt();

                        if (update == -1)
                            break; // gets out of the while loop and goes to the main menu
                    }
                } while (inventory[update - 1] == null);

                if (update == -1)
                    continue; // goes back to the main menu

                System.out.println("\nBook " + update + "\n" +
                        "Author: " + inventory[update - 1].getAuthor() + "\n" +
                        "Title: " + inventory[update - 1].getTitle() + "\n" +
                        "ISBN: " + inventory[update - 1].getISBN() + "\n" +
                        "Price: $" + inventory[update - 1].getPrice() + "");

                do {
                    do {
                        System.out.print("\nWhat information would you like to\n" +
                                "change?\n" +
                                "1. author\n" +
                                "2. title\n" +
                                "3. ISBN\n" +
                                "4. price\n" +
                                "5. Quit\n" +
                                "Enter your choice > ");
                        choice = keyIn.nextInt();
                    } while (choice < 1 || choice > 5);
                    keyIn.nextLine();

                    if (choice == 5) {
                        break; // goes to the main menu
                    } else if (choice == 1) {
                        System.out.print("Change author name to: ");
                        inventory[update-1].setAuthor(keyIn.nextLine());
                    } else if (choice == 2) {
                        System.out.print("Change book title to: ");
                        inventory[update-1].setTitle(keyIn.nextLine());
                    } else if (choice == 3) {
                        System.out.print("Change book ISBN to: ");
                        inventory[update-1].setISBN(keyIn.nextLong());
                    } else if (choice == 4) {
                        System.out.print("Change book price to: ");
                        inventory[update-1].setPrice(keyIn.nextDouble());
                    }
                    System.out.println("\nBook # " + update + "\n" +
                            "Author: " + inventory[update-1].getAuthor() + "\n" +
                            "Title: " + inventory[update-1].getTitle() + "\n" +
                            "ISBN: " + inventory[update-1].getISBN() + " #\n" +
                            "Price: $" + inventory[update-1].getPrice() + "");
                } while (true);

            } else if (choice == 3) { // Display all books by a specific author
                System.out.print("Which author's books are you looking for? ");
                keyIn.nextLine();
                Book[] bookBy = findBookBy(keyIn.nextLine(), inventory);
                for (int i = 0; i < bookBy.length; i++) { // goes through array of the author's books and display their information
                    if (bookBy[i] != null) {
                        System.out.println(bookBy[i]);
                        empty = false;
                    }
                }
                if(empty)
                    System.out.println("Sorry, there is no book from this author");
                empty = true;
            } else if (choice == 4) { // Display all books under a certain a price
                System.out.print("\nWhich price are you willing to pay? ");
                Book[] bookCheap = findCheaperThan(keyIn.nextDouble(), inventory);
                for (int i = 0; i < bookCheap.length; i++) { // goes through array of cheaper books and display their information
                    if (bookCheap[i] != null) {
                        System.out.println(bookCheap[i]);
                        empty = false;
                    }
                }
                if(empty)
                    System.out.println("Sorry, there is no book cheaper than the price you gave.");
                empty = true;
            } else if (choice == 5) { // Quit
                System.out.println("\n-------------------------------------------------------------------------------------------------\n" +
                        "\t\t\t\t\t\t\tSee you soon to the Book Tracker :D\n" +
                        "-------------------------------------------------------------------------------------------------");
                break; // ends the program
            }
        } while (true);
        keyIn.close();
    }
}
