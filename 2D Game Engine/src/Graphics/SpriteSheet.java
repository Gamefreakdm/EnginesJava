package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage image;

	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	public final BufferedImage GrabImage(int Col, int Row, int Width, int Height, int WH) {
		BufferedImage img = image.getSubimage((Col * WH) - WH, (Row * WH) - WH, Width, Height);
		return img;
	}
}