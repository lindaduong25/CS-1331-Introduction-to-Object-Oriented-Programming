// I worked on the homework assignment alone, using only course materials.

public class Techmon {

    // instance variables
    private String name;
    private int level;
    private int happiness;

    // static constant/variables
    private static int techmonPopulation = 0;

    // constructors
    public Techmon(String name, int level, int happiness) {
        this.name = name;
        this.level = level;
        this.happiness = happiness;
        techmonPopulation++;
    }

    public Techmon(String name, int level) {
        this(name, level, 30);
    }

    public Techmon() {
        this("Buzz", 100, 252);
    }

    // getter methods
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHappiness() {
        return happiness;
    }
    public static int getTechmonPopulation() {
        return techmonPopulation;
    }

    // setter methods
    public void setLevel(int level) {
        if (level > 100) {
            this.level = 100;
        } else if (level < 0) {
            this.level = 0;
        } else {
            this.level = level;
        }
    }

    public void setHappiness(int happiness) {
        if (happiness > 252) {
            this.happiness = 252;
        } else if (happiness < 0) {
            this.happiness = 0;
        } else {
            this.happiness = happiness;
        }
    }

    // other methods
    public void eatTechSnax() {
        this.happiness += (0.25 * happiness);
        System.out.println("Yum Blue Donkey");
        this.setHappiness(happiness);
    }

    public void cry() {
        if (level <= 50) {
            this.happiness -= (0.5 * happiness);
        }
        this.happiness -= (0.25 * happiness);
        System.out.println("I'm tired");
        this.setHappiness(happiness);
        this.setLevel(level);
    }

    public static void assemble() {
        if (techmonPopulation > 5) {
            System.out.println("Stampede!");
        }
        System.out.println("These " + techmonPopulation + " are really cute!");
    }

    public String toString() {
        this.setLevel(level);
        this.setHappiness(happiness);
        return "My name is " + name + ", my level is " + level + ", and my happiness is " + happiness + "!";
    }
    public static void main(String[] args) {
        Techmon billy = new Techmon("Billy", 50, -1);
        System.out.println(billy.getHappiness());
    }

}