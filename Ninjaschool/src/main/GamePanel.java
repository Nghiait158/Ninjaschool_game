package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.Keyboardinput;
import inputs.Mouseinput;
import static main.Game.GAME_WIDTH;
import static main.Game.GAME_HEIGHT;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    private Game game;
    public GamePanel(Game game){
       
        mouseinput= new Mouseinput(this);
        this.game=game;
        setPanelSize();
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }
    private void setPanelSize(){
        Dimension size= new Dimension( GAME_WIDTH, GAME_HEIGHT); 
        setPreferredSize(size); 
    }
  
    public void updateGame() {
       
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        game.render(g);

    }
    public Game getGame(){
        return game;
    }
} 

    
