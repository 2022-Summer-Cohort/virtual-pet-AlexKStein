package virtual_pet_amok;

public class RobotCat extends Robotic{
    public RobotCat(String name, String type, String noise, int boredom, int energy, int thirst,
                    boolean tooTired, int maintenance, boolean needsMaintenance, boolean tooThirsty) {
        super(name, type, noise, boredom, energy, thirst, tooTired, maintenance, needsMaintenance, tooThirsty);
    }

    @Override
    public void play(){
        if (isNeedsMaintenance() || isTooThirsty() || isTooTired()){
            System.out.println(getName() + " is not listening, maybe they need something?");
        } else {
            boredom -= 50;
            energy -= 15;
            thirst += 15;
        }
    }
    @Override
    public void help(){
        System.out.println("You can 'play', 'hydrate', 'charge', 'maintain' your robot buddy, 'meet' and check the 'status' of your pet.");
    }
}
