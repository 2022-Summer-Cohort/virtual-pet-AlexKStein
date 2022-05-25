package virtual_pet;

public class VirtualPet {
    private String name;
    private int hungerLevel;
    private int boredom;
    private String petType;
    private int sleepiness;
    private boolean rioting;


    public String getName() { return name; }
    public int getHungerLevel() { return hungerLevel; }
    public String getPetType() { return petType; }
    public int getSleepiness() { return sleepiness;}

    public int getBoredom() {
        return boredom;
    }
    public boolean isRioting() { return rioting;}

    public VirtualPet(String name, int hungerLevel, String petType, int sleepiness, int boredom, boolean rioting){
        if(petType.equalsIgnoreCase("dog")) {
            name = name + " U*ᴥ*U";
        }
        if(petType.equalsIgnoreCase("cat")){
            name= name + " =^.ᴥ.^=";
        }
        this.name= name;
        this.hungerLevel = hungerLevel;
        this.petType = petType;
        this.sleepiness = sleepiness;
        this.boredom = boredom;
        this.rioting = rioting;

    }
    public void feedPet(){
        if(hungerLevel<=25 && petType.equalsIgnoreCase("cat")){
            System.out.println(name + " is not hungry enough to eat right now.");
        }
        else {
            hungerLevel -= 75;
            sleepiness += 25;
            rioting = false;
        }
    }
    public void meetPet(){
        System.out.println("Hello, I am a very cute " + petType + " named " + name +"!");
    }
    public void play(){
        sleepiness += 45;
        hungerLevel += 25;
        boredom -= 35;
        if (petType.equalsIgnoreCase("dog")){
            System.out.println(name + "'s tail is wagging, they are less bored but getting tired.");
        }
        if (petType.equalsIgnoreCase("cat")){
            System.out.println(name + " purrs, they are less bored but getting tired. ");
        }
    }
    public void nap(){
        sleepiness = 0;
        boredom += 10;
        System.out.println(name + " yawns after a nice nap and is no longer tired!");
    }
    public void tick(){
        hungerLevel+=5;
        sleepiness += 5;
        boredom += 5;
    }
    public void statusUpdate(){
        if (sleepiness >= 100){
            System.out.println(name + " is too tired and goes to take a nap.");
            nap();
        }
        if (sleepiness <0){
            sleepiness = 0;
        }
        if (hungerLevel >= 100){
            hungerLevel = 100;
            rioting = true;
            if (petType.equalsIgnoreCase("cat")) {
                System.out.println(name + " walks over to their food bowl and meows.");
            }
            if (petType.equalsIgnoreCase("dog")) {
                System.out.println(name + " barks and sits down by their food bowl");
            }
        }
        if (hungerLevel <0){
            hungerLevel = 0;
        }
        if (boredom >= 100){
            boredom = 100;
            if (!rioting){
                System.out.println(name + " is bored with you and goes to play with a toy.");
                play();
            }
        }
        if (boredom <0){
            boredom = 0;
        }
        System.out.println(name + ": hunger = " + hungerLevel +"/100, sleepiness = " + sleepiness + "/100, and boredom = " + boredom + "/100.");
    }
}
