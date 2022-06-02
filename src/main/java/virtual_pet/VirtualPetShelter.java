package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelter {
    Scanner input = new Scanner(System.in);
    private ArrayList<VirtualPet> petShelter;

    public VirtualPetShelter() {
        this.petShelter = new ArrayList<>();
    }
    public ArrayList<VirtualPet> getPetShelter() {
        return petShelter;
    }


    //methods
    public void admit(VirtualPet toAdd){
        petShelter.add(toAdd);
    }
    public void feedAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.feedPet();
        }
    }
    public void playAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.play();
        }
    }
    public void napAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.nap();
        }
    }
    public void statusAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.statusUpdate();
        }
    }
    public void tick(){
        for (VirtualPet thisPet: petShelter) {
            thisPet.tick();
        }
    }
    public void listALl(){
        for(VirtualPet thisPet: petShelter) {
            System.out.println(thisPet.getName() + " is in room " + petShelter.indexOf(thisPet));
        }
    }

    public void adoptPet(int roomNum){
        petShelter.remove(roomNum);

//        System.out.println("Who would you like to adopt? Type 'shelter list' to see who's available!");
//        String adoption = input.nextLine().toLowerCase();
//
//        for (VirtualPet thisPet: petShelter) {
//            if (thisPet.getName().equals(adoption)) {
//                System.out.println("Thank you for your adoption! " + adoption + " is going to love their new fur-ever home.");
//            }
//        }
//        if (adoption.equalsIgnoreCase("shelter list")) {
//            listALl();
//            adoptPet();
//        }
//        else {
//            System.out.println("There is no pet with that name available.");
//        }
    }



}
