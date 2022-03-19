package world;

import java.util.Comparator;
public class SortTilesByEmpty implements Comparator<Tile>{
    @Override
    public int compare(Tile o1, Tile o2){
        return new Boolean(o1.getOccupied()).compareTo(new Boolean(o2.getOccupied()));
    }

}
