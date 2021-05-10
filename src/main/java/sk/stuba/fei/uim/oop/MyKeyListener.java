package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    private Figure f;
    private  Paint p;

    public MyKeyListener(Figure f, Paint p) {
        this.f = f;
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            f.right(p);
            p.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            f.up(p);
            p.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            f.left(p);
            p.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            f.down(p);
            p.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

