package virtual_pet;

public class VirtualPet {
    private String name;
    private int hungerLevel;
    private int age;
    private String petType;
    private int sleepiness;
    private int time;

    public String getName() { return name; }
    public int getHungerLevel() { return hungerLevel; }
//    public int getAge() { return age;}
    public String getPetType() { return petType; }
    public int getSleepiness() { return sleepiness;}

    public VirtualPet(String name, int hungerLevel, String petType, int sleepiness){
        this.name = name;
        this.hungerLevel = hungerLevel;
//        this.age = age;
        this.petType = petType;
        this.sleepiness = sleepiness;
    }
    public void feedPet(){
        hungerLevel = hungerLevel - 50;
        sleepiness = sleepiness + 25;
    }
    public void meetPet(){
        System.out.println("Hello, I am a very cute " + petType + " named " + name +"!");
    }
    public void play(){
        sleepiness = sleepiness + 50;
        hungerLevel = hungerLevel +15;
        if (petType.equalsIgnoreCase("dog")){
            System.out.println(name + "'s tail is wagging.");
        }
        if (petType.equalsIgnoreCase("cat")){
            System.out.println(name + " meows.");
        }
    }
    public void nap(){
        sleepiness = 0;
        System.out.println(name + " yawns after a nice nap and is no longer tired!");
    }
    public void tick(){
        hungerLevel= hungerLevel+5;
        sleepiness = sleepiness +5;
    }
    public void statusUpdate(){
        if (sleepiness > 100){
            sleepiness = 100;
        }
        if (sleepiness <0){
            sleepiness = 0;
        }
        if (hungerLevel > 100){
            hungerLevel = 100;
        }
        if (hungerLevel <0){
            hungerLevel = 0;
        }
        System.out.println(name + "'s hunger is now " + hungerLevel +"/100 and sleepiness is " + sleepiness + "/100");
    }
}
