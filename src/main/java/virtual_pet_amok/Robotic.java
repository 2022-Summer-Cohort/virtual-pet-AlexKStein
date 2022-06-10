package virtual_pet_amok;

public abstract class Robotic extends VirtualPet{
    protected int maintenance;
    public Robotic(String name, String type, String noise, int boredom, int energy, int thirst, boolean riot, int maintenance) {
        super(name, type, noise, boredom, energy, thirst, riot);
        this.maintenance = maintenance;
    }
    public int getMaintenance() {
        return maintenance;
    }
    //emoji modifiers for status
    private String boredomStatus; private String energyStatus; private String thirstStatus; private String maintenanceStatus;

    public void charge(){
        System.out.println(getName() + " is fully charged! " + getNoise());
        energy = 100;
        maintenance+=15;
    }
    @Override
    public void hydrate(){
        System.out.println("I'm " + getName() + ", baby! Please insert liquor...");
        double roll = Math.random()*11;
        if (roll <=3){
            System.out.print("Yum! Tequila. ");
        }
        if (roll >3 && roll<=7){
            System.out.print("Thanks for the beers! ");
        }
        if (roll >7){
            System.out.print("Mmm, fine fine wine. ");
        }
        System.out.println(getName() + "'s liquor needs have been met and they have more energy now, too!");
        energy +=50;
        thirst =0;
        maintenance +=15;
    }

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
            System.out.println(getName() + " is out of energy! Please give them a 'charge' or some 'liquor'.");
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
//maintenance
        if (maintenance <0){
            maintenance = 0;
        }
        if (maintenance >= 100){
            maintenance = 100;
            maintenanceStatus = maintenance + " >:(";
        }
        if( maintenance >=75 && maintenance<100){
            maintenanceStatus = maintenance + " :(";
        }
        if (maintenance >=50 && maintenance <75){
            maintenanceStatus = maintenance + " :/";
        }
        if (maintenance >=25 && maintenance <50){
            maintenanceStatus = maintenance + " :)";
        }
        if (maintenance < 25){
            maintenanceStatus = maintenance + " XD";
        }
//output
        System.out.println(getNoise() + " ~ " + getName() + ": Energy = " + energyStatus +", Thirst = " + thirstStatus + ", Boredom = " + boredomStatus + ", Maintenance needs = " + maintenanceStatus + ".");
    }

    @Override
    public void tick() {
        boredom +=10;
        energy -=10;
        thirst +=10;
        maintenance +=10;
    }
    @Override
    public void feed(){ }

    public void maintain() {
        System.out.println("Now that you've fixed up " + getName() + ", don't forget to check their energy levels!");
        energy -= 50;
        boredom += 15;
        thirst +=25;
    }
}