package model;

import java.awt.Graphics;
import controller.Utilities;
import model.Tile;

public class World {
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;
		
	public World(String path) {
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x,y).render(graphics, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}
		
	public Tile getTile(int x, int y) {
		Tile tile = Tile.tiles[tiles[x][y]];
		if(tile == null) {
			return Tile.dirtTile;
		}
		return tile;
	}
		
	private void loadWorld(String path) {
		String file = Utilities.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		spawnX = Utilities.parseInt(tokens[2]);
		spawnY = Utilities.parseInt(tokens[3]);
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utilities.parseInt(tokens[(x + y * width) + 4]);
				System.out.println(tiles[x][y]);
			}
		}
	}
}
