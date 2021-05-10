package sk.stuba.fei.uim.oop;
import java.awt.event.*;

public class MyListener implements ActionListener {

    private NextMove nextmove;
    private Figure f;
    private Paint p;
    private Tile[][] tiles;
    private Printer pr;

    public MyListener(NextMove next , Figure f, Paint p,Printer pr) {
        nextmove = next;
        this.f = f;
        this.p = p;
        tiles = new Tile[f.getRow()][f.getCol()];
        this.pr = pr;
    }

    public void actionPerformed(ActionEvent ev) {
        switch(nextmove) {
            case UP:
                f.up(p);
                p.repaint();
                break;
            case DOWN:
                f.down(p);
                p.repaint();
                break;
            case LEFT:
                f.left(p);
                p.repaint();
                break;
            case RIGHT:
                f.right(p);
                p.repaint();
                break;
            case RESET:
                f.reset(p);
                p.repaint();

        }
        pr.setFocusable(true);
        pr.requestFocusInWindow();
    }


}