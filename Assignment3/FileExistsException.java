/*
 * Nigel Yong Sao Young, 40089856
 * COMP249
 * Assignment 3
 * Due 21/03/19
 */

/**
 * FileExistsException class
 */
public class FileExistsException extends Exception {
    /**
     * Constructor with default message
     */
    public FileExistsException(){
        super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!\n");
    }

    /**
     * Constructor with custom message
     * @param message stores message on error
     */
    public FileExistsException(String message){
        super(message);
    }
}
