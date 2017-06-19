package view;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 16, height = 16;
	
	public static BufferedImage player, wall, mud, air, rock, diamond;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_start;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] rock_mv, diamond_mv;
	public static BufferedImage inventoryScreen;
	
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/human.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/test2.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet3.crop(192, 128, 64, 32);
		btn_start[1] = sheet3.crop(192, 160, 64, 32);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_start = new BufferedImage[3];
		
		rock_mv = new BufferedImage[4];
		diamond_mv = new BufferedImage[4];
		
		player_down[0] = sheet.crop(0, 64, width, height);
		player_down[1] = sheet.crop(16, 64, width, height);
		player_down[2] = sheet.crop(32, 64, width, height);
		player_down[3] = sheet.crop(48, 64, width, height);
		player_up[0] = sheet.crop(0, 32, width, height);
		player_up[1] = sheet.crop(16, 32, width, height);
		player_up[2] = sheet.crop(32, 32, width, height);
		player_up[3] = sheet.crop(48, 32, width, height);
		player_left[0] = sheet.crop(0, 16, width, height);
		player_left[1] = sheet.crop(16, 16, width, height);
		player_left[2] = sheet.crop(32, 16, width, height);
		player_right[0] = sheet.crop(0, 48, width, height);
		player_right[1] = sheet.crop(16, 48, width, height);
		player_right[2] = sheet.crop(32, 48, width, height);
		player_start[0] = sheet.crop(48, 0, width, height);
		player_start[1] = sheet.crop(0, 0, width, height);
		player_start[2] = sheet.crop(16, 0, width, height);


		player = sheet.crop(48, 64, width, height);
		wall = sheet2.crop(0, 0, width, height);
		mud = sheet2.crop(16, 0, width, height);
		air = sheet2.crop(32, 0, width, height);
		rock = sheet2.crop(48, 0, width, height);
		diamond = sheet2.crop(64, 0, width, height);
		
		rock_mv[0] = sheet2.crop(48, 0, width, height);
		rock_mv[1] = sheet2.crop(48, 16, width, height);
		rock_mv[2] = sheet2.crop(48, 32, width, height);
		rock_mv[3] = sheet2.crop(48, 48, width, height);
		
		diamond_mv[0] = sheet2.crop(64, 0, width, height);
		diamond_mv[1] = sheet2.crop(64, 16, width, height);
		diamond_mv[2] = sheet2.crop(64, 32, width, height);
		diamond_mv[3] = sheet2.crop(64, 48, width, height);
	}
	
}

