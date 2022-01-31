// In order to help learn course concepts,
// I worked on the homework with [give the names of the people you worked with],
// discussed homework topics and issues with [John Igieobo],
// and/or consulted related material that can be found at
// [cite any other materials not provided as course materials for CS 1331 that assisted your learning].

import java.util.Scanner;

public class AnimalShelter {
    public static void main(String[] args) {
        // Do NOT touch these lines of code
        // Do NOT move these outside of the main Method
        String[][] shelter = new String[5][5];
        for (int i = 0; i < shelter.length; i++) {
            for (int j = 0; j < shelter.length; j++) {
                shelter[i][j] = "x";
            }
        }

        shelter[0][2] = "Stefanie";
        shelter[0][4] = "Tomas";
        shelter[1][0] = "Leedan";
        shelter[2][3] = "Andhru";
        shelter[3][1] = "Lio";
        shelter[3][2] = "Rhitvic";
        shelter[4][0] = "Nepun";
        shelter[4][3] = "Avenash";
        shelter[4][4] = "Dustan";
        // Your code below

        Scanner input = new Scanner(System.in);

        // A check to see if there are any animals in the pen
        int penCount = 0;
        for (int i = 0; i < shelter.length; i++) {
            for (int j = 0; j < shelter.length; j++) {
                if (shelter[i][j].equals("x")) {
                    penCount++;
                }
            }
        }

        System.out.println("Welcome to the Animal Shelter!");
        while (penCount != 25) {
            System.out.println("");
            System.out.println("Would you like to adopt a pet? [Y]es, [N]o, or [E]xit");
            String adoptPet = input.next();
            switch (adoptPet) {
            case "E":
                System.out.println("We hope you come again!");
                System.out.println("");
                return;
            case "N":
                System.out.println("Next person in line!");
                break;
            case "Y":
                System.out.println("");
                for (int i = 0; i < shelter.length; i++) {
                    for (int j = 0; j < shelter[i].length; j++) {
                        if (j == 0) {
                            System.out.print("|");
                        }
                        System.out.print(shelter[i][j] + "|");
                    }
                    System.out.println();
                }
                System.out.println("");
                System.out.println("What pet are you interested in adopting?");
                int i = input.nextInt();
                int j = input.nextInt();
                while (i >= shelter.length || j >= shelter.length) {
                    System.out.println("");
                    System.out.println("Location does not exist.");
                    System.out.println("");
                    System.out.println("What pet are you interested in adopting?");
                    i = input.nextInt();
                    j = input.nextInt();
                }
                while (shelter[i][j].equals("x")) {
                    System.out.println("");
                    System.out.println("There is no pet in this location.");
                    System.out.println("");
                    System.out.println("What pet are you interested in adopting?");
                    i = input.nextInt();
                    j = input.nextInt();
                }
                System.out.println("");
                System.out.println(shelter[i][j] + " has been successfully adopted!");
                shelter[i][j] = "x";
                penCount++;
                System.out.println("");
                for (i = 0; i < shelter.length; i++) {
                    for (j = 0; j < shelter[i].length; j++) {
                        if (j == 0) {
                            System.out.print("|");
                        }
                        System.out.print(shelter[i][j] + "|");
                    }
                    System.out.println();
                }
            default:
                break;
            }
        }
        System.out.println("");
        System.out.println("Sorry, we have no more pets!");
    }
}