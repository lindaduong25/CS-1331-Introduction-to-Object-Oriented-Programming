/**
 * This class represents a Magazine object
 * @author Linda Duong
 * @version 1.0
 */
public class Magazine extends LibraryItem implements Summarizable {

    private String coverDescription;

    /**
     * Creates a Magazine object with the following parameters
     * @param title title of Magazine that uses a super call on parent class constructor
     * @param libraryCode library code of Magazine that uses a super call on parent class constructor
     * @param coverDescription short description of the Magazine
     */
    public Magazine(String title, int libraryCode, String coverDescription) {
        super(title, libraryCode);
        this.coverDescription = coverDescription;
    }

    @Override
    public String summarize() {
        return super.summarize() + " This cover looks like " + coverDescription + ".";
    }
}