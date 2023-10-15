package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.time.Year;
import java.util.Random;

import javax.swing.JPanel;

import inputs.Keyboardinput;
import inputs.Mouseinput;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    private float xDelta=100, yDelta=100;
    private float xDir=0.05f, yDir=0.05f;
    private int frames=0;
    private long lastCheck; 
    private Color color = new Color(150,20,90);
    private Random random;

    public GamePanel(){
        random = new Random();
        mouseinput= new Mouseinput(this);
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }
    public void changeXDelta(int value){
        this.xDelta+=value;
        // repaint();
    }
    public void changeYDelta( int value){
        
        this.yDelta+=value;
        // repaint();
    }   

    public void serRectPos(int x, int y){
        this.xDelta= x;
        this.yDelta= y;
        // repaint();
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta,(int)yDelta, 50, 50);

        frames++;
        if(System.currentTimeMillis() -lastCheck >=1000){
            lastCheck= System.currentTimeMillis();
            System.out.println("Fps: "+ frames);
            frames=0;
        }
        repaint();
    }

    private void updateRectangle(){
        xDelta+=xDir;
        if(xDelta >400 || xDelta <0){
            xDir*=-1;
            color =getRndColor();
        }


        yDelta+=yDir;
        if(yDelta >400 ||  yDelta <0){
            yDir*=-1;
            color =getRndColor();
        }
    }

    private Color getRndColor(){

        int r=random.nextInt(255);
        int g=random.nextInt(255);
        int b=random.nextInt(255);

        return new Color(r, g, b);
    }
}
