package model;

import java.awt.Graphics;

import controller.Handler;
import controller.Utilities;
import model.Tile;

public class World {
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;
	private Handler handler;
		
	// Constructor
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick() {
		
	}

	public void render(Graphics graphics) {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffSet() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffSet() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffSet() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getCamera().getyOffSet() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(graphics, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffSet()),
						(int) (y * Tile.TILE_HEIGHT - handler.getCamera().getyOffSet()));
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
			}
		}
	}
}
