// I worked on the homework assignment alone, using only course materials.

/**
 * This class represents a Tekemon object
 * @author Linda Duong
 * @version 1.0
 */
public abstract class Tekemon {

    // instance variables
    private String name;
    private int level;
    private int stamina;

    // constructors

    /**
     * Creates a Tekemon with the following parameters
     * @param name name of Tekemon
     * @param level level of Tekemon
     * @param stamina stamina of Tekemon
     */
    public Tekemon(String name, int level, int stamina) {
        this.name = name;
        this.level = level;
        this.stamina = stamina;
    }

    // getter methods

    /**
     * This getter method returns the name of the Tekemon
     * @return name of Tekemon
     */
    public String getName() {
        return name;
    }

    /**
     * This getter method returns the level of the Tekemon
     * @return level of Tekemom
     */
    public int getLevel() {
        return level;
    }
    /**
     * This method returns the stamina of the Tekemon
     * @return stamina of the Tekemon
     */
    public int getStamina() {
        return stamina;
    }

    // setter methods

    /**
     * This setter method sets the stamina equal to 0 if stamina is below 0,
     * otherwise the stamina is equal to the parameter stamina
     * @param stamina represents the stamina of the Tekemon
     */
    public void setStamina(int stamina) {
        if (stamina < 0) {
            this.stamina = 0;
        } else {
            this.stamina = stamina;
        }
    }

    /**
     * This setter method sets the level of the Tekemon equal to the parameter level
     * @param level represents the level of the Tekemon
     */
    public void setLevel(int level) {
        this.level = level;
    }

    // other methods

    /**
     * This method gets called by a Tekemon with another Tekemon as the parameter to a battle
     * @param t Tekemon object
     */
    public void duel(Tekemon t) {

    }

    /**
     * This method increases a Tekemon's stamina by 15
     */
    public void potion() {
        this.stamina += 15;
    }

    /**
     * This method inceases a Tekemon's level
     */
    public void levelUp() {

    }

    /**
     * This method checks to see if an object is a Tekemon and returns false if not
     * or true if both Tekemons contain the same values for the parameters
     * @param o represents an object
     * @return boolean value that shows whether or not two Tekemons are equal
     */
    public boolean equals(Object o) {
        if (!(o instanceof Tekemon)) {
            return false;
        }
        Tekemon tekemon = (Tekemon) o;
        return ((tekemon.name.equals(name)) && (tekemon.level == level) && (tekemon.stamina == stamina));
    }

    /**
     * This method returns a sentence with the following : name, level, and stamina of the Tekemon included
     * @return a string that states the name, level, and stamina of the Tekemon
     */
    public String toString() {
        return "My name is " + name + ", and I am a Tekemon. My level is "
            + level + " and my current stamina is " + stamina + ".";
    }

}