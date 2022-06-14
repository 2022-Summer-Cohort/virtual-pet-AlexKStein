package virtual_pet_amok;

public abstract class Organic extends VirtualPet {
    protected int hunger;
    protected boolean clean;
    protected int bathroom;
    protected boolean tooHungry;

    public Organic(String name, String type, String noise, int boredom, int energy, int thirst, boolean tooTired, int hunger, boolean clean, int bathroom, boolean tooHungry) {
        super(name, type, noise, boredom, energy, thirst, tooTired);
        this.hunger = hunger;
        this.clean = clean;
        this.bathroom = bathroom;
        this.tooHungry = tooHungry;
    }
    //getters
    public int getHunger() {
        return hunger;
    }
    public boolean isClean() {
        return clean;
    }
    public int getBathroom() {
        return bathroom;
    }
    public boolean isTooHungry() { return tooHungry; }


    @Override
    public void hydrate(){
        System.out.println(getName() + " drinks some water and is less thirsty.");
        thirst -= 50;
        bathroom += 15;
        energy += 10;
    }
    public void nap(){
        if (isTooHungry() || !isClean()){
            System.out.println(getName() + " is not listening, maybe they need something?");
        } else {
            System.out.println(getName() + "(Zzz...) After a nice nap and a biiiig stretch, they're no longer tired and is full of energy again!");
            energy = 100;
            bathroom += 25;
        }
    }
    public void cleanRoom(){
        System.out.println(getName() + "'s room is now clean.");
        clean = true;
    }
    @Override
    public void charge(){
        System.out.println("OOPS. That doesn't plug into an organic pet, maybe try a nap instead...");
    }
    @Override
    public void maintain(){
        System.out.println("Maintenance is for robot pets only.");
    }
    @Override
    public void tick() {
        hunger +=10;
        energy -=10;
        bathroom +=10;
        thirst +=10;
    }
}
