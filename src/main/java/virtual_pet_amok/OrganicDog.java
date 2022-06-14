package virtual_pet_amok;

public class OrganicDog extends Organic implements Walking{

    public OrganicDog(String name, String type, String noise, int boredom, int energy, int thirst, boolean tooTired, int hunger, boolean clean, int bathroom, boolean tooHungry) {
        super(name, type, noise, boredom, energy, thirst,tooTired, hunger, clean, bathroom, tooHungry);
    }
    public void walk(){
        if(isTooHungry() && getBathroom()<75){
            System.out.println(getName() + " isn't listening. Maybe they need something.");
        } else {
            System.out.println(getName() + " went on a walk, went potty and is less bored!");
            boredom -= 50;
            energy -= 20;
            thirst += 15;
            bathroom = 0;
        }
    }
    private String boredomStatus; private String energyStatus; private String thirstStatus; private String hungerStatus; private String bathroomStatus;


    @Override
    public void status(){
//boredom
        if (boredom <0){
        boredom = 0;
    }
        if (boredom >= 100){
        boredom = 100;
        System.out.println(getName() + " gets bored with you and wrestles with a toy.");
        play();
    }
        if( boredom >=75){
        boredomStatus = ":(";
    }
        if (boredom >=50 && boredom <75){
        boredomStatus = ":/";
    }
        if (boredom >=25 && boredom <50){
        boredomStatus = ":)";
    }
        if (boredom < 25){
        boredomStatus = "XD";
    }
//energy
        if (energy <0){
        energy = 0;
        nap();
    }
        if (energy >= 100){
        energy = 100;
        energyStatus = "XD";
    }
        if( energy >=75 && energy<100){
        energyStatus = ":D";
    }
        if (energy >=50 && energy <75){
        energyStatus = ":)";
    }
        if (energy >=25 && energy <50){
        energyStatus = ":/";
    }
        if (energy < 25){
        energyStatus = ":(";
    }
//thirst
        if (thirst <0){
        thirst = 0;
    }
        if (thirst >= 100){
        thirst = 100;
        hydrate();
    }
        if( thirst >=75 && thirst<100){
        thirstStatus = ":(";
    }
        if (thirst >=50 && thirst <75){
        thirstStatus = ":/";
    }
        if (thirst >=25 && thirst <50){
        thirstStatus = ":)";
    }
        if (thirst < 25){
        thirstStatus = "XD";
    }
//hunger
        if (hunger <0){
        hunger = 0;
    }
        if (hunger >= 100){
        hunger = 100;
        System.out.println(getName() + " is too hungry and not listening until they get feed.");
        hungerStatus = ">:(";
        tooHungry = true;
    }
        if( hunger >=75 && hunger<100){
        hungerStatus = ":(";
    }
        if (hunger >=50 && hunger <75){
        hungerStatus = ":/";
    }
        if (hunger >=25 && hunger <50){
        hungerStatus = ":)";
    }
        if (hunger < 25){
        hungerStatus = "XD";
    }
//bathroom
        if (bathroom <0){
        bathroom = 0;
    }
        if (bathroom >= 100){
            System.out.println("Oops! " + getName() + " couldn't wait any longer and had an accident. Please clean up their room.");
            clean = false;
            bathroom = 0;
    }
        if( bathroom >=75){
        bathroomStatus = ":(, probably time for a walk...";
    }
        if (bathroom >=50 && bathroom <75){
        bathroomStatus = ":/";
    }
        if (bathroom >=25 && bathroom <50){
        bathroomStatus = ":)";
    }
        if (bathroom < 25){
        bathroomStatus = "XD";
    }
//output
        System.out.println(getNoise() + " ~ " + getName() + ": Hunger = " + hungerStatus +", Thirst = " + thirstStatus + ", Energy = " + energyStatus +", Boredom = " + boredomStatus + ", Bathroom needs = " + bathroomStatus + ".");
}
    @Override
    public void feed(){
        if(!isClean() && !isTooHungry()){
            System.out.println(getName() + " isn't listening. Maybe they need something.");
        } else {
            System.out.println(getNoise() + "! " + getName() + " is no longer hunger and has more energy.");
            hunger -= 75;
            energy += 50;
            bathroom += 20;
        }
    }
    @Override
    public void play() {
        if(!isClean() || isTooHungry()){
            System.out.println(getName() + " isn't listening. Maybe they need something.");
        } else {
            boredom = 0;
            energy -= 25;
            thirst += 15;
            hunger += 10;
        }
    }
    @Override
    public void help(){
        System.out.println("You can 'play', 'walk', 'feed', 'nap', 'hydrate', 'clean' up after any accidents, 'meet' and check the 'status' of your pet.");
    }
}
