package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class Player extends Entity {

    private BufferedImage[][] animation;
    private int aniTick, aniIndex, aniSpeed= 15;
    private int PlayerAction = RUNNING;
    private boolean moving = false, attacking= false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimation();
        //TODO Auto-generated constructor stub
    }

    public void update(){
        updatePos();
        updateAnimation();
        setAnimation();
        
    }
    public void render(Graphics g){
        g.drawImage(animation[PlayerAction][aniIndex],(int) x, (int) y, 64*2, 64*2, null);
    }

    private void setAnimation() {

        int startAni = PlayerAction;
        if (moving ){
            PlayerAction =RUNNING;
        }
        else PlayerAction =IDLE;


        if(attacking){
            PlayerAction= ATTACK_1;
        }

        if(startAni != PlayerAction){
            restAniTick();
        }
    }

    private void restAniTick() {
        aniTick=0;
        aniIndex=0;
    }

    private void updateAnimation() {
        aniTick++;
        if( aniTick >= aniSpeed){
            aniTick=0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(PlayerAction)){
                aniIndex=0; 
                attacking= false;
            }
        }
    }

    private void updatePos() {

        moving =false;
        if (left && !right){
            x -= playerSpeed;
            moving= true;
        }
        else if ( right && !left){
            x+=playerSpeed;
            moving= true;
        }

        if ( up &&!down){
            
            y-=playerSpeed;
            moving= true;
        }
        else if( down&&!up){
            
            y+=playerSpeed;
            moving= true;
        }
    }
    private void loadAnimation() {
        try {
            // img= ImageIO.read(is);
            BufferedImage img= ImageIO.read(new FileInputStream("Ninjaschool/res/adventurer_Sprite_Sheet.png"));

              animation = new BufferedImage[13][13];

                    for ( int j=0; j<animation.length; j++)
                        for( int i=0; i<animation.length; i++){
                            animation[j][i]= img.getSubimage(i*64,j*64 , 64, 64);
                        }
                    

        } catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                 new FileInputStream("Ninjaschool/res/adventurer_Sprite_Sheet.png").close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void resetDirBooleans(){
        left= false;
        right= false;
        up=false;
        down=false;
    }
    public void setAttack(boolean attacking){
        this.attacking= attacking;
    }
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }



    
    
          

}
