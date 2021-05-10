package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DepthFirstSearch {

    private Tile tiles[][];
    Random rand;

    public DepthFirstSearch(Tile[][] tiles) {
        this.tiles = tiles;
        rand=new Random();
    }

    public void createMaze(){
        Tile t = tiles[0][0];
        DFS(t);
    }

    private void DFS(Tile t){
        t.setVisited(true);
        Tile nextTile = randomUnvisitedN(t);
        while( nextTile !=null){
            connectCells(t, nextTile);
            DFS(nextTile);
            nextTile = randomUnvisitedN(t);
        }


    }

    private void connectCells(Tile t, Tile nextTile) {
        boolean []stanja = t.getStanja();
        boolean []stanja_nt = nextTile.getStanja();
        if(t.getRow() > nextTile.getRow() && t.getColumn()==nextTile.getColumn()){
            stanja[0]=true;
            stanja_nt[1]=true;
        }else if(t.getColumn() < nextTile.getColumn() && t.getRow()==nextTile.getRow()){
            stanja[2]=true;
            stanja_nt[3]=true;
        }
        else if(t.getRow() < nextTile.getRow() && t.getColumn()==nextTile.getColumn()){
            stanja[1]=true;
            stanja_nt[0]=true;
        } else {
            stanja[3]=true;
            stanja_nt[2]=true;
        }
    }

    private Tile randomUnvisitedN(Tile t){

        int row = t.getRow();
        int col = t.getColumn();
        boolean neMoze[] = new boolean[4];


        if(row == 0 || tiles[row-1][col].isVisited()) {            //za gore
            neMoze[0] = true;
        }

        if(row == 11 || tiles[row+1][col].isVisited()) {            //za dole
            neMoze[1] = true;
        }

        if(col == 0|| tiles[row][col-1].isVisited()) {            //za levo
            neMoze[3] = true;
        }

        if(col == 11 || tiles[row][col+1].isVisited()) {            //za desno
            neMoze[2] = true;
        }

        if(neMoze[0] && neMoze[1] && neMoze[2] && neMoze[3]){
            return null;
        }

        while(true){
            int br = Math.abs(rand.nextInt());
            br = br%4;
            if(!neMoze[br]){
                switch(br){
                    case 0:
                        return tiles[row-1][col];
                    case 1:
                        return tiles[row+1][col];
                    case 2:
                        return tiles[row][col+1];
                    case 3:
                        return tiles[row][col-1];
                }
            }
        }
    }
}
