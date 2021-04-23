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
    }

    public void doSearch(Tile T){
        T.setVisited(true);
        Tile nextTile = randomUnvisited();
        while(nextTile != null){
            // spoji Tileove(Tile,nextTile)
            doSearch(nextTile);
            nextTile = randomUnvisited();
        }

    }
    private Tile randomUnvisited(){
        return list.remove(list.size() - 1);

    }
    private void getValidNextMove(Tile tile){


    }
}
