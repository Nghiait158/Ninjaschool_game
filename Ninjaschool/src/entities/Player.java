package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class Player extends Entity {

    private BufferedImage[][] animation;
    private int aniTick, aniIndex, aniSpeed= 25;
    private int PlayerAction = IDLE;
    private boolean moving = false, attacking= false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        //TODO Auto-generated constructor stub
    }

    public void update(){
        updatePos();
        updateAnimationTick();
        setAnimation();
        
    }
    public void render(Graphics g){
        g.drawImage(animation[PlayerAction][aniIndex],(int) x, (int) y, width, height, null);
    }

    private void updateAnimationTick() {
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
    private void loadAnimations() {
        BufferedImage img= LoadSave.GetPlayerAtlas(LoadSave.PLAYER_ATLAS);
			animation = new BufferedImage[12][12];
			for (int j = 0; j < animation.length; j++)
				for (int i = 0; i < animation[j].length; i++)
					animation[j][i] = img.getSubimage(i * 64, j * 64, 64, 64);

		
	}
    public void resetDirBooleans(){
        left= false;
        right= false;
        up=false;
        down=false;
    }
    public void setAttacking(boolean attacking){
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
