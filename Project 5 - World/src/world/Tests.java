package world;

import org.junit.*;
import organisms.*;


import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void createTilesTestSizeMax() {
        World world = new World(5, 5, 100);
        assertEquals(25, world.getAmountOfTiles());
    }
    @Test
    public void createTilesOfUniquePositionTest(){
        ArrayList<Tile> sut = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                sut.add(new Tile(new int[] {i, j}, 0));
            }
        }
        int x = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                assertArrayEquals(new int[] {i, j}, sut.get(x).getPosition());
                x++;
            }
        }
    }
    @Test
    public void createTilesTestSpecificTiles() {
        World world = new World(5, 5, 100);
        assertArrayEquals(new int[]{2, 3}, world.getTile(13).getPosition());
    }
    @Test
    public void randomEmptyTileTestAllEmpty(){
        World world = new World(3, 3, 100);
        for(int i = 0; i < 36; i++) assertEquals(false, world.getTile(world.getRandomEmptyTile()).getOccupied());
    }
    @Test
    public void randomEmptyTileTestSomeEmpty(){
        World world = new World(3, 3, 100);
        world.getTile(2).setOccupied(true);
        world.getTile(4).setOccupied(true);
        world.getTile(8).setOccupied(true);
        for(int i = 0; i < 36; i++) assertEquals(false, world.getTile(world.getRandomEmptyTile()).getOccupied());
    }
    @Test
    public void randomEmptyTileNoneEmpty(){
        World world = new World(2, 2, 100);
        world.getTile(0).setOccupied(true);
        world.getTile(1).setOccupied(true);
        world.getTile(2).setOccupied(true);
        world.getTile(3).setOccupied(true);
        assertEquals(-1, world.getRandomEmptyTile());
    }


    //Sorting stuff
    @Test
    public void sortTilesByEmptyTest(){
        ArrayList<Tile> sut = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            sut.add(new Tile(new int[] {0, 0}, i));
        }
        sut.get(2).setOccupied(true);
        sut.get(4).setOccupied(true);
        sut.get(8).setOccupied(true);
        sut.sort(new SortTilesByEmpty());

        for(int i = 9; i > 6; i--){
            assertEquals(true, sut.get(i).getOccupied());
        }
    }
    @Test
    public void sortTilesByEmptyReverseOrderTest(){
        ArrayList<Tile> sut = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            sut.add(new Tile(new int[] {0, 0}, i));
        }
        sut.get(2).setOccupied(true);
        sut.get(4).setOccupied(true);
        sut.get(8).setOccupied(true);
        sut.sort(Collections.reverseOrder(new SortTilesByEmpty()));

        for(int i = 0; i < 3; i++){
            assertEquals(true, sut.get(i).getOccupied());
        }
    }
}
