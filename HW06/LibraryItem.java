/**
 * This class represents a Library Item/Object
 * @author Linda Duong
 * @version 1.0
*/
public abstract class LibraryItem implements Summarizable, Comparable<LibraryItem> {

    private String title;
    private int libraryCode;

    /**
     * Creates a library object with the following parameters
     * @param title title of library item
     * @param libraryCode code of library item
     */
    public LibraryItem(String title, int libraryCode) {
        this.title = title;
        this.libraryCode = libraryCode;
    }
    /**
     * This getter methods returns the library code of a library object
     * @return library code of an object
     */
    public int getLibraryCode() {
        return libraryCode;
    }

    @Override
    public String summarize() {
        return "This item is called " + title + ".";
    }

    @Override
    public int compareTo(LibraryItem other) {
        return -(libraryCode - other.libraryCode);
    }
}