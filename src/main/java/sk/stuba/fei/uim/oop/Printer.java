package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Printer extends JFrame {

    public Printer(){
        super("Maze");
        setBounds(100,100,1000,800);
        setResizable(false);
        setLayout(new BorderLayout());

        add(new Paint(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }




}
