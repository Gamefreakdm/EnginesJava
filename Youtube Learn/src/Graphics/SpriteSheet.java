package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private String Path;
	public final int SIZE;
	public int[] Pixels;
	public static SpriteSheet Tiles = new SpriteSheet("/Textures/tiles1.png", 256);

	public SpriteSheet(String path, int size) {
		Path = path;
		SIZE = size;
		Pixels = new int[SIZE * SIZE];
		Load();
	}

	private void Load() {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(Path));
			int w = 256;
			int h = 256;
			img.getRGB(0, 0, w, h, Pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}