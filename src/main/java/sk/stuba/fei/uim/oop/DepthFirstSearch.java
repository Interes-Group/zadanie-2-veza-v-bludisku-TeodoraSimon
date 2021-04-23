package sk.stuba.fei.uim.oop;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {

    private Paint paint;
    HashMap<String ,Tile> movesToDO;
    HashMap<String, Tile> movesDone;

    public DepthFirstSearch(Paint paint){
        this.paint = paint;
        movesToDO = new HashMap<String ,Tile>();
        movesDone = new HashMap<String ,Tile>();
    }

    public void doSearch(){

    }
}
