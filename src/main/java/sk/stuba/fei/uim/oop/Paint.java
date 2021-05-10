package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Paint extends Canvas {


    private int row;
    private int col;
    private int tileHeight;
    private int tileWidth;
    private Tile[][] tiles;
    private boolean isAllowedToHigh;
    private  Printer pr;
    Figure f ;

    public Paint(Figure f, Printer pr){

        this.row = 12;
        this.col = 12;
        tileHeight = 40;
        tileWidth = 40;

        tiles = new Tile[row][col];
        this.pr = pr;
        generateMaze();
        isAllowedToHigh = false;
        this.f = f;
        MyMouseListener m = new MyMouseListener(f,this,pr);
        addMouseListener(m);
        addMouseMotionListener(m);

    }
    public Paint(int row , int col , int tileWidth , int tileHeight){

        this.row = row;
        this.col = col;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        tiles = new Tile[row][col];

        generateMaze();

    }

    public void paint(Graphics g){

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){

                paintTile(tiles[i][j] , g);
            }
        }
        f.paint(g);

    }

    public void paintHorizontal(int x , int y, Graphics g){
        g.drawRect(x, y, 1 , tileHeight);
    }
    public void paintVertical(int x , int y ,Graphics g){
        g.drawRect(x,y,tileWidth , 1);
    }
    public void paintTile(Tile T , Graphics g){

        boolean []stanja = T.getStanja();
        int x = T.getX();
        int y = T.getY();

        //ako je false ne moze da prodje i onda crtamo zid
        if(!stanja[0]){
            //paintVertical(T.getX() , T.getY() ,g);
            g.drawRect(x,y,tileWidth , 1);
        }
        if(!stanja[1]){
            // paintVertical(T.getX(),T.getY()+40 ,g);
            g.drawRect(x,y+40,tileWidth , 1);
        }
        if(!stanja[2]){
            // paintHorizontal(T.getX()+40 , T.getY() ,g);
            g.drawRect(x+40, y, 1 , tileHeight);
        }
        if(!stanja[3]){
            // paintHorizontal(T.getX() , T.getY() ,g);
            g.drawRect(x, y, 1 , tileHeight);
        }
        if(isAllowedToHigh){
            if(T.isCan_move()){
                g.setColor(Color.MAGENTA);
                g.fillRect(x +2, y +2,tileHeight -4, tileWidth-4);
                g.setColor(Color.BLACK);

            }
        }

    }

    public boolean getAllowedToHigh() {
        return isAllowedToHigh;
    }

    public void setAllowedToHigh(boolean allowedToHigh) {
        isAllowedToHigh = allowedToHigh;
    }

    public void generateMaze(){

        for(int rows=0;rows<row;rows++){
            for(int cols=0;cols<col;cols++){
                tiles[rows][cols] = new Tile(cols*tileWidth, rows*tileHeight, tileWidth, tileHeight , rows , cols);
            }
        }
        DepthFirstSearch searchProm = new DepthFirstSearch(tiles);
        searchProm.createMaze();


    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}
