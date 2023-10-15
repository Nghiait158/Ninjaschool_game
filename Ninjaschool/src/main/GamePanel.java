package main;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.time.Year;

import javax.swing.JPanel;

import inputs.Keyboardinput;
import inputs.Mouseinput;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    private int xDelta=0, yDelta=0;
    public GamePanel(){

        mouseinput= new Mouseinput();
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }
    public void changeXDelta(int value){
        this.xDelta=value;
        repaint();
    }
    public void changeYDelta( int value){
        
        this.yDelta=value;
        repaint();
    }   

    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.fillRect(100 + xDelta, 100 +yDelta, 50, 50);
    }
}
