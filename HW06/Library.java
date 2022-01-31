import java.util.Arrays;

/**
 * This class represents a library
 * @author Linda Duong
 * @version 1.0
 */
public class Library {

    private LibraryItem[] bookshelf;

    /**
     * Creates and initializes a bookshelf array of size 0
     */
    public Library() {
        bookshelf = new LibraryItem[0];
    }

    /**
     * This method takes in array of LibraryItems that will be the books on the bookshelf and sorts it
     * @param bookshelf an array of library objects
     */
    public Library(LibraryItem[] bookshelf) {
        this.bookshelf = bookshelf;
        Arrays.sort(bookshelf);
    }

    /**
     * This method prints out the summaries of all LibraryItems in the bookshelf for the library
     */
    public void browseLibraryItems() {
        for (LibraryItem item : bookshelf) {
            if (item != null) {
                System.out.print(item.getLibraryCode() + ": ");
                System.out.println(item.summarize());
            }
        }
    }

    /**
     * This method creates a new array of length + 1 that copies over all the previous elements
     * as well as adds the new item
     * @param newItem represents a library object that will be added to a bookshelf
     */
    public void addLibraryItem(LibraryItem newItem) {
        //System.out.println("hi");
        LibraryItem[] newBookshelf = new LibraryItem[bookshelf.length + 1];
        for (int i = 0; i < bookshelf.length; i++) {
            newBookshelf[i] = bookshelf[i];
        }
        newBookshelf[newBookshelf.length - 1] = newItem;
        Arrays.sort(newBookshelf);
        bookshelf = newBookshelf;
    }

    /**
     * This method returns the library item with the given code and returns null if the code does not exist
     * @param code target librarycode that is being searched for in the bookshelf of the library
     * @return library object that has the given code or null if the code does not exist
     */
    public LibraryItem getLibraryItem(int code) {
        for (LibraryItem item : bookshelf) {
            if (item.getLibraryCode() == code) {
                return item;
            }
        }
        return null;
    }
    /**
     * This method returns the number of items on the bookshelf
     * @return length or number of items on the bookshelf
     */
    public int getNumberOfItems() {
        return bookshelf.length;
    }

    // public static void main(String[] args) {

    //     Book book = new Book("BOOK", 1, "BACK COVER", 100);
    //     Magazine mag = new Magazine("MAG", 2, "coverDescription");
    //     Book addThis = new Book("ADDTHIS", 3, "This book is about...", 100);
    //     Magazine addAnotherOne = new Magazine("ADDANOTHERONE", 1, "This cover is about...");

    //     LibraryItem[] bookshelf = new LibraryItem[2];
    //     bookshelf[0] = book;
    //     bookshelf[1] = mag;

    //     Library shelf = new Library();
    //     shelf.addLibraryItem(addThis);
    //     shelf.addLibraryItem(addAnotherOne);
    //     shelf.browseLibraryItems();
    //     System.out.println(shelf.getLibraryItem(1));
    //     System.out.println(shelf.getNumberOfItems());
    // }
}