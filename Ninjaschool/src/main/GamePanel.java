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
    private Game game;
    public GamePanel(Game game){
        this.game=game;
        mouseinput= new Mouseinput(this);

        setPanelSize();
        addKeyListener(new Keyboardinput(this));
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }
    private void setPanelSize(){
        Dimension size= new Dimension(1280,800); 
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

    
