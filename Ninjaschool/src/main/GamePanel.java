package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
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
    private BufferedImage[][] animation;
    private int aniTick, aniIndex, aniSpeed= 15;


    public GamePanel(){
       
        mouseinput= new Mouseinput(this);

        importImg();
        loadAnimation();
        setPanelSize();
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }

    private void loadAnimation() {
        animation = new BufferedImage[10][10];

        for ( int j=0; j<animation.length; j++)
            for( int i=0; i<animation.length; i++){
                animation[j][i]= img.getSubimage(i*23,j*36 , 23, 36);
            }
    }

    private void importImg() {
        // InputStream is= getClass().getResourceAsStream("Ninjaschool/res/adventurer_Sprite_Sheet.png");
        // InputStream is= getClass().
        try {
            // img= ImageIO.read(is);
            img= ImageIO.read(new FileInputStream("Ninjaschool/res/adventurer_Sprite_Sheet.png"));
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


       updateAnimation();
        
        g.drawImage(animation[3][0],(int) xDelta, (int) yDelta, 46, 72, null);


    }

    private void updateAnimation() {
        // aniTick++;
        // if( aniTick >= aniSpeed){
        //     aniTick=0;
        //     aniIndex++;
        //     if(aniIndex>=animation.length){
        //         aniIndex=0;
        //     }
        // }


    }

} 

    
