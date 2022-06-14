package virtual_pet_amok;

public abstract class Robotic extends VirtualPet{
    protected int maintenance;
    protected boolean needsMaintenance;
    protected boolean tooThirsty;

    public Robotic(String name, String type, String noise, int boredom, int energy, int thirst, boolean tooTired, int maintenance, boolean tooThirsty, boolean needsMaintenance) {
        super(name, type, noise, boredom, energy, thirst, tooTired);
        this.maintenance = maintenance;
        this.needsMaintenance = needsMaintenance;
        this.tooThirsty = tooThirsty;
    }

    public int getMaintenance() {
        return maintenance;
    }
    public boolean isNeedsMaintenance() {
        return needsMaintenance;
    }
    public boolean isTooThirsty() {
        return tooThirsty;
    }

    private String boredomStatus; private String energyStatus; private String thirstStatus; private String maintenanceStatus;

    @Override
    public void charge(){
        if ((isNeedsMaintenance() || isTooThirsty()) && !isTooTired()){
            System.out.println(getName() + " is not listening, maybe they need something");
        } else {
            System.out.println(getName() + " is fully charged! " + getNoise());
            energy = 100;
            maintenance += 15;
            tooTired = false;
        }
    }
    @Override
    public void hydrate(){
        if (isNeedsMaintenance() && !isTooThirsty()){
            System.out.println(getName() + " is not listening, maybe they're broken...?");
        } else {
            System.out.print("I'm " + getName() + ", baby! Please insert liquor...");
            double roll = Math.random() * 11;
            if (roll <= 3) {
                System.out.println("\"Yum! Tequila.\" ");
            }
            if (roll > 3 && roll <= 7) {
                System.out.println("\"Thanks for the beers!\" ");
            }
            if (roll > 7) {
                System.out.println("\"Mmm, fine fine wine.\" ");
            }
            System.out.println(getName() + "'s liquor needs have been met and they have more energy now, too!");
            energy += 50;
            thirst = 0;
            maintenance += 15;
            tooThirsty = false;
        }
    }

    @Override
    public void status(){
//boredom
        if (boredom <0){
            boredom = 0;
        }
        if (boredom >= 100){
            boredom = 100;
            if (isTooThirsty() || isNeedsMaintenance() || isTooTired()){
                boredomStatus = ">:(";
            } else {
                System.out.println(getName() + " trots off to play with their favorite toy.");
                play();
            }
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
            energyStatus = ">:(";
            System.out.println(getName() + " is out of energy! Please give them a 'charge' or some 'liquor'.");
            tooTired = true;
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
            System.out.println(getName() + " is in desperate need of liquor.");
            tooThirsty = true;
            thirstStatus = ">:(";
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
//maintenance
        if (maintenance <0){
            maintenance = 0;
        }
        if (maintenance >= 100){
            maintenance = 100;
            maintenanceStatus = ">:(";
            System.out.println(getName() + " isn't looking too good...");
            needsMaintenance = true;
        }
        if( maintenance >=75 && maintenance<100){
            maintenanceStatus = ":(";
        }
        if (maintenance >=50 && maintenance <75){
            maintenanceStatus = ":/";
        }
        if (maintenance >=25 && maintenance <50){
            maintenanceStatus = ":)";
        }
        if (maintenance < 25){
            maintenanceStatus = "XD";
        }
//output
        System.out.println(getNoise() + " ~ " + getName() + ": Energy = " + energyStatus +", Thirst = " + thirstStatus + ", Boredom = " + boredomStatus + ", Maintenance needs = " + maintenanceStatus + ".");
    }
    @Override
    public void cleanRoom(){
        System.out.println("Robots don't produce waste and therefore don't need their rooms' cleaned. How neat is that?!");
    }
    @Override
    public void tick() {
        boredom +=10;
        energy -=10;
        thirst +=10;
        maintenance +=10;
    }
    @Override
    public void feed(){
        System.out.println("You tried giving food to a robot, which is complete nonsense.");
    }
    @Override
    public void nap(){
        System.out.println("Robots don't nap, but they might need to charge...");
    }
    @Override
    public void maintain() {
        if ((isTooTired() || isTooThirsty()) && !isNeedsMaintenance()){
            System.out.println(getName() + " seems to be working fine, maybe they need something else.");
        } else {
            System.out.println("Now that you've fixed up " + getName() + ", don't forget to check their energy levels!");
            energy -= 50;
            boredom += 15;
            thirst += 25;
            maintenance=0;
            needsMaintenance = false;
        }
    }
}
