package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int Worldx,Worldy;
    public int speed;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,upidle,forwardidle,leftidle,rightidle;
    public String dir;
    
    public int spritecounter = 0;
    public int spritenum = 1;
    
    public Rectangle solidArea;
    public boolean CollisonOn = false;
}
