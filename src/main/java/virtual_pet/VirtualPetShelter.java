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
    public void abandon(VirtualPet toAdd){
        petShelter.add(toAdd);
    }
    public void feedAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.feedPet();
        }
    }
    public void meetAll(){
        for(VirtualPet thisPet: petShelter){
            System.out.print("[Room " + (petShelter.indexOf(thisPet)+1) + "]~ ");
            thisPet.meetPet();
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
            System.out.print("[Room " + (petShelter.indexOf(thisPet)+1) + "]~ ");
            thisPet.statusUpdate();
        }
    }
    public void tick(){
        for (VirtualPet thisPet: petShelter) {
            thisPet.tick();
        }
    }
    public void listAll(){
        for(VirtualPet thisPet: petShelter) {
            System.out.println(thisPet.getName() + " is in [Room " + (petShelter.indexOf(thisPet) +1) + "]");
        }
    }

    public void adoptPet(int roomNum){
        petShelter.remove(roomNum);
    }
    public void wrongCommand(){
        System.out.println("All you hear is howls, barking and hissing. Something you typed wasn't quite right...");
    }
    public void randomEvent(){
        int chanceNum = (int) (Math.random()*11);
        System.out.print("[Random Event]");
        switch (chanceNum) {
            case 0:
                System.out.println("Nap time?!? Everyone takes a quick nap.");
                napAll();
                break;
            case 1:
                System.out.println("CHAOS! All the animals are romping, but they're definitely not bored anymore");
                playAll();
                break;
            case 2:
                VirtualPet pet1 = petShelter.get((int)(Math.random()*petShelter.size()));
                VirtualPet pet2 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet1.play(); pet2.play();
                System.out.println(pet1.getName() + " and " + pet2.getName() + " are playing together c:");
                break;
            case 3:
                pet1 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet2 = petShelter.get((int)(Math.random()*petShelter.size()));
                VirtualPet pet3 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet1.play(); pet2.play(); pet3.play();
                System.out.println(pet1.getName() + ", " + pet2.getName() + " and " + pet3.getName() + " are all playing together c:");
                break;
            default:
                System.out.println("Nothing happens.");
                break;
        }
    }
}
