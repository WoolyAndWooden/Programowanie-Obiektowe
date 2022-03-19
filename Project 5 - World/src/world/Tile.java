package world;

import organisms.Organism;

class Tile {
    private boolean occupied;
    private Organism organism;
    private int position[];
    private int tileNo;

    public Tile(int[] position, int tileNo){
        this.setOccupied(false);
        this.setOrganism(null);
        this.setPosition(position);
        this.setTileNo(tileNo);
    }

    public void AddOrganism(Organism organism){
        this.setOrganism(organism);
        this.setOccupied(true);
    }

    public void RemoveOrganism(){
        this.setOrganism(null);
        this.setOccupied(false);
    }
    //public int[] getRandom

    //setters
    void setOccupied(boolean n){    this.occupied = n;}
    void setOrganism(Organism n){   this.organism = n;}
    private void setPosition(int[] n){ this.position = n;}
    private void setTileNo(int n){          this.tileNo = n;}

    //getters
    boolean getOccupied(){          return this.occupied;}
    Organism getOrganism(){         return this.organism;}
    int[] getPosition(){            return this.position;}
    int getTileNo(){                return this.tileNo;}

}
