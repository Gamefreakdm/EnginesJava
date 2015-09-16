package Graphics;

import Level.Tile.Tile;

public class Screen {
	public int[] Pixels;
	public final int WIDTH, HEIGHT;
	public int xOffset, yOffset;

	public Screen(int Width, int Height) {
		WIDTH = Width;
		HEIGHT = Height;
		Pixels = new int[Width * Height];
	}

	public void RenderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			if (ya < -tile.sprite.SIZE || ya >= HEIGHT)
				break;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= WIDTH)
					break;
				if (xa < 0)
					xa = 0;
				if (ya < 0)
					ya = 0;
				Pixels[xa + ya * WIDTH] = tile.sprite.Pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void Clear() {
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
	}

	public void setOffset(int xOf, int yOf) {
		this.xOffset = xOf;
		this.yOffset = yOf;
	}
}