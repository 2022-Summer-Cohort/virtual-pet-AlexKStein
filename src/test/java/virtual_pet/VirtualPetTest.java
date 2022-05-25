package virtual_pet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {
    @Test
    public void shouldMeetDogNamedFrodo() {
        //Assignment
        VirtualPet underTest = new VirtualPet ("Frodo", 100,  "dog", 0);
        //Action
        underTest.feedPet();
        //Assertion
        assertEquals(50, underTest.getHungerLevel());
    }
    @Test
    public void sleepinessShouldBe75() {
        //Assignment
        VirtualPet underTest = new VirtualPet("Frodo", 0,  "dog", 25);
        //Action
        underTest.play();
        //Assertion
        assertEquals(75, underTest.getSleepiness());
    }
    @Test
    public void sleepinessShouldBeReset() {
        //Assignment
        VirtualPet underTest = new VirtualPet("Frodo", 0, "dog", 85);
        //Action
        underTest.nap();
        //Assertion
        assertEquals(0, underTest.getSleepiness());
    }
    @Test
    public void hungerAndSleepinessShouldIncrease() {
        //Assignment
        VirtualPet underTest = new VirtualPet("", 1, "", 1);
        //Action
        underTest.tick();
        //Assertion
        assertTrue(underTest.getHungerLevel() >1);
        assertTrue(underTest.getSleepiness() >1);
    }
}
