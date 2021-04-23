package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.Random;

public class Paint extends Canvas {

    private int row;
    private int col;
    private int border;
    private  int tileHeight, tileWidth;
    private int wallDensity;

    Tile[][] tiles;
    Random rand;

    public Paint(){

        this.row = 12;
        this.col = 12;
        this.border = 2;
        this.tileHeight = 40;
        this.tileWidth = 40;
        this.wallDensity = 10;
        tiles = new Tile[row][col];
        rand=new Random();
        generateMaze();

    }

    public void paint(Graphics g){
        //setBackground(Color.BLACK);
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                g.drawRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);
                g.setColor(Color.blue);
                g.fillRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);

                g.setColor(Color.blue);
            }
        }
        g.setColor(Color.blue);
        g.fillRect(15,1,38,38);
    }

    private void generateMaze(){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                tiles[i][j] = new Tile(j*tileWidth, i*tileHeight, tileWidth, tileHeight);
                int prom = 1;
                if((i+j)%wallDensity == 0){
                    prom = 2;
                }
                tileField(tiles[i][j] , prom);
            }
        }
    }

    private void tileField(Tile tiles, int density){

        for(int i=0;i<density;i++){
            while(true){
                int r = rand.nextInt()%4;

                if(checkBorder(tiles, r)){
                    tiles.addMove(r);
                    break;
                }
            }
        }
    }

    private boolean checkBorder(Tile tiles, int  numMove){

        switch(numMove){
            case 0:
                if(tiles.getY() == 0){
                    return false;
                }else{
                    return true;
                }
            case 1:
                if(tiles.getY() == (row - 1)*tileHeight){
                    return  false;
                }else {
                    return true;
                }
            case 2:
                if(tiles.getX() == (col - 1)*tileWidth){
                    return  false;
                }else {
                    return true;
                }
            case 3 :
                if(tiles.getX() == 0){
                    return  false;
                }else {
                    return true;
                }
        }
        return false;

    }
}
