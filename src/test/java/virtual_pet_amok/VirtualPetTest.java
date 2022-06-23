package virtual_pet_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VirtualPetTest {

    @Test //walk tests
    public void robotDogShouldBeLessBoredAndMoreThirsty(){
        RobotDog underTest = new RobotDog("Frodo", "Robot dog", "~Bark~", 30, 30, 30, false,  25, false, false);
        underTest.walk();
        assertTrue(underTest.getBoredom()<30);
        assertTrue(underTest.getThirst()>30);
    }
    @Test
    public void organicDogShouldHaveBathroomResetAndLessBored(){
        OrganicDog underTest = new OrganicDog("Korra", "Organic dog", "Arooo", 50, 50, 50, false,  50, true, 75, false);
        underTest.walk();
        assertTrue(underTest.getBoredom()<50);
        assertTrue(underTest.getBathroom()==0);
    }
    @Test
    public void robotCatShouldHaveThirstResetAndGainEnergy(){
        RobotCat underTest = new RobotCat("Bender", "robot cat", "meowZzZ", 0, 50, 75, false, 25, false, false);
        underTest.hydrate();
        assertTrue(underTest.getThirst() == 0);
        assertTrue(underTest.getEnergy()>50);
    }
    @Test
    public void robotShouldFullyChargeAndOrganicEnergyShouldStayTheSame(){
        OrganicCat samwise = new OrganicCat("Samewise", "organic cat", "meow", 0, 50, 0, false, 0, true, 0, false, 0);
        RobotCat gandalf = new RobotCat("Gandalf", "robot cat", "MeowZzza", 0, 50, 0, false,  0, false, false);
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.admitRC(gandalf);
        underTest.admitOC(samwise);
        underTest.chargeAll();
        assertEquals(50, samwise.getEnergy());
        assertEquals(100, gandalf.getEnergy());
    }
}
