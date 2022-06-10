package virtual_pet_amok;

public class RobotDog extends Robotic implements Walking{
    public RobotDog(String name, String type, String noise, int boredom,
                    int energy, int thirst, boolean riot, int maintenance) {
        super(name, type, noise, boredom, energy, thirst, riot, maintenance);
    }
    public void walk(){
        System.out.println(getName() + " went on a walk and is much less bored now!");
        energy -= 15;
        thirst += 15;
        maintenance += 15;
        boredom -= 50;
    }
    @Override
    public void play() {
        System.out.println(getName() + " lil' tail is wagging & is so excited to play with you! " +getNoise());
        boredom -=50;
        maintenance +=25;
        thirst += 25;

    }

}
