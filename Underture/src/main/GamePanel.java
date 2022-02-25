package main;

import javax.swing.*;

import entity.Player;
import tile.TileManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {
	//Screen settings
    final int origTilesize = 16;  //16x16 tiles
    final int scale = 3;

    public final int Tilesize = origTilesize * scale;
    public final int maxScreencolon = 16;
    public final int maxScreenrow = 12;
    public final int Screenwidth = Tilesize * maxScreencolon;
    public final int screenHeight = Tilesize * maxScreenrow;
    
    //world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = Tilesize * maxWorldCol;
    public final int worldHeigt = Tilesize * maxWorldRow;

    KeyHandler keyH = new KeyHandler();
    private Thread gameThread;
    public Player player = new Player(this,keyH);
    TileManager tm = new TileManager(this);
    public CollisonChecker cChecker = new CollisonChecker(this);
    int FPS = 60;

    public GamePanel(){
        this.setPreferredSize(new Dimension(Screenwidth, screenHeight));
        this.setBackground(Color.black);
        setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1e9/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            update();
            repaint();

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime /1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tm.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
