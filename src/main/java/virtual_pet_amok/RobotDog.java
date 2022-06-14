package virtual_pet_amok;

public class RobotDog extends Robotic implements Walking{
    public RobotDog(String name, String type, String noise, int boredom,
                    int energy, int thirst, boolean tooTired, int maintenance, boolean needsMaintenance, boolean tooThirsty) {
        super(name, type, noise, boredom, energy, thirst, tooTired, maintenance, needsMaintenance, tooThirsty);
    }
    public void walk(){
        if (isNeedsMaintenance() || isTooThirsty() || isTooTired()){
            System.out.println(getName() + " is not listening, maybe they need something?");
        } else {
            System.out.println(getName() + " went on a walk and is much less bored now!");
            energy -= 15;
            thirst += 15;
            maintenance += 15;
            boredom -= 50;
        }
    }
    @Override
    public void play() {
        if (isNeedsMaintenance() || isTooThirsty() || isTooTired()){
            System.out.println(getName() + " is not listening, maybe they need something?");
        } else {
            boredom -= 50;
            maintenance += 25;
            thirst += 25;
        }
    }
    @Override
    public void help(){
        System.out.println("You can 'play', 'walk', 'hydrate', 'charge', 'maintain' your robot buddy, 'meet' and check the 'status' of your pet.");
    }

}
