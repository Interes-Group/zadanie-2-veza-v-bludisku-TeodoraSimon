package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Tile {
    private boolean visited;
    private int x;
    private int y;
    private int width;
    private int height;
    private  int row;
    private int column;
    private boolean stanja[];
    private boolean can_move;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean[] getStanja() {
        return stanja;
    }

    public void setStanja(boolean stanja[]) {
        this.stanja = stanja;
    }

    public Tile(int x, int y , int row , int col){
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = col;
        width = 40;
        height = 40;
        visited = false;
        this.stanja= new boolean[4];
        this.can_move = false;
    }

    public Tile(int x, int y , int width , int height , int row , int col){
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = col;
        this.width = width;
        this.height = height;
        visited = false;
        this.stanja= new boolean[4];
        this.can_move = false;
    }

    public boolean isCan_move() {
        return can_move;
    }

    public void setCan_move(boolean can_move) {
        this.can_move = can_move;
    }
}
