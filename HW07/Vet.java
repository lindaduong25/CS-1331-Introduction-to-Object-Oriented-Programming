/**
 * This class represents a veterinarian clinic that can treat Pet objects
 * @author Linda Duong
 * @version 1.0
 */
public abstract class Vet {

    /**
     * This static method prints the toString method of the pet
     * @param pet pet object
     */
    public static void inspectPet(Pet pet) {
        pet.toString();
        if (pet instanceof Dog) {
            Dog petDog = (Dog) pet;
            petDog.bark();
        }
    }

    /**
     * This static method accepts any Pet object and checks to see if a pet is treatable or not
     * @param pet pet object
     */
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.getName());
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                System.out.println("Wow what a cute dog!");
                giveDogTreat(dog);
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }

    /**
     * This static method decreases the dog's pain by 2
     * @param dog dog object
     */
    public static void giveDogTreat(Dog dog) { // do we assume only Dog object will be passed in
        dog.setPainLevel(dog.getPainLevel() - 2);
    }

}