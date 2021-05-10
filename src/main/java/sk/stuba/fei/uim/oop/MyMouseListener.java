package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private Figure f;
    private  Paint p;
    private Printer pr;
    private int x_pressed;
    private int y_pressed;
    private boolean overFig;

    public MyMouseListener(Figure f, Paint p, Printer pr) {

        this.f = f;
        this.p = p;
        this.x_pressed = 0;
        this.y_pressed = 0;
        this.pr = pr;
        overFig = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int fRow = f.getRow();
        int fCol = f.getCol();
        x_pressed = e.getX();
        y_pressed = e.getY();

        //izvukli smo tile i izvkli smo x i y iz tog tile-a
        Tile t = p.getTiles()[fRow][fCol];

        int x_figure = t.getX();
        int y_figure = t.getY();

        //boolean was =false;

        //ako smo kliknuli
        if(x_figure < x_pressed && x_pressed < x_figure+f.getTileWidth()){
            if(y_figure < y_pressed && y_pressed < y_figure+f.getTileHeight()){
                highliteTiles(p.getTiles());
                p.repaint();
                //was = true;
            }

        }
       /* if(!was){
            if(t.isCan_move()){

            }
        }*/
        pr.setFocusable(true);
        pr.requestFocusInWindow();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pr.setFocusable(true);
        pr.requestFocusInWindow();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("usao");
        //pr.setFocusable(true);
        //pr.requestFocusInWindow();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //pr.setFocusable(true);
        //pr.requestFocusInWindow();
    }

    public void highliteTiles(Tile[][] t){

        int f_row= f.getRow();
        int f_col = f.getCol();
        boolean []stanja = t[f_row][f_col].getStanja();
        t[f_row][f_col].setCan_move(true);

        //for up
        while(stanja[0]){
            f_row--;
            t[f_row][f_col].setCan_move(true);
            stanja = t[f_row][f_col].getStanja();
        }

        f_row= f.getRow();
        f_col = f.getCol();
        stanja = t[f_row][f_col].getStanja();

        //for down
        while(stanja[1]){
            f_row++;
            t[f_row][f_col].setCan_move(true);
            stanja = t[f_row][f_col].getStanja();
        }

        f_row= f.getRow();
        f_col = f.getCol();
        stanja = t[f_row][f_col].getStanja();

        //for right
        while(stanja[2]){
            f_col++;
            t[f_row][f_col].setCan_move(true);
            stanja = t[f_row][f_col].getStanja();
        }

        f_row= f.getRow();
        f_col = f.getCol();
        stanja = t[f_row][f_col].getStanja();

        //for left
        while(stanja[3]){
            f_col--;
            t[f_row][f_col].setCan_move(true);
            stanja = t[f_row][f_col].getStanja();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        pr.setFocusable(true);
        pr.requestFocusInWindow();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int fRow = f.getRow();
        int fCol = f.getCol();
        x_pressed = e.getX();
        y_pressed = e.getY();


        Tile t = p.getTiles()[fRow][fCol];

        int x_figure = t.getX();
        int y_figure = t.getY();

        //ako smo kliknuli
        if(x_figure < x_pressed && x_pressed < x_figure+f.getTileWidth()){
            if(y_figure < y_pressed && y_pressed < y_figure+f.getTileHeight()){
                overFig = true;
                p.setAllowedToHigh(true);
                //p.repaint();

            }else{
                if(overFig){
                    if(!t.isCan_move()) {
                        overFig = false;
                        //p.setAllowedToHigh(false);
                        //p.repaint();
                    }
                }
            }
        }else{
            if(overFig){
                if(!t.isCan_move()) {
                    overFig = false;
                    //p.setAllowedToHigh(false);
                    //p.repaint();
                }
            }
        }



        pr.setFocusable(true);
        pr.requestFocusInWindow();


    }
}

