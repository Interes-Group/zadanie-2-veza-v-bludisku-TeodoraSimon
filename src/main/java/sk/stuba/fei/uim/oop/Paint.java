package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Paint extends Canvas {

    private int row;
    private int col;
    private int border;
    private  int tileHeight, tileWidth;
    private int wallDensity;


    private Tile firstTile;
    private Tile secondsTIle;

    Graphics gsa;

    private Tile[][] tiles;
    Random rand;

    public Paint(){

        this.row = 12;
        this.col = 12;
        this.border = 2;
        this.tileHeight = 40;
        this.tileWidth = 40;
        this.wallDensity = 7;
        tiles = new Tile[row][col];
        rand=new Random();
        generateMaze();

    }

    public void paint(Graphics g){
        gsa = g;
        //setBackground(Color.BLACK);
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(tiles[i][j].getVisited()){
                    g.setColor(Color.green);
                }

                g.fillRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);
                g.drawRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);
                g.setColor(Color.blue);
            }
        }
        g.setColor(Color.blue);

    }

    private void generateMaze(){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                tiles[i][j] = new Tile(j*tileWidth, i*tileHeight, tileWidth, tileHeight);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int prom = 1;
                if((i+j)%wallDensity == 0){
                    prom = 2;
                }
                tileField(tiles[i][j] , prom , i,j);
            }
        }


    }


    private void tileField(Tile tiles1, int density,int i1 , int j){

        for(int i=0;i<density;i++){
            while(true){
                int r = Math.abs(rand.nextInt())%4;
                //System.out.println(r);
                if(checkBorder(tiles1, r , i1,j)){
                   // tiles.addMove(r);

                    break;
                }
            }
        }
    }

    private boolean checkBorder(Tile tiles1, int  numMove , int i , int j){

        switch(numMove){
            case 0:
                if(tiles1.getY() == 0){
                    return false;
                }else{
                    tiles1.addMove(numMove);
                    tiles1.addMove(tiles[i-1][j]);
                    //System.out.println("AA");
                    return true;
                }
            case 1:
                if(tiles1.getY() == (row - 1)*tileHeight){
                    return  false;
                }else {
                    tiles1.addMove(numMove);
                    tiles1.addMove(tiles[i+1][j]);
                    return true;
                }
            case 2:
                if(tiles1.getX() == (col - 1)*tileWidth){
                    return  false;
                }else {
                    tiles1.addMove(numMove);
                    tiles1.addMove(tiles[i][j+1]);
                    return true;
                }
            case 3 :
                if(tiles1.getX() == 0){
                    return  false;
                }else {
                    tiles1.addMove(numMove);
                    tiles1.addMove(tiles[i][j-1]);
                    return true;
                }
            default:
                System.out.println("Error ");
        }
        return false;

    }


    public void update(Graphics g) {
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int br = tiles[i][j].getBinding();
                if(br == 0){
                    continue;
                }
                if((br & 0b1000) != 0){
                    g.fillRect(i*40+border - 20, j*40+border, tileWidth-2*border,tileHeight-2*border);
                }
                if((br & 0b0100) != 0){
                    g.fillRect(i*40+border + 20, j*40+border, tileWidth-2*border,tileHeight-2*border);
                }
                if((br & 0b0010) != 0){
                    g.fillRect(i*40+border , j*40+border + 20, tileWidth-2*border,tileHeight-2*border);
                }
                if((br & 0b0001) != 0){
                    g.fillRect(i*40+border, j*40+border - 20, tileWidth-2*border,tileHeight-2*border);
                }


                g.fillRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);
                g.drawRect(i*40+border, j*40+border, tileWidth-2*border,tileHeight-2*border);
                g.setColor(Color.blue);

            }
        }
    }

    Tile[][] getTile(){
        return  tiles;
    }

    Tile getNeig(Tile t){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               if(tiles[i][j] == t){
                   if(i!=0){
                       if(!tiles[i-1][j].getVisited()){
                           return tiles[i-1][j];
                       }
                   }
                   if (i != row-1){
                       if(!tiles[i+1][j].getVisited()){
                           return tiles[i+1][j];
                       }
                   }
                   if(j != 0){
                       if(!tiles[i][j-1].getVisited()){
                           return tiles[i][j-1];
                       }
                   }
                   if(j != col-1){
                       if(!tiles[i][j+1].getVisited()){
                           return tiles[i][j+1];
                       }
                   }




               }
            }
        }
        return null;
    }
}
