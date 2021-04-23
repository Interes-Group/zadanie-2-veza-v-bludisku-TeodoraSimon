package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class Printer extends JFrame {

    public Printer(){
        super("Maze");
        setBounds(100,100,1000,800);
        add(new Paint());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
