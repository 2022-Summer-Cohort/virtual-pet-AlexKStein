package virtual_pet_amok;

public class OrganicCat extends Organic{
    private int litter = 0;
    public OrganicCat(String name, String type, String noise, int boredom, int energy, int thirst, boolean tooTired, int hunger, boolean clean, int bathroom, boolean tooHungry, int litter) {
        super(name, type, noise, boredom, energy, thirst, tooTired, hunger, clean, bathroom, tooHungry);
        this.litter = litter;
    }

    public int getLitter(){ return litter; }
    public void litterBox(){
        litter++;
        if (litter >=3){
            clean = false;
        }
    }
    @Override
    public void cleanRoom(){
        System.out.println("Thanks for cleaning out " + getName() +"'s litter box.");
        litter = 0;
        clean = true;
    }
    @Override
    public void feed(){
        if (!isClean() && !isTooHungry()){
            System.out.println(getName() + " doesn't seem to be hungry, but still needs something.");
        }else {
            if (getHunger() < 25) {
                System.out.println(getName() + " is not hungry enough to eat.");
            } else {
                System.out.println(getNoise() + "! " + getName() + " is no longer hunger and has more energy.");
                hunger -= 75;
                energy += 50;
                bathroom += 20;
                tooHungry = false;
            }
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
            if (isTooHungry() || !isClean()){
                boredomStatus = ">:(";
            } else {
                System.out.println(getName() + " chases a beam of light or ghosts or something, and is less bored.");
                play();
            }
        }
        if( boredom >=75 && boredom<100){
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
            if (!isClean() || isTooHungry()){
                energyStatus = ">:(";
            } else {
                System.out.println("This kitty is too tired: " + getName() + " lies down for a quick nappy.");
                nap();
            }
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
            hungerStatus = ">:(";
            System.out.println(getName() + " won't cooperate until they get some food!");
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
        if(!clean){
            bathroomStatus = "X( needs cleaning...";
        } else {
            if (bathroom < 0) {
                bathroom = 0;
            }
            if (bathroom >= 100) {
                if (clean) {
                    litterBox();
                    bathroom = 0;
                } else {
                    bathroomStatus = ">:(";
                    System.out.println(getName() + "'s litter bot is full, please clean it or they may not listen to you.");
                }
            }
            if (bathroom >= 75) {
                bathroomStatus = ":(";
            }
            if (bathroom >= 50 && bathroom < 75) {
                bathroomStatus = ":/";
            }
            if (bathroom >= 25 && bathroom < 50) {
                bathroomStatus = ":)";
            }
            if (bathroom < 25) {
                bathroomStatus = "XD";
            }
        }
//output
        System.out.println(getNoise() + " ~ " + getName() + ": Hunger = " + hungerStatus +", Thirst = " + thirstStatus + ", Energy = " + energyStatus +", Boredom = " + boredomStatus + ", Bathroom needs = " + bathroomStatus + ", litter box = " + getLitter() + "/4.");
    }
    @Override
    public void play() {
        if(!isClean() || isTooHungry()){
            System.out.println(getName() + " isn't listening, maybe they need something?");
        } else {
            boredom -= 50;
            energy -= 25;
            thirst += 15;
            System.out.println(getName() + " had a great time playing and is less bored now.");
        }
    }
    @Override
    public void help(){
        System.out.println("You can 'play', 'feed', 'nap', 'hydrate', 'clean' their litter box, 'meet' and check the 'status' of your pet.");
    }
}
