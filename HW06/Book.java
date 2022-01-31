/**
 * This class represents a Book object
 * @author Linda Duong
 * @version 1.0
 */
public class Book extends LibraryItem implements Summarizable {

    private String backcoverBlurb;
    private int pages;

    /**
     * Creates a Book object with the following parameters
     * @param title tile of Book that uses a super call on parent class constructor
     * @param libraryCode library code of Book that uses a super call on parent class constructor
     * @param backcoverBlurb short description of the Book
     * @param pages number of pages the Book has
     */
    public Book(String title, int libraryCode, String backcoverBlurb, int pages) {
        super(title, libraryCode);
        this.backcoverBlurb = backcoverBlurb;
        this.pages = pages;
    }

    @Override
    public String summarize() {
        return super.summarize() + " The book is " + pages + " pages long. " + backcoverBlurb + ".";
    }
}