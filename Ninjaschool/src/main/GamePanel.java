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
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    private float xDelta=100, yDelta=100;
    private BufferedImage img;
    private BufferedImage[][] animation;
    private int aniTick, aniIndex, aniSpeed= 15;
    private int PlayerAction = RUNNING;
    private int playerDirection = -1;
    private boolean moving = false;

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
        animation = new BufferedImage[13][13];

        for ( int j=0; j<animation.length; j++)
            for( int i=0; i<animation.length; i++){
                animation[j][i]= img.getSubimage(i*64,j*64 , 64, 64);
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

    public void setDirection(int direction){
        this.playerDirection=direction;
        moving = true;

    }

    public void setMoving( boolean moving){
        this.moving=moving;
    } 
    private void setAnimation() {
        if (moving ){
            PlayerAction =RUNNING;
        }
        else PlayerAction =IDLE;
    }
    public void updateGame() {
        updateAnimation();
        
        setAnimation();
        updatePos();
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        g.drawImage(animation[PlayerAction][aniIndex],(int) xDelta, (int) yDelta, 64*2, 64*2, null);


    }

   

    private void updatePos() {
        if( moving) {
            switch (playerDirection) {
                case LEFT:
                    xDelta-=5;
                    break;
                case RIGHT:
                    xDelta+=5;
                    break;
                case UP:
                    yDelta-=5;
                    break;
                case DOWN:
                    yDelta+=5;
                    break;
            }
        }
    }

    private void updateAnimation() {
        aniTick++;
        if( aniTick >= aniSpeed){
            aniTick=0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(PlayerAction)){
                aniIndex=0; 
            }
        }


    }

    

} 

    
