package virtual_pet;

public class VirtualPet {
    private String name;
    private int hungerLevel;
    private int boredom;
    private String petType;
    private int sleepiness;
//    private boolean rioting;


    public String getName() { return name; }
    public int getHungerLevel() { return hungerLevel; }
    public String getPetType() { return petType; }
    public int getSleepiness() { return sleepiness;}

    public int getBoredom() {
        return boredom;
    }
//    public boolean isRioting() { return rioting};

    public VirtualPet(String name, int hungerLevel, String petType, int sleepiness, int boredom){
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.petType = petType;
        this.sleepiness = sleepiness;
        this.boredom = boredom;
//        this.rioting = rioting;
    }
    public void feedPet(){
        hungerLevel = hungerLevel - 75;
        sleepiness = sleepiness + 25;
    }
    public void meetPet(){
        System.out.println("Hello, I am a very cute " + petType + " named " + name +"!");
    }
    public void play(){
        sleepiness = sleepiness + 45;
        hungerLevel = hungerLevel +15;
        boredom = boredom - 35;
        if (petType.equalsIgnoreCase("dog")){
            System.out.println(name + "'s tail is wagging, they are less bored but getting sleepy.");
        }
        if (petType.equalsIgnoreCase("cat")){
            System.out.println(name + " purrs, they are less bored but getting sleepy. ");
        }
    }
    public void nap(){
        sleepiness = 0;
        boredom = boredom + 10;
        System.out.println(name + " yawns after a nice nap and is no longer tired!");
    }
    public void tick(){
        hungerLevel= hungerLevel+5;
        sleepiness = sleepiness +5;
        boredom = boredom+5;
    }
    public void statusUpdate(){
        if (sleepiness >= 100){
            System.out.println(name + " is too tired and goes to take a nap.");
            nap();
        }
        if (sleepiness <0){
            sleepiness = 0;
        }
        if (hungerLevel > 100){
            hungerLevel = 100;
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
        if (boredom > 100){
            boredom = 100;
            if (hungerLevel <100){
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
