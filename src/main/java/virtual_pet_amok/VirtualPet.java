package virtual_pet_amok;

public abstract class VirtualPet {
    private String name;
    private String type;
    private String noise;
    protected int boredom;
    protected int energy; //this will be used for robot charge and organic sleepiness.
    protected int thirst; //liquor replaces oil. see game for details
    protected boolean riot; //true will make pet unresponsive until an issue is fixed.
    private String trueName;

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getNoise() {
        return noise;
    }
    public int getBoredom() {
        return boredom;
    }
    public int getEnergy() {
        return energy;
    }
    public int getThirst() {
        return thirst;
    }
    public boolean isRiot() { return riot;}
    public String getTrueName(){ return trueName; }


    public VirtualPet(String name, String type, String noise, int boredom, int energy, int thirst, boolean riot) {
        this.trueName = name;
        if (type.equalsIgnoreCase("robot dog")){
            this.name = name + " ~U*ᴥ*U~";
        }
        if(type.equalsIgnoreCase("organic dog")) {
            this.name = name + " U◕ᴥ◕U";
        }
        if(type.equalsIgnoreCase("organic cat")){
            this.name = name + " =^•ᴥ•^=";
        }
        if(type.equalsIgnoreCase("robot cat")){
            this.name = name + " ~^*ᴥ*^~";
        }
        this.type = type;
        this.noise = noise;
        this.boredom = boredom;
        this.energy = energy;
        this.thirst = thirst;
        this.riot = riot;
    }
    public void wrongCommand(){
        System.out.println(getNoise() + "!! " + getName() + " is trying to tell you that you typed something wrong...");
    }
    public void meet(){
        System.out.println("Hello! I'm " + getName() + " the " + getType() + ". " + getNoise() + " " + getNoise() + ".");
    }
    public abstract void tick();
    public abstract void play();
    public abstract void status();
    public abstract void feed();
    public abstract void hydrate();
    public abstract void help();
}
