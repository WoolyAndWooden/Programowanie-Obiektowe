package world;

import organisms.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class World {
    private int[] worldSize;
    private int currentTurn;
    private int maxTurn;
    private ArrayList<Organism> organisms;
    private ArrayList<Tile> tiles;
    public World(int worldX, int worldY, int maxTurn){
        this.setWorldSize(worldX, worldY);
        this.setCurrentTurn(0);
        this.setMaxTurn(maxTurn);
        this.organisms = new ArrayList<>();
        this.tiles = new ArrayList<>();

        for(int i = 0; i < worldX; i++){
            for(int j = 0; j < worldY; j++){
                this.addTile(new Tile(new int[]{i, j}, getAmountOfTiles()+1));
            }
        }
    }

    //setters
    public void setWorldSize(int x, int y){     this.worldSize = new int[] {x, y};}
    public void setCurrentTurn(int n){          this.currentTurn = n;}
    public void setMaxTurn(int n){              this.maxTurn = n;}
    public void addOrganism(Organism n){        this.organisms.add(n);}
    private void addTile(Tile n){               this.tiles.add(n);}

    //getters
    public int[] getWorldSize(){                return this.worldSize;}
    public int getCurrentTurn(){                return this.currentTurn;}
    public int getMaxTurn(){                    return this.maxTurn;}
    public Organism getNthOrganism(int n){      return organisms.get(n);}
    public int getAmountOfOrganisms(){          return organisms.size();}
    public Tile getTile(int n){                 return this.tiles.get(n);}
    public int getAmountOfTiles(){              return this.tiles.size();}

    //sorting
    private void sortByEmpty(boolean n){
        if(n)  this.tiles.sort(new SortTilesByEmpty());
        else    this.tiles.sort(Collections.reverseOrder(new SortTilesByEmpty()));
    }

    //Methods on Tiles
    public int getRandomEmptyTile(){
        this.sortByEmpty(true);
        Random rand = new Random();
        if(this.getTile(0).getOccupied()) return -1;
        if(this.getTile(this.getAmountOfTiles() - 1).getOccupied()) {
            int i;
            for(i = this.getAmountOfTiles() - 1; this.getTile(i).getOccupied(); i--);
            return rand.nextInt(i+1);
        }
        return rand.nextInt(this.getAmountOfTiles());
    }
    /*public int getRandomEmptySurroundingTile(int[] tileCoordinates, int range){

    }*/

    //How World shall work
    private void createLife(){
        for(int i = 0; i < (this.getWorldSize()[0] * this.getWorldSize()[1]) / 2; i++){
            //if(i % spawnAtStart == 0) this.addOrganism(new Grass());
        }
    }

}
