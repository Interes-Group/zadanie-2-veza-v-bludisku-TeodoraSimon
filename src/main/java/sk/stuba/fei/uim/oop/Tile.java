package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Tile {

    private boolean visited;
    private int x;
    private int y;
    private int width;
    private int height;
    ArrayList<NextMove> moves;

    public Tile(int x, int y, int width, int height){

        visited = false;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        moves = new ArrayList<NextMove>();

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

    public void addMove(NextMove move){
        moves.add(move);
    }
    public void addMove(int move){
        moves.add(NextMove.values()[move]);
        //moves.add(move);
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


}
