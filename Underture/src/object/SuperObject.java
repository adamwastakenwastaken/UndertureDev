package object;
import java.awt.image.BufferedImage;
import java.awt.*;

import main.GamePanel;

public class SuperObject {
    public BufferedImage img;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.Worldx + gp.player.screenX;
        int screenY = worldY - gp.player.Worldy + gp.player.screenY;
        
        if(worldX + gp.Tilesize > gp.player.Worldx - gp.player.screenX&&
                worldX - gp.Tilesize < gp.player.Worldx + gp.player.screenX&&
                worldY + gp.Tilesize > gp.player.Worldy - gp.player.screenY&&
                worldY - gp.Tilesize < gp.player.Worldy + gp.player.screenY) {
            g2.drawImage(img, screenX, screenY, gp.Tilesize, gp.Tilesize, null);
        }
    }
}
