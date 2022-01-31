/**
 * This class represents an Icemon object and is a subclass of Tekemon
 * @author Linda Duong
 * @version 1.0
 */
public class Icemon extends Tekemon {

    // instance variables
    private boolean pet;
    private static int icemonSize;
    private int icePoints;

    // constructors

    /**
     * Creates a Icemon object with the following parameters
     * @param name name of Icemon that uses super call on parent class constructor
     * @param level level of Icemon that uses super call on parent class constructor
     * @param stamina stamina of Icemon that uses super call on parent class constructor
     * @param pet whether the Icemon has a pet or not represented with a boolean value
     * @param icePoints represents the amount of ice points the Icemon has
     */
    public Icemon(String name, int level, int stamina, boolean pet, int icePoints) {
        super(name, level, stamina);
        this.pet = pet;
        this.icePoints = icePoints;
        icemonSize++;
    }

    /**
     * Creates a Icemon object with the name parameter and other parameters are default values
     * This constructor utilizes constructor chaining
     * @param name name of Icemon
     */
    public Icemon(String name) {
        this(name, 15, 100, true, 0);
    }

    // getter methods

    /**
     * This method returns true or false depending on if the Icemon has a pet or not
     * @return boolean value true if Icemon has pet or false if Icemon does not have a pet
     */
    public boolean getPet() {
        return pet;
    }
    /**
     * This method returns the amount of ice points that a Icemon object has or accumulates
     * @return icePoints represents the amount of ice points a Icemon object has
     */
    public int getIcePoints() {
        return icePoints;
    }

    /**
     * This static method returns how many Icemon objects are created
     * @return icemonSize represents the amount of Icemon objects created
     */
    public static int getIcemonSize() {
        return icemonSize;
    }

    // other methods

    @Override
    public void duel(Tekemon t) {
        if (t instanceof Icemon) {
            System.out.println("Cannot duel an ally!");
            return;
        }
        if (this.getStamina() == 0 || t.getStamina() == 0) {
            System.out.println("Cannot duel!");
            return;
        }
        t.setStamina(t.getStamina() - (2 * this.getLevel()));
        if (t.getStamina() < 0) {
            t.setStamina(0);
        }
        if (t.getStamina() == 0) {
            this.icePoints += (t.getLevel() / 2);
            this.levelUp();
        }
    }

    @Override
    public void levelUp() {
        while (this.getLevel() < 20 && this.getIcePoints() >= 20) {
            this.setLevel(this.getLevel() + 1);
            System.out.println("Yay, I am now level " + this.getLevel() + "!");
            this.icePoints -= 20;
        }
        while (this.getLevel() >= 20 && this.getIcePoints() >= 30) {
            this.setLevel(this.getLevel() + 1);
            System.out.println("Yay, I am now level " + this.getLevel() + "!");
            this.icePoints -= 30;
        }
    }

    /**
     * This method icreases the amount of ice points a Icemon object has by a certain percentage
     * that is dependent on the icemon size
     */
    public void iceWreck() {
        double percentage = (icemonSize * 10D) / 100;
        this.icePoints += (percentage * this.getIcePoints());
    }

    /**
     * This method increases the stamina by half of the current ice points that a Icemon has and
     * when the method is used, the ice points are decreased by 5
     * If the ice points happen to fall below 0 then the method sets ice points equal to 0 and if
     * the ice points are below 0 then the brainFreeze move cannot be used
     */
    public void brainFreeze() {
        if (icePoints < 5) {
            return;
        }
        this.setStamina(this.getStamina() + this.getIcePoints() / 2);
        this.icePoints -= 5;
        if (this.getIcePoints() < 0) {
            this.icePoints = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o)) || !(o instanceof Icemon)) {
            return false;
        }
        Icemon icemon = (Icemon) o;
        return ((icemon.getPet() == this.getPet()));
    }

    /**
     * This method returns a string with a super call on the toString() method of Tekemon
     * detailing the name, level, and stamina along with a sentence stating that
     * the Icemon is a Icemon and whether or not it has a pet
     * @return a string that states the name, level, stamina, and whether or not the Icemon has a pet
     */
    public String toString() {
        if (!this.getPet()) {
            return super.toString() + " I am a Icemon, and I do not have a pet.";
        }
        return super.toString() + " I am a Icemon, and I do have a pet.";
    }

}