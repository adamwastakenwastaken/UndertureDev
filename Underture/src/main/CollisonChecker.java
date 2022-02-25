package main;

import entity.Entity;

public class CollisonChecker {
	GamePanel gp;
	
	public CollisonChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.Worldx + entity.solidArea.x;
		int entityRightWorldX = entity.Worldx + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.Worldy + entity.solidArea.y;
		int entitydownWorldY = entity.Worldy + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.Tilesize;
		int entityRightCol = entityRightWorldX/gp.Tilesize;
		int entityBottomRow = entitydownWorldY/gp.Tilesize;
		int entityTopRow = entityTopWorldY/gp.Tilesize;
		
		int tilen1, tilen2;
		
		switch(entity.dir) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.Tilesize;
			tilen1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
			tilen2 = gp.tm.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tm.tile[tilen1].collisions == true || gp.tm.tile[tilen2].collisions == true) {
				entity.CollisonOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entitydownWorldY + entity.speed)/gp.Tilesize;
			tilen1 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];
			tilen2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tm.tile[tilen1].collisions == true || gp.tm.tile[tilen2].collisions == true) {
				entity.CollisonOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.Tilesize;
			tilen1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
			tilen2 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tm.tile[tilen1].collisions == true || gp.tm.tile[tilen2].collisions == true) {
				entity.CollisonOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.Tilesize;
			tilen1 = gp.tm.mapTileNum[entityRightCol][entityTopRow];
			tilen2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tm.tile[tilen1].collisions == true || gp.tm.tile[tilen2].collisions == true) {
				entity.CollisonOn = true;
			}
			break;
		}
	}
}
