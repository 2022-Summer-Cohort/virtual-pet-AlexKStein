package virtual_pet_amok;

public class OrganicCat extends Organic{
    private int litter = 0;
    public OrganicCat(String name, String type, String noise, int boredom, int energy, int thirst, boolean riot, int hunger, boolean clean, int bathroom, int litter) {
        super(name, type, noise, boredom, energy, thirst,riot, hunger, clean, bathroom);
        this.litter = litter;
    }

    public int getLitter(){ return litter; }
    public void litterBox(){
        litter++;
        if (litter >=4){
            clean = false;
        }
    }
    @Override
    public void cleanRoom(){
        litter = 0;
        clean = true;
    }
    @Override
    public void feed(){
        if (getHunger()<25){
            System.out.println(getName() + " is not hungry enough to eat.");
        }
        else {
            System.out.println(getNoise() + "! " + getName() + " is no longer hunger and has more energy.");
            hunger -= 75;
            energy += 50;
            bathroom += 20;
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
            boredomStatus = boredom + " >:(";
        }
        if( boredom >=75 && boredom<100){
            boredomStatus = boredom + " :(";
        }
        if (boredom >=50 && boredom <75){
            boredomStatus = boredom + " :/";
        }
        if (boredom >=25 && boredom <50){
            boredomStatus = boredom + " :)";
        }
        if (boredom < 25){
            boredomStatus = boredom + " XD";
        }
//energy
        if (energy <0){
            energy = 0;
            energyStatus = energy + " >:(";
        }
        if (energy >= 100){
            energy = 100;
            energyStatus = energy + " XD";
        }
        if( energy >=75 && energy<100){
            energyStatus = energy + " :D";
        }
        if (energy >=50 && energy <75){
            energyStatus = energy + " :)";
        }
        if (energy >=25 && energy <50){
            energyStatus = energy + " :/";
        }
        if (energy < 25){
            energyStatus = energy + " :(";
        }
//thirst
        if (thirst <0){
            thirst = 0;
        }
        if (thirst >= 100){
            thirst = 100;
            thirstStatus = thirst + " >:(";
        }
        if( thirst >=75 && thirst<100){
            thirstStatus = thirst + " :(";
        }
        if (thirst >=50 && thirst <75){
            thirstStatus = thirst + " :/";
        }
        if (thirst >=25 && thirst <50){
            thirstStatus = thirst + " :)";
        }
        if (thirst < 25){
            thirstStatus = thirst + " XD";
        }
//hunger
        if (hunger <0){
            hunger = 0;
        }
        if (hunger >= 100){
            hunger = 100;
            hungerStatus = hunger + " >:(";
        }
        if( hunger >=75 && hunger<100){
            hungerStatus = hunger + " :(";
        }
        if (hunger >=50 && hunger <75){
            hungerStatus = hunger + " :/";
        }
        if (hunger >=25 && hunger <50){
            hungerStatus = hunger + " :)";
        }
        if (hunger < 25){
            hungerStatus = hunger + " XD";
        }
//bathroom
        if (bathroom <0){
            bathroom = 0;
        }
        if (bathroom >= 100){
            if (clean) {
                litterBox();
                bathroom = 0;
            }
            else{
                bathroomStatus = ">:(";
                System.out.println(getName() + "'s litter bot is full, please clean it or they may not listen to you.");
            }
        }
        if( bathroom >=75){
            bathroomStatus = " :(";
        }
        if (bathroom >=50 && bathroom <75){
            bathroomStatus = ":/";
        }
        if (bathroom >=25 && bathroom <50){
            bathroomStatus = bathroom + ":)";
        }
        if (bathroom < 25){
            bathroomStatus = bathroom + "XD";
        }
//output
        System.out.println(getNoise() + " ~ " + getName() + ": Hunger = " + hungerStatus +", Thirst = " + thirstStatus + ", Energy = " + energyStatus +", Boredom = " + boredomStatus + ", Bathroom needs = " + bathroomStatus + ", litter box = " + getLitter() + "/4.");
    }
    @Override
    public void play() {
        System.out.println("*" + getNoise() + "* " + getName() + " happily plays with you :3");
        boredom -= 50;
        energy -= 25;
        thirst += 15;
    }
}