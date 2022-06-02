package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitGame = false;

        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.abandon(new VirtualPet("Frodo", 0, "Dog", 1, 1, false));
        shelter.abandon(new VirtualPet("Samwise", 0, "Cat", 1, 1, false));
        shelter.abandon(new VirtualPet("Merry", 0, "Dog", 1, 1, false));
        shelter.abandon(new VirtualPet("Pippin", 0, "Cat", 1, 1, false));
        shelter.abandon(new VirtualPet("Bilbo", 0, "Dog", 5, 5, false));
        System.out.println("Welcome to your Pounce's Play Palace & Pet Shelter! Let's meet our current pets available first:");
        shelter.listAll();


//Run the game!
        while (!exitGame) {
            System.out.println("What would you like to do? You can 'adopt' a pet XD, 'abandon' one :'(, 'play', 'feed', 'nap', 'meet' and check the 'status' of any pet, or all of them! Type 'quit' to quit.");
            String userInput = input.nextLine();
            switch (userInput.toLowerCase()){
                case "quit":
                    exitGame = true;
                    break;
                case "status":
                    shelter.statusAll();
                    break;
                case "adopt":
                    System.out.println("Who would you like to adopt? Please type their room number...");
                    shelter.listAll();
                    int adoptRoom = input.nextInt();
                    input.nextLine();
                    System.out.println("Thank you for adopting " + shelter.getPetShelter().get(adoptRoom-1).getName() + ", they're going to love their new fur-ever home!");
                    shelter.adoptPet(adoptRoom-1);
                    break;
                case "abandon":
                    System.out.println("What is your pet's name?");
                    String newName = input.nextLine();
                    System.out.println("Is " + newName + " a cat or dog?");
                    String newPet = input.nextLine();
                    shelter.abandon(new VirtualPet(newName, 25, newPet, 0, 50, false));
                    System.out.println("You have successfully abandoned " + newName + " T_T");
                    break;
                case "meet":
                    shelter.meetAll();
                    shelter.tick();
                    break;
                case "play":
                    shelter.playAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "feed":
                    shelter.feedAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "nap":
                    shelter.napAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                default:
                    System.out.println("All you hear is howls, barking and hissing. Command not recognized...");
            }
        }

        System.out.println("Goodbye!");
    }

}
