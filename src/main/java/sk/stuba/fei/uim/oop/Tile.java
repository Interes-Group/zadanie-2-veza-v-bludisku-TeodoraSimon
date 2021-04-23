package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Tile {

    private boolean visited;
    private int x;
    private int y;
    private int width;
    private int height;
    private ArrayList<NextMove> moves;
    private ArrayList<Tile> nextiles;
    private int binding;


    public Tile(int x, int y, int width, int height){

        visited = false;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        moves = new ArrayList<NextMove>();
        nextiles = new ArrayList<Tile>();
        binding = 0;

    }
    public int getBinding(){
        return binding;
    }
    public ArrayList<Tile> getNextTiles(){
        return nextiles;
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

    }
    public void addMove(Tile T){
        nextiles.add(T);
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean getVisited(){
        return this.visited;
    }


    void connect(Tile t){
        int x1 = this.getX() , y1 = this.getY();

        int x2 = t.getX() , y2 = t.getY();

        if(x1 == x2){
            if(y1 < y2){
                binding = binding | 2;
            }else{
                binding = binding | 1;
            }
        }

        if(y1 == y2){
            if(x1 < x2){
                binding = binding | 4;
            }else{
                binding = binding | 8;
            }
        }
    }


}
