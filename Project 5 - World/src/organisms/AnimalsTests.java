package organisms;

import org.junit.*;
import static org.junit.Assert.*;

public class AnimalsTests {
    @Test
    public void organismEatingConsequencesTest(){
        Wolf wolf = new Wolf(0, 0);
        Sheep sheep = new Sheep(1, 0);
        wolf.setPower(10);
        wolf.setSign('W');
        wolf.eat(sheep);
        assertEquals(false, sheep.getAlive());


    }
}
