import java.util.Random;

/**
 * This class represents a Firemon object and is a subclass of Tekemon
 * @author Linda Duong
 * @version 1.0
 */
public class Firemon extends Tekemon {

    // instance variables
    private int knowledgeLevel;
    private int firePoints;

    // constructors

    /**
     * Creates a Firemon object with the following parameters
     * @param name name of Firemon that uses super call on parent class constructor
     * @param level level of Firemon that uses super call on parent class constructor
     * @param stamina stamina of Firemon that uses super call on parent class constructor
     * @param knowledgeLevel knowledge level of the Firemon
     * @param firePoints amount of fire points the Firemon has
     */
    public Firemon(String name, int level, int stamina, int knowledgeLevel, int firePoints) {
        super(name, level, stamina);
        this.knowledgeLevel = knowledgeLevel;
        this.firePoints = firePoints;
    }

    /**
     * Creates a Firemon object with the name parameter and other parameters are default values
     * This constructor utilizes constructor chaining
     * @param name name of Firemon
     */
    public Firemon(String name) {
        this(name, 30, 20, 30, 0);
    }

    // getter methods

    /**
     * This method returns the knowledge of the Firemon object
     * @return knowledge level of the Firemon
     */
    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    /**
     * This method returns the amount of fire points a Firemon has or accumulates
     * @return firePoints represents the amount of fire points that the Firemon object has
     */
    public int getFirePoints() {
        return firePoints;
    }

    // other methods

    @Override
    public void duel(Tekemon t) {
        if (t instanceof Firemon) {
            System.out.println("Cannot duel an ally!");
            return;
        }
        if (this.getStamina() == 0 || t.getStamina() == 0) {
            System.out.println("Cannot duel!");
            return;
        }
        if (this.getKnowledgeLevel() > 13) {
            Random rand = new Random();
            int attackInt = 1;
            attackInt = rand.nextInt(10) + 1;
            System.out.println(attackInt);
            if (attackInt % 2 != 0) {
                this.fireFight();
                return;
            }
            if (this.getKnowledgeLevel() <= 13) {
                return;
            }
        }
        t.setStamina(t.getStamina() - (15 + this.getLevel() / 2));
        if (t.getStamina() < 0) {
            t.setStamina(0);
        }
        if (t.getStamina() == 0) {
            this.firePoints += (t.getLevel() / 2);
            this.levelUp();
        }
    }

    /**
     * This method adds a certain amount of points to fire points depending on
     * certain conditions and as long as the Firemon's stamina is greater than 25
     * levelUp is called in case the Firemon is at a certain level and has enough points that
     * make it eligible to level up
     */
    public void fireFight() {
        if (this.getStamina() > 25) {
            if (this.getKnowledgeLevel() >= 30) {
                this.firePoints += 20;
            } else if (this.getKnowledgeLevel() < 30) {
                this.firePoints += 10;
            }
            System.out.println("We won the fight, yay!");
        }
        this.levelUp();
    }

    @Override
    public void levelUp() {
        while (this.getLevel() < 30 && this.getFirePoints() >= 20) {
            this.setLevel(this.getLevel() + 1);
            System.out.println("Yay, I am now level " + this.getLevel() + "!");
            this.firePoints -= 20;
        }
        while (this.getLevel() >= 30 && this.getFirePoints() >= 40) {
            this.setLevel(this.getLevel() + 1);
            System.out.println("Yay, I am now level " + this.getLevel() + "!");
            this.firePoints -= 40;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o)) || !(o instanceof Firemon)) {
            return false;
        }
        Firemon firemon = (Firemon) o;
        return (firemon.getKnowledgeLevel() == (this.getKnowledgeLevel()));
    }

    /**
     * This method returns a string with a super call on the toString() method of Tekemon
     * detailing the name, level, and stamina along with a sentence stating that
     * the Firemon is a Firemon and what its knowledge level is
     * @return a string that states the name, level, stamina, and knowledge level of the Firemon
     */
    public String toString() {
        return super.toString() + " I am a Firemon, and I have " + this.getKnowledgeLevel() + " knowledge.";
    }

    public static void main(String[] args) {
        Firemon one = new Firemon("one", 13, 12, 15, 20);
        Icemon two = new Icemon("two");

        one.duel(two);
    }

}