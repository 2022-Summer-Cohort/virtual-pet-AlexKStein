package virtual_pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VirtualPetTest {
//VirtualPet Tests
    @Test
    public void hungerShouldDecreaseAndSleepinessIncrease() {
        VirtualPet underTest = new VirtualPet ("Frodo", 90,  "dog", 0,0, false );
        underTest.feedPet();
        assertTrue(underTest.getHunger()<90);
        assertTrue( underTest.getSleepiness()>0);
    }
    @Test
    public void sleepinessShouldBeHigherAndBoredomLower() {
        VirtualPet underTest = new VirtualPet("Frodo", 0,  "dog", 25, 50, false);
        underTest.play();
        assertTrue(underTest.getSleepiness() > 25);
        assertTrue(underTest.getBoredom() <50);
    }
    @Test
    public void sleepinessShouldBeZeroAndBoredomIncreases() {
        VirtualPet underTest = new VirtualPet("Frodo", 0, "dog", 85, 0, false);
        underTest.nap();
        assertEquals(0, underTest.getSleepiness());
        assertTrue(underTest.getBoredom()>0);
    }
    @Test
    public void hungerAndSleepinessShouldIncrease() {
        VirtualPet underTest = new VirtualPet("Frodo", 1, "dog", 1, 1, false);
        underTest.tick();
        assertTrue(underTest.getHunger() >1);
        assertTrue(underTest.getSleepiness() >1);
        assertTrue(underTest.getBoredom() >1);
    }
//Virtual Pet Shelter tests
    @Test
    public void petShouldBeAddedWhenAbandoned(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.abandon(new VirtualPet("Frodo", 1, "dog", 1, 0, false));
        assertEquals("Frodo U*ᴥ*U", underTest.getPetShelter().get(0).getName());
    }
    @Test
    public void petShouldBeRemovedAfterAdoptPet() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.abandon(new VirtualPet("Frodo", 1, "dog", 1, 0, false));
        underTest.abandon(new VirtualPet("adoptTest", 1, "dog", 1, 0, false));
        underTest.abandon(new VirtualPet("Korra", 1, "dog", 1, 0, false));
        underTest.adoptPet(2);
        assertTrue(underTest.getPetShelter().size() < 3);
    }
    @Test
    public void allPetsShouldHaveSleepSetToZero(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        underTest.abandon(new VirtualPet("Frodo", 1, "dog", 90, 0, false));
        underTest.abandon(new VirtualPet("Korra", 1, "dog", 75, 0, false));
        underTest.napAll();
        assertEquals(0, underTest.getPetShelter().get(0).getSleepiness());
        assertEquals(0, underTest.getPetShelter().get(1).getSleepiness());
    }
}
