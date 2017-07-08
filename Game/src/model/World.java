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
		
	// Constructor
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
	
	// Get the tile type thanks to the position
	public Tile getTile(int x, int y) {
		Tile tile = Tile.tiles[tiles[x][y]];
		if(tile == null) {
			return Tile.dirtTile;
		}
		return tile;
	}
	
	// Load the world from the map file
	private void loadWorld(String path) {
		String file = Utilities.loadFileAsString(path);							// Load file in a string
		String[] tokens = file.split("\\s+");									// Remove all spaces
		width = Utilities.parseInt(tokens[0]);									// Get the width of the map
		height = Utilities.parseInt(tokens[1]);									// Get the height of the map
		spawnX = Utilities.parseInt(tokens[2]);									// Get the spawn X of the player
		spawnY = Utilities.parseInt(tokens[3]);									// Get the spawn Y of the player
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utilities.parseInt(tokens[(x + y * width) + 4]); 	// Get the tile type from the map file
				System.out.println(tiles[x][y]);
			}
		}
	}
}
