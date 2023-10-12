package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboardinput implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                System.out.println("A");
                break;
            case KeyEvent.VK_S:
                System.out.println("S");
                break;
            case KeyEvent.VK_D:
                System.out.println("D");
                break;
            case KeyEvent.VK_W:
                System.out.println("W");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}
