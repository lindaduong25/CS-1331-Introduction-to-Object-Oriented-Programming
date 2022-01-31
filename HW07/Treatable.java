// I worked on the homework assignment alone, using only course materials.

/**
 * This interface guarantees an Object is Treatable, or more specifically that they have a treat method.
 * @author Linda Duong
 * @version 1.0
 */
public interface Treatable {

    /**
     * This static method returns the dog’s age in human years.
     * @param dogAge age of the dog
     * @return age of the dog in human years
     */
    static int convertDogToHumanYears(int dogAge) {
        return (int) (16 * Math.log(dogAge) + 31);
    }
    /**
     * This static method returns the cat's age in human years.
     * @param catAge age of the cat
     * @return age of the cat in human years
     */
    static int convertCatToHumanYears(int catAge) {
        return (int) (9 * Math.log(catAge) + 18);
    }
    /**
     * Implementations of this method should improve the condition of the Treatable object in some way
     */
    void treat();
}