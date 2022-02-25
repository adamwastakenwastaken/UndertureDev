package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
	GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.Screenwidth /2 - (gp.Tilesize/2);
        screenY = gp.screenHeight/2 - (gp.Tilesize/2);
        
        solidArea = new Rectangle(8,16,32,32);

        setDefaultValues();
        getPlayerImg();
    }

    public void getPlayerImg(){
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_back_walk_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_back_walk_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_walk_forward_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_walk_forward_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_walk_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_walk_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_right_walk_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_walk_right_2.png"));
            upidle = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_idle_back.png"));
            forwardidle = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_idle_forward.png"));
            leftidle = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_idle_left.png"));
            rightidle = ImageIO.read(getClass().getResourceAsStream("/player/hiroto_idle_right.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void setDefaultValues(){
        Worldx = gp.Tilesize * 23;
        Worldy = gp.Tilesize * 21;
        speed = 4;
        dir = "down";
    }
    public void update() {
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
    		if(keyH.upPressed == true){
                dir = "up";
            }

            else if(keyH.downPressed == true){
                dir = "down"; 
            }

            else if(keyH.leftPressed == true){
                dir = "left";
            }

            else if(keyH.rightPressed == true){
                dir = "right";
            }
    		
    		CollisonOn = false;
    		gp.cChecker.checkTile(this);
    		
    		if(CollisonOn == false) {
    			switch(dir) {
    			case"up":
    				Worldy -= speed;
    				break;
    			case"down":
    				Worldy += speed;
    				break;
    			case"left":
    				Worldx -= speed;
    				break;
    			case"right":
    				Worldx += speed;
    				break;
    			}
    		}
    		
    		 spritecounter++;
    	        if(spritecounter > 10) {
    	        	if(spritenum ==1) {
    	        		spritenum =2;
    	        	}
    	        	else if(spritenum ==2) {
    	        		spritenum = 1;
    	        	}
    	        	spritecounter =0;
    	        }
            
    	}
       
        
    }
    public void draw(Graphics2D g2){
        BufferedImage img = null;
        switch (dir){
            case "up":
            	if(spritenum == 1) {
            		img = up1;
            	}
            	if(spritenum == 2) {
            		img = up2;
            	}
                break;
            case "down":
            	if(spritenum == 1) {
            		img = down1;
            	}
            	if(spritenum == 2) {
            		img = down2;
            	}
                break;
            case "left":
            	if(spritenum == 1) {
            		img = left1;
            	}
            	if(spritenum == 2) {
            		img = left2;
            	}
                break;
            case "right":
            	if(spritenum == 1) {
            		img = right1;
            	}
            	if(spritenum == 2) {
            		img = right2;
            	}
        }
        g2.drawImage(img, screenX,screenY, gp.Tilesize,gp.Tilesize, null);
    }
}