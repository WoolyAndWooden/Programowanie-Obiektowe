import org.junit.*;
import world.*;
import organisms.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void createTilesTestSizeMax() {
        World world = new World(5, 5, 100);
        assertEquals(25, world.getAmountOfTiles());
    }
    @Test
    public void createTilesTestSpecificTiles() {
        World world = new World(5, 5, 100);

    }

}
