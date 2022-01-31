/**
 * This class represents a Cat object
 * @author Linda Duong
 * @version 1.0
 */
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;

    /**
     * Creates a Cat object with the following parameters
     * @param name name of Cat that uses super call on parent class constructor
     * @param age age of Cat that uses super call on parent class constructor
     * @param painLevel pain level of Cat that uses super call on parent class constructor
     * @param hasStripes boolean value that indicates whether a cat has stripes or not
     */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }
    /**
     * Creates a Cat object with the following parameters and calls more specific constructor above
     * @param hasStripes boolean value of whether cat has stripes or not
     */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }
    /**
     * This getter method returns a boolean value indicating whether a cat has stripes or not
     * @return boolean value that indicates whether cat has stripes or not
     */
    public boolean getHasStripes() {
        return hasStripes;
    }

    @Override
    public void playWith(Pet p) {
        int currentPainLevel = this.getPainLevel();
        if (p instanceof Cat) {
            Cat anotherCat = (Cat) p;
            if ((anotherCat.hasStripes && this.hasStripes) || (!anotherCat.hasStripes && !this.hasStripes)) {
                this.setPainLevel(currentPainLevel - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");
            } else {
                this.setPainLevel(currentPainLevel - 2);
                System.out.println("Meow! I love playing with other cats without the same pattern as me");
            }
        } else if (p instanceof Dog) {
            Dog anotherDog = (Dog) p;
            this.setPainLevel(currentPainLevel + 1);
            System.out.println("Meow. Go away " + anotherDog.getName() + "! I don't like playing with Dogs!");
        }
    }

    @Override
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 1);
    }
    @Override
    public String toString() {
        return super.toString() + "My age in human years is " + Treatable.convertCatToHumanYears(this.getAge());
    }
    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o)) || !(o instanceof Cat)) {
            return false;
        }
        Cat otherCat = (Cat) o;
        return (super.equals(otherCat) && otherCat.hasStripes == hasStripes);
    }

    // public static void main(String[] args) {
    //     Cat cat1 = new Cat("1", 10, 10, true);
    //     Cat cat2 = new Cat("1", 10, 10, true);
    //     Dog dog1 = new Dog("1", 1, 1, "CHICHI");
    //     Narwhal narwhal1 = new Narwhal("1", 1, 1, 10);

    //     cat1.playWith(cat2);
    //     // cat1.playWith(narwhal1);
    //     // cat1.treat();
    //     // System.out.println(cat1.getPainLevel());
    //     System.out.println(cat1.equals(cat2));
    // }
}