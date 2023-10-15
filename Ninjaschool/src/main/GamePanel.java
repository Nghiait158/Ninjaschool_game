package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.Keyboardinput;
import inputs.Mouseinput;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    private float xDelta=100, yDelta=100;
    private BufferedImage img;


    public GamePanel(){
       
        mouseinput= new Mouseinput(this);

        importImg();
        setPanelSize();
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }

    private void importImg() {
        InputStream is= getClass().getResourceAsStream("/adventurer_Sprite_Sheet.png");

        try {
            img= ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
    }

    private void setPanelSize(){
        Dimension size= new Dimension(1280,800); 
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    public void changeXDelta(int value){
        this.xDelta+=value;
        // repaint();
    }
    public void changeYDelta( int value){
        
        this.yDelta+=value;
        // repaint();
    }   

    public void setRectPos(int x, int y){
        this.xDelta= x;
        this.yDelta= y;
        // repaint();
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        // g.drawImage(img, 0, 0, null);
        
    }

} 

    
