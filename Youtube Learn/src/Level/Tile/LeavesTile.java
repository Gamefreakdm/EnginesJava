package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class LeavesTile extends Tile {

	public LeavesTile(Sprite sprite) {
		super(sprite);
	}

	public void Render(int x, int y, Screen screen) {
		screen.RenderTile(x << 5, y << 5, this);
	}
}