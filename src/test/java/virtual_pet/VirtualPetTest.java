package virtual_pet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {
    @Test
    public void hungerShouldDecreaseBy50andSleepinessIncreaseBy25() {
        //Assignment
        VirtualPet underTest = new VirtualPet ("Frodo", 100,  "dog", 0,0);
        //Action
        underTest.feedPet();
        //Assertion
        assertEquals(25, underTest.getHungerLevel());
        assertEquals(25, underTest.getSleepiness());
    }
    @Test
    public void sleepinessShouldBe75() {
        //Assignment
        VirtualPet underTest = new VirtualPet("Frodo", 0,  "dog", 25, 50);
        //Action
        underTest.play();
        //Assertion
        assertEquals(70, underTest.getSleepiness());
        assertEquals(15, underTest.getBoredom());
    }
    @Test
    public void sleepinessShouldBeResetAndBoredomUpTen() {
        //Assignment
        VirtualPet underTest = new VirtualPet("Frodo", 0, "dog", 85, 0);
        //Action
        underTest.nap();
        //Assertion
        assertEquals(0, underTest.getSleepiness());
        assertTrue(underTest.getBoredom()>1);
    }
    @Test
    public void hungerAndSleepinessShouldIncrease() {
        //Assignment
        VirtualPet underTest = new VirtualPet("Frodo", 1, "dog", 1, 0);
        //Action
        underTest.tick();
        //Assertion
        assertTrue(underTest.getHungerLevel() >1);
        assertTrue(underTest.getSleepiness() >1);
        assertTrue(underTest.getBoredom() >1);
    }
}
