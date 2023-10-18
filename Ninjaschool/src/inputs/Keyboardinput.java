package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.Constants.Directions.*;

import main.GamePanel;

public class Keyboardinput implements KeyListener{

    private GamePanel gamePanel;
    public Keyboardinput(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                // System.out.println("A");
                gamePanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                // System.out.println("S");
                gamePanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                // System.out.println("D");
                gamePanel.setDirection(RIGHT);
                break;
            case KeyEvent.VK_W:
                // System.out.println("W");
                gamePanel.setDirection(UP);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
            case KeyEvent.VK_W:
            gamePanel.setMoving(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}
