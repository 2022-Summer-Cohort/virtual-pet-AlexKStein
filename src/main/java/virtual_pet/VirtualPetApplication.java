package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitGame = false;

        System.out.println("Welcome to your virtual pet! Please enter your pet's name:");
        String petName = input.nextLine();
        System.out.println("Is your pet a dog or a cat?");
        String type = input.nextLine();
        VirtualPet pet1 = new VirtualPet(petName, 20, type, 0, 0, false);
        pet1.meetPet();

        while (!exitGame) {
            System.out.println("What would you like to do with " + pet1.getName() + "? you can 'play', 'feed', 'nap' and 'wait'. Type 'status' to check on your pet, or 'quit' to quit.");
            String command = input.nextLine();
            if (command.equalsIgnoreCase("quit")){
                exitGame = true;
            }
            if (command.equalsIgnoreCase("feed")) {
                pet1.feedPet();
                pet1.tick();
                pet1.statusUpdate();
            }
            else if(command.equalsIgnoreCase("status")){
                pet1.statusUpdate();
            }
            else if (pet1.isRioting()){
                System.out.println(pet1.getName() + " is not cooperating. Maybe they're hungry?");
            }
            else if (command.equalsIgnoreCase("play")) {
                pet1.play();
                pet1.tick();
                pet1.statusUpdate();
            }
            else if (command.equalsIgnoreCase("nap")){
                pet1.nap();
                pet1.tick();
                pet1.statusUpdate();
            }
            else if(command.equalsIgnoreCase("wait")){
                pet1.tick();
                pet1.statusUpdate();
            }
            else{
                System.out.println(pet1.getName() + " cocks their head, command not recognized.");
            }
        }
        System.out.println("Goodbye!");
    }

}
