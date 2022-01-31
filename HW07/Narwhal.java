/**
 * This class represents a Narwhal object
 * @author Linda Duong
 * @version 1.0
 */
public class Narwhal extends Pet {
    private int hornLength;

    /**
     * Creates a Narwhal object that has the following parameters
     * @param name name of Narwhal with a super call on the parent class constructor
     * @param age age of Narwhal with a super call on the parent class constructor
     * @param painLevel pain level of Narwha with a super call on the parent class constructor
     * @param hornLength hornlength of Narwhal in feet
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }
    /**
     * Creates a Narwhal object that has the following parameters and calls more specific constructor above
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            System.out.println("Who needs dogs and cats when we have each other");
            this.setPainLevel(this.getPainLevel() - 2);
        } else  if (!(p instanceof Narwhal)) {
            System.out.println("I live in the ocean so I can't play with you!");
            this.setPainLevel(this.getPainLevel() + 1);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "I have a horn that is " + hornLength + " feet long.";
    }

    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o)) || !(o instanceof Narwhal)) {
            return false;
        }
        Narwhal otherNarwhal = (Narwhal) o;
        return (super.equals(otherNarwhal) && otherNarwhal.hornLength == hornLength);
    }
    // public static void main(String[] args) {
    //     Narwhal one = new Narwhal("1", 1, -1, 1);
    //     Narwhal two = new Narwhal("1", 1, -10, 1);
    //     Dog dog1 = new Dog("1", 1, -1, "CHICHI");
    //     Cat cat1 = new Cat("1", 1, 1, true);

    //     // one.playWith(cat1);
    //     // System.out.println(one.getPainLevel());
    //     //System.out.println(one.equals(dog1));
    // }
}