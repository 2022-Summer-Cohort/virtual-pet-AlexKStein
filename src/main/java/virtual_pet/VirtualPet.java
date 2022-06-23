package virtual_pet;

public class VirtualPet {
    private String name;
    private int hunger;
    private int boredom;
    private String petType;
    private int sleepiness;
    private boolean rioting;

    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public String getPetType() { return petType; }
    public int getSleepiness() { return sleepiness;}

    public int getBoredom() {
        return boredom;
    }
    public boolean isRioting() { return rioting;}

    public VirtualPet(String name, int hunger, String petType, int sleepiness, int boredom, boolean rioting){
        if(petType.equalsIgnoreCase("dog")) {
            name = name + " U*ᴥ*U";
        }
        if(petType.equalsIgnoreCase("cat")){
            name= name + " =^.ᴥ.^=";
        }
        this.name= name;
        this.hunger = hunger;
        this.petType = petType;
        this.sleepiness = sleepiness;
        this.boredom = boredom;
        this.rioting = rioting;

    }
    public void feedPet(){
        if(hunger<=25 && petType.equalsIgnoreCase("cat")){
            System.out.println(name + " is not hungry enough to eat right now.");
        }
        else {
            hunger -= 85;
            sleepiness += 15;
            rioting = false;
        }
    }
    public void meetPet(){
        System.out.println("Hello, I am a very cute " + getPetType() + " named " + getName() +"!");
    }
    public void play(){
        sleepiness += 25;
        hunger += 15;
        boredom -= 50;
    }
    public void nap(){
        sleepiness = 0;
        boredom += 15;
    }
    public void tick(){
        hunger+=10;
        sleepiness += 10;
        boredom += 10;
    }
    public void statusUpdate(){
        String sleepStatus = "";
        String hungerStatus = "";
        String boredomStatus = "";
//Sleepiness
        if (sleepiness >= 100){
            System.out.println(name + " is too tired and goes to take a nap.");
            nap();
        }
        if (sleepiness <0) {
            sleepiness = 0;
        }
        if (sleepiness < 100 && sleepiness > 75){
            sleepStatus = sleepiness +" >:(";
        }
        if (sleepiness <= 75 && sleepiness > 50){
            sleepStatus = sleepiness +" :/";
        }
        if (sleepiness <= 50 && sleepiness > 25){
            sleepStatus = sleepiness + " :)";
        }
        if (sleepiness <= 25){
            sleepStatus = sleepiness +" XD";
        }
//Hunger
        if (hunger <0){
            hunger = 0;
        }
        if (hunger >= 100){
            hunger = 100;
            rioting = true;
            if (petType.equalsIgnoreCase("cat")) {
                System.out.println(name + " walks over to their food bowl and meows.");
            }
            if (petType.equalsIgnoreCase("dog")) {
                System.out.println(name + " barks and sits down by their food bowl");
            }
            hungerStatus = hunger + " >:(";
        }

        if( hunger >=75 && hunger<100){
            hungerStatus = hunger + " >:(";
        }
        if (sleepiness <= 75 && sleepiness > 50) {
            sleepStatus = sleepiness + " :/";
        }
        if (sleepiness <= 50 && sleepiness > 25) {
            sleepStatus = sleepiness + " :)";
        }
        if (hunger <=25){
            hungerStatus = hunger + " XD";
        }
//Boredom
        if (boredom >= 100){
            boredom = 100;
            if (!rioting){
                System.out.println(name + " is bored with you and goes to play with a toy.");
                play();
            }
        }
        if( boredom >=50 && boredom<100){
            boredomStatus = boredom + " :|";
        }
        if (boredom <0){
            boredom = 0;
        }
        if (boredom <50){
            boredomStatus = boredom + " :D";
        }
        System.out.println(name + ": hunger = " + hungerStatus +", sleepiness = " + sleepStatus + ", and boredom = " + boredomStatus + ".");
    }
}
