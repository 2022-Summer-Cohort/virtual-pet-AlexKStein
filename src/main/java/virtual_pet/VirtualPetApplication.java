package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitGame = false;
        int petRoom;
//        boolean loopy = false;

        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.abandon(new VirtualPet("Frodo", 0, "Dog", 1, 1, false));
        shelter.abandon(new VirtualPet("Samwise", 0, "Cat", 1, 1, false));
        shelter.abandon(new VirtualPet("Merry", 0, "Dog", 1, 1, false));
        shelter.abandon(new VirtualPet("Pippin", 0, "Cat", 1, 1, false));
        shelter.abandon(new VirtualPet("Bilbo", 0, "Dog", 5, 5, false));
        System.out.println("Welcome to your Pounce's Play Palace & Pet Shelter! Let's meet our current pets available first:");
        shelter.meetAll();


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
                    int adoptRoom = input.nextInt()-1;
                    input.nextLine();
                    if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    System.out.println("Thank you for adopting " + shelter.getPetShelter().get(adoptRoom).getName() + ", they're going to love their new fur-ever home!");
                    shelter.adoptPet(adoptRoom);
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "abandon":
                    System.out.println("What is your pet's name?");
                    String newName = input.nextLine();
                    if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    System.out.println("Is " + newName + " a cat or dog?");
                    String newPet = input.nextLine();
                    if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    shelter.abandon(new VirtualPet(newName, 25, newPet, 0, 50, false));
                    System.out.println("You have successfully abandoned " + newName + " T_T");
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "meet":
                    System.out.println("Type 'all' to meet all the pets, or the room number of a specific pet to meet (type 'list' for everyone's rooms)");
                    userInput = input.nextLine();
                    if(userInput.equalsIgnoreCase("list")){
                        shelter.listAll();
                        System.out.println("Who would you like to meet? (type the room number)");
                        petRoom = input.nextInt();
                        input.nextLine();
                        if (petRoom > 0 && petRoom <= shelter.getPetShelter().size()) {
                            shelter.getPetShelter().get(petRoom - 1).meetPet();
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    else if(userInput.equalsIgnoreCase("all")){
                        shelter.meetAll();
                    }
                    else if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) <= shelter.getPetShelter().size()) {
                        shelter.getPetShelter().get(Integer.parseInt(userInput)-1).meetPet();
                    }
                    else {
                        shelter.wrongCommand();
                    }
                    shelter.tick();
                    break;
                case "play":
                    System.out.println("Type 'all' to play with all the pets, or the room number of a specific pet to play with (type 'list' for everyone's rooms)");
                    userInput = input.nextLine();
                    if(userInput.equalsIgnoreCase("list")){
                        shelter.listAll();
                        System.out.println("With whom would you like to play? (type the room number)");
                        petRoom = input.nextInt();
                        input.nextLine();
                        if (petRoom > 0 && petRoom <= shelter.getPetShelter().size()) {
                            shelter.getPetShelter().get(petRoom - 1).play();
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    else if(userInput.equalsIgnoreCase("all")){
                        shelter.playAll();
                    }
                    else if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) <= shelter.getPetShelter().size()) {
                        shelter.getPetShelter().get(Integer.parseInt(userInput)-1).play();
                    }
                    else {
                        shelter.wrongCommand();
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "feed":
                    System.out.println("Type 'all' to feed all the pets, or the room number of a specific pet to feed (type 'list' for everyone's rooms)");
                    userInput = input.nextLine();
                    if(userInput.equalsIgnoreCase("list")){
                        shelter.listAll();
                        System.out.println("Who would you like to feed? (type the room number)");
                        petRoom = input.nextInt();
                        input.nextLine();
                        if (petRoom > 0 && petRoom <= shelter.getPetShelter().size()) {
                            shelter.getPetShelter().get(petRoom - 1).feedPet();
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    else if(userInput.equalsIgnoreCase("all")){
                        shelter.feedAll();
                    }
                    else if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) <= shelter.getPetShelter().size()) {
                        shelter.getPetShelter().get(Integer.parseInt(userInput)-1).feedPet();
                    }
                    else {
                        shelter.wrongCommand();
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "nap":
                    System.out.println("Type 'all' to nap with all the pets, or the room number of a specific pet to let nap (type 'list' for everyone's rooms)");
                    userInput = input.nextLine();
                    if(userInput.equalsIgnoreCase("list")){
                        shelter.listAll();
                        System.out.println("With whom would you like to nap? (type the room number)");
                        petRoom = input.nextInt();
                        input.nextLine();
                        if (petRoom > 0 && petRoom <= shelter.getPetShelter().size()) {
                            shelter.getPetShelter().get(petRoom - 1).nap();
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    else if(userInput.equalsIgnoreCase("all")){
                        shelter.napAll();
                    }
                    else if (userInput.equalsIgnoreCase("quit")){
                        exitGame = true;
                        break;
                    }
                    else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) <= shelter.getPetShelter().size()) {
                        shelter.getPetShelter().get(Integer.parseInt(userInput)-1).nap();
                    }
                    else {
                        shelter.wrongCommand();
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                default:
                    shelter.wrongCommand();
                    break;
            }
            if (!exitGame){
                shelter.randomEvent();
            }
        }
        System.out.println("Thanks for stopping by Pounce's Play Palace & Pet Shelter, Cheers!");
    }

}
