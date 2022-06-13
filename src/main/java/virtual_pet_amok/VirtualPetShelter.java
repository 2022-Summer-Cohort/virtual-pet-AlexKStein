package virtual_pet_amok;

import java.util.ArrayList;

public class VirtualPetShelter {
    private ArrayList<VirtualPet> petShelter;

    public VirtualPetShelter() {
        this.petShelter = new ArrayList<>();
    }
    public ArrayList<VirtualPet> getPetShelter() {
        return petShelter;
    }

//Admit pets
    public void admitRD(RobotDog thisPet) {
        petShelter.add(thisPet);
    }
    public void admitOD(OrganicDog thisPet) {
        petShelter.add(thisPet);
    }
    public void admitRC(RobotCat thisPet) {
        petShelter.add(thisPet);
    }
    public void admitOC(OrganicCat thisPet) {
        petShelter.add(thisPet);
    }

    public void adoptPet(VirtualPet thisPet){
        petShelter.remove(thisPet);
    }
    public boolean isPetFound(String petName){
        for (VirtualPet thisPet: petShelter){
            if(petName.equalsIgnoreCase(thisPet.getTrueName())){
                return true;
            }
        }
        return false;
    }
    public VirtualPet petFinder(String petName){
        for(VirtualPet thisPet: petShelter){
            if(thisPet.getTrueName().equalsIgnoreCase(petName)){
                return thisPet;
            }
        }
        System.out.println("Pet not found.");;
        return null;
    }
    public void wrongCommand(){
        System.out.println("All you hear is howls, barking and hissing. Something you typed wasn't quite right...");
    }
    public void meetAll() {
        for (VirtualPet thisPet : petShelter) {
            System.out.print("[Room " + (petShelter.indexOf(thisPet) + 1) + "]~ ");
            thisPet.meet();
        }
    }
    public void statusAll() {
        for (VirtualPet thisPet : petShelter) {
            System.out.print("[Room " + (petShelter.indexOf(thisPet) + 1) + "]~ ");
            thisPet.status();
        }
    }
    public void feedAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.feed();
        }
    }
    public void chargeAll(){
        for(VirtualPet thisPet: petShelter){
            if (thisPet instanceof Robotic){
                ((Robotic) thisPet).charge();
            }
        }
    }
    public void maintainAll(){
        for(VirtualPet thisPet: petShelter){
            if (thisPet instanceof Robotic){
                ((Robotic) thisPet).maintain();
            }
        }
    }
    public void hydrateAll(){
        for (VirtualPet thisPet: petShelter){
            thisPet.hydrate();
        }
    }
    public void cleanAll(){
        for(VirtualPet thisPet: petShelter){
            if (thisPet instanceof Organic){
                ((Organic) thisPet).cleanRoom();
            }
        }
    }
    public void walkDogs(){
        for (VirtualPet thisPet: petShelter){
            if (thisPet instanceof Walking){
                ((Walking) thisPet).walk();
            }
        }
    }
    public void playAll(){
        for(VirtualPet thisPet: petShelter){
            thisPet.play();
        }
    }
    public void napTime(){
        for(VirtualPet thisPet: petShelter){
            if (thisPet instanceof Organic){
                ((Organic) thisPet).nap();
            }
        }
    }
    public void chargeAndNap(){
        for(VirtualPet thisPet: petShelter){
            if (thisPet instanceof Organic){
                ((Organic) thisPet).nap();
            }
            if (thisPet instanceof Robotic){
                ((Robotic) thisPet).charge();
            }
        }
    }
    public void tick(){
        for(VirtualPet thisPet: petShelter){
            thisPet.tick();
        }
    }
    public void randomEvent(){
        int chanceNum = (int) (Math.random()*25);
        switch (chanceNum) {
            case 0:     System.out.print("[Random Event]");
                System.out.println("Nap time?!? Organics are snoozing while the Robits plug in for their own nap.");
                chargeAndNap();
                break;
            case 1:     System.out.print("[Random Event]");
                System.out.println("CHAOS! All the animals are romping, but they're definitely not bored anymore");
                playAll();
                break;
            case 2:     System.out.print("[Random Event]");

                VirtualPet pet1 = petShelter.get((int)(Math.random()*petShelter.size()));
                VirtualPet pet2 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet1.play(); pet2.play();
                System.out.println(pet1.getName() + " and " + pet2.getName() + " are playing together c:");
                break;
            case 3:     System.out.print("[Random Event]");
                pet1 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet2 = petShelter.get((int)(Math.random()*petShelter.size()));
                VirtualPet pet3 = petShelter.get((int)(Math.random()*petShelter.size()));
                pet1.play(); pet2.play(); pet3.play();
                System.out.println(pet1.getName() + ", " + pet2.getName() + " and " + pet3.getName() + " are all playing together c:");
                break;
            default:
                break;
        }
    }
}
