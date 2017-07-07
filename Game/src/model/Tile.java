package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new Grass(0);
	public static Tile stoneTile = new Stone(1);
	public static Tile dirtTile = new Dirt(2);
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics, int x, int y) {
		graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return this.id;
	}
}
