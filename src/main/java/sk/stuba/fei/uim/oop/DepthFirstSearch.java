package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class DepthFirstSearch {

    private Paint paint;
    HashMap<String ,Tile> movesToDO;
    HashMap<String, Tile> movesDone;

    ArrayList<Tile> list;

    public DepthFirstSearch(Paint paint){
        this.paint = paint;
        movesToDO = new HashMap<String ,Tile>();
        movesDone = new HashMap<String ,Tile>();
        list = new ArrayList<Tile>();
        Tile [][]tilovi = paint.getTile();
        doSearch(tilovi[0][0]);
    }

    public void doSearch(Tile T){
        T.setVisited(true);
        Tile nextTile = randomUnvisited(T);
        while(nextTile != null){
            T.connect( nextTile);

            doSearch(nextTile);
            nextTile = randomUnvisited(T);
        }

    }
    private Tile randomUnvisited(Tile T){
        ArrayList<Tile> tiles = T.getNextTiles();
        if(tiles.isEmpty()){
            return null;
        }

        Tile removed;
        removed = tiles.remove(tiles.size() - 1);

        if(removed.getVisited()){
            return paint.getNeig(T);
        }

        return removed;
    }
}
