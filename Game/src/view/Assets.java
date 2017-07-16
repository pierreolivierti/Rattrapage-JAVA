package view;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 100;
	private static final int height = 100;
	public static BufferedImage player, enemy, unicorn, grass, stone, dirt;
	
	// Create assets separately  
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png")); 	// Load the image-sheet
		player = sheet.crop(0, 0, width, height);											// Player asset position
		enemy = sheet.crop(width, 0, width, height);										// Troll asset position
		unicorn = sheet.crop(width * 2, 0, width, height);									// Unicorn asset position
		grass = sheet.crop(width * 3, 0, width, height);									// Grass asset position
		stone = sheet.crop(width * 4, 0, width, height);									// Stone asset position
		dirt = sheet.crop(width * 5, 0, width, height);										// Dirt asset position
	}
}
