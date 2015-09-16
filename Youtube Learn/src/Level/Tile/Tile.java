package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	public static Tile Grass = new GrassTile(Sprite.Grass);
	public static Tile Void = new VoidTile(Sprite.Void);
	public static Tile Water = new WaterTile(Sprite.Water);
	public static Tile Leaves = new LeavesTile(Sprite.Leaves);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void Render(int x, int y, Screen screen) {
	}

	public boolean Solid() {
		return false;
	}
}