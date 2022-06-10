package virtual_pet_amok;

public class RobotCat extends Robotic{
    public RobotCat(String name, String type, String noise, int boredom, int energy, int thirst, boolean riot, int maintenance) {
        super(name, type, noise, boredom, energy, thirst, riot, maintenance);
    }

    @Override
    public void play(){
        System.out.println(getName() + " happily plays with you :3");
        boredom -= 50;
        energy -= 15;
        thirst += 15;
    }

}
