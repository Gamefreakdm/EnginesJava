package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class WaterTile extends Tile {

	public WaterTile(Sprite sprite) {
		super(sprite);
	}

	public void Render(int x, int y, Screen screen) {
		screen.RenderTile(x << 5, y << 5, this);
	}
}