/**
 * This class represents a Dog object
 * @author Linda Duong
 * @version 1.0
 */
public class Dog extends Pet implements Treatable {
    private String breed;
    /**
     * Creates a Dog object with the following parameters
     * @param name name of Dog that uses a super call on the parent class constructor
     * @param age age of Dog that uses a super call on the parent class constructor
     * @param painLevel pain level of Dog that uses a super call on the parent class constructor
     * @param breed breed of the Dog
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }
    /**
     * Creates a Dog object with the following parameter and calls more specific constructor above
     * @param breed breed of the Dog
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }
    /**
     * This getter method returns the breed of the dog
     * @return breed of the dog
     */
    public String getBreed() {
        return breed;
    }

    @Override
    public void playWith(Pet p) {
        int oldPainLevel = this.getPainLevel();
        if (p instanceof Dog) {
            int newPainLevel = oldPainLevel - 3;
            this.setPainLevel(newPainLevel);
            System.out.println("Woof! I love playing with other dogs so much that my pain level went from "
                + oldPainLevel + " to " + newPainLevel);
        } else if (p instanceof Cat) {
            Cat playingCat = (Cat) p;
            if (!playingCat.getHasStripes()) {
                int newPainLevel = oldPainLevel - 1;
                this.setPainLevel(newPainLevel);
                System.out.println("Woof! Cats without stripes are okay since they made my pain level go from "
                    + oldPainLevel + " to " + newPainLevel);
            } else if (playingCat.getHasStripes()) {
                this.setPainLevel(oldPainLevel + 2);
                System.out.println("AHHH! I thought you were a tiger!");
            }
        }
    }

    @Override
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 3);
    }
    /**
     * This method prints out a string when called by Dog object
     */
    public void bark() {
        System.out.println("bark bark");
    }

    @Override
    public String toString() {
        return "My name is " + this.getName() + ", I am "  + this.getAge() + ", and I am a " + breed
            + ". On a scale from one to ten my pain level is " + this.getPainLevel() + "."
            + " My age in human years is " + Treatable.convertDogToHumanYears(this.getAge()) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o)) || !(o instanceof Dog)) {
            return false;
        }
        Dog otherDog = (Dog) o;
        return (super.equals(otherDog) && otherDog.getBreed().equals(this.getBreed()));
    }

    // public static void main(String[] args) {
    //     Dog dog1 = new Dog("1", 1, 10, "CHICHI");
    //     Dog dog2 = new Dog("1", -1, 10, "CHICHI");

    //     Narwhal narwhal1 = new Narwhal("1", 10, 10, 10);

    //     Cat cat1 = new Cat("1", 2, 2, true);
    //     // dog1.playWith(cat1);
    //     // dog1.treat();
    //     // dog1.bark();
    //     // System.out.println(dog1.getPainLevel());
    //     // System.out.println(dog1.equals(dog2));
    //     // System.out.println(dog1.getPainLevel());
    //     // System.out.println(dog2.getPainLevel());
    //     // dog1.playWith(narwhal1);
    //     // Vet.treatPet(cat1);
    //     // System.out.println(dog1.equals(dog2));
    //     System.out.println(dog1);
    // }

}