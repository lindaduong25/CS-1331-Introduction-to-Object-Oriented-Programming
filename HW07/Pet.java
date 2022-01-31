/**
 * This class represents a generic Pet. You must not be able to create an instance of this class
 * @author Linda Duong
 * @version 1.0
 */
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    /**
     * Creates a Pet object with the following parameters
     * @param name name of the pet
     * @param age age of the pet
     * @param painLevel pain level of the pet
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        // bounds for age
        if (age < 0) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }
        // bounds for painLevel
        if (painLevel < 0) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }
    /**
     * This getter method returns the name of the pet
     * @return name of the pet
     */
    public String getName() {
        return name;
    }
    /**
     * This getter method returns the age of the pet
     * @return age of the pet
     */
    public int getAge() {
        return age;
    }
    /**
     * This getter method returns the pain level of the pet
     * @return pain level of the pet
     */
    public int getPainLevel() {
        return painLevel;
    }
    /**
     * This setter method sets the age of the pet to the closest bound if the age is out of the bounds
     * @param age age of the pet
     */
    public void setAge(int age) {
        if (age < 0) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }
    }
    /**
     * This setter method sets the pain level of the pet to the closest bound if the pain level is out of bounds
     * @param painLevel pain level of the pet
     */
    public void setPainLevel(int painLevel) {
        if (painLevel < 0) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }
    /**
     * This Abstract method represents this Pet playing with the another Pet
     * @param p another pet object
     */
    abstract void playWith(Pet p);

    /**
     * This method checks to see if two pets are equal
     * @param p represents an object
     * @return true or false depending on if the two pets are equal
     */
    public boolean equals(Object p) {
        if (!(p instanceof Pet)) {
            return false;
        }
        Pet otherPet = (Pet) p;
        return (otherPet.name.equals(name) && otherPet.age == age && otherPet.painLevel == painLevel);
    }
    /**
     * This method returns a summary of info about the pet such as name, age, and pain level
     * @return String that is a summary of the pet
     */
    public String toString() {
        return "My name is " + name + ", and I am " + age // add comma after name?
            + ". On a scale of one to ten my pain level is " + painLevel + ". ";
    }
}