package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Paint extends Canvas {

    private int row = 12;
    private int col = 12;

    public void paint(Graphics g){
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                g.drawRect(i*50+1, j*50+1, 48,48);
                g.setColor(Color.blue);
                g.fillRect(i*50+1,j*50+1, 48,48);
                g.setColor(Color.blue);
            }
        }
        g.setColor(Color.blue);
        g.fillRect(25,1,48,48);
    }
}
