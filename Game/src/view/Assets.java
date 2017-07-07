package view;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 100;
	private static final int height = 100;
	public static BufferedImage player, troll, unicorn, grass, stone, dirt;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		player = sheet.crop(0, 0, width, height);
		troll = sheet.crop(width, 0, width, height);
		unicorn = sheet.crop(width * 2, 0, width, height);
		grass = sheet.crop(width * 3, 0, width, height);
		stone = sheet.crop(width * 4, 0, width, height);
		dirt = sheet.crop(width * 5, 0, width, height);
	}
}
