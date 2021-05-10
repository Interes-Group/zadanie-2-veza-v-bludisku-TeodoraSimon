package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Printer extends JFrame {

    private JLabel cou;
    private int counter_i;

    public Printer(){

        super("Maze");
        setBounds(100,100,800,600);
        setResizable(false);
        setLayout(new BorderLayout());
        Figure f = new Figure();
        Paint p = new Paint(f,this);

        setFocusable(true);
        requestFocusInWindow();

        add(p, BorderLayout.CENTER);
        this.addKeyListener(new MyKeyListener(f,p));
        //MyMouseListener m = new MyMouseListener(f,p,this);
        //this.addMouseListener(m);
        //addMouseMotionListener(m);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());

        JButton left = new JButton("←");
        JButton right = new JButton("→");
        JButton up = new JButton("↑");
        JButton down = new JButton("↓");
        JButton reset = new JButton("Reset");

        left.addActionListener(new MyListener(NextMove.LEFT , f,p ,this));

        right.addActionListener(new MyListener(NextMove.RIGHT ,f,p,this ));
        up.addActionListener(new MyListener(NextMove.UP ,f,p,this));
        down.addActionListener(new MyListener(NextMove.DOWN, f,p,this));
        reset.addActionListener(new MyListener(NextMove.RESET , f,p, this));

        left.setPreferredSize(new Dimension(80, 50));
        buttons.add(left, BorderLayout.WEST);

        up.setPreferredSize(new Dimension(80, 50));
        buttons.add(up, BorderLayout.NORTH);

        down.setPreferredSize(new Dimension(80, 50));
        buttons.add(down, BorderLayout.CENTER);

        right.setPreferredSize(new Dimension(80, 50));
        buttons.add(right, BorderLayout.EAST);

        reset.setPreferredSize(new Dimension(80, 50));
        buttons.add(reset, BorderLayout.SOUTH);

        add(buttons, BorderLayout.WEST);

        JPanel stat = new JPanel();
        stat.setSize(new Dimension(100,100));
        stat.setLayout(new GridLayout(0,2));
        JLabel counter  = new JLabel("Counter");
        stat.add(counter);
        cou = new JLabel("0");
        counter_i=0;
        cou.setText(""+ counter_i);
        stat.add(cou);
        add(stat, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        f.setLabel(cou);

    }




}
