package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Figure extends Canvas {

    private int x;
    private int y;
    private  int dimension;
    private int row;
    private int col;
    private int tileWidth;
    private  int tileHeight;
    private int finish_row;
    private int finish_col;
    private int counter;
    private JLabel lab;

    public Figure(){
        x=0;
        y=0;
        dimension = 20;
        tileWidth=40;
        tileHeight=40;
        x = tileWidth/2-dimension/2;
        y = tileHeight/2-dimension/2;
        row = 0;
        col = 0;
        finish_row=11;
        finish_col=11;
        counter=0;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void right( Paint p){
        Tile [][]t = p.getTiles();
        boolean []stanja = t[row][col].getStanja();
        if(stanja[2]){

            x += 40;
            col++;
        }
        if(row==finish_row && col == finish_col){
            endOfGame(p);
        }

    }

    public void left( Paint p){
        Tile [][]t = p.getTiles();
        boolean []stanja = t[row][col].getStanja();
        if(stanja[3]) {

            x -= 40;
            col--;
        }
        if(row==finish_row && col == finish_col){
            endOfGame(p);
        }
    }

    public void up( Paint p){
        Tile [][]t = p.getTiles();
        boolean []stanja = t[row][col].getStanja();
        if(stanja[0]) {

            y -= 40;
            row--;
        }
        if(row==finish_row && col == finish_col){
            endOfGame(p);
        }
    }

    public void down( Paint p){
        Tile [][]t = p.getTiles();
        boolean []stanja = t[row][col].getStanja();
        if(stanja[1]) {

            y += 40;
            row++;
        }
        if(row==finish_row && col == finish_col){
            endOfGame(p);
        }
    }

    public void reset(Paint p){

        p.generateMaze();
        x = tileWidth/2-dimension/2;
        y = tileHeight/2-dimension/2;
        row = 0;
        col = 0;
        counter = 0;
        lab.setText("" + counter);
        p.repaint();

    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,dimension ,dimension);

    }

    public void paintEnd(Graphics g){
        g.setColor(Color.red);
        g.fillRect(450,450,dimension ,dimension);

    }

    private void endOfGame( Paint p){

        p.generateMaze();
        x = tileWidth/2-dimension/2;
        y = tileHeight/2-dimension/2;
        row = 0;
        col = 0;
        counter++;
        lab.setText("" + counter);
        p.repaint();

    }

    public void setLabel(JLabel lab){
        this.lab = lab;
    }

}
