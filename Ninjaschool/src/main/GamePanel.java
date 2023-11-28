package main;
import java.awt.Color;
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
        g.setColor(Color.white);
		for (int i = 0; i < 64; i++)
			for (int j = 0; j < 40; j++)
				g.fillRect(i * 20, j * 20, 20, 20);
        game.render(g);

    }
    public Game getGame(){
        return game;
    }
} 

    
