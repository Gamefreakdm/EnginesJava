package Level;

import Graphics.Screen;
import Level.Tile.Tile;

public class Level {
	protected int mapwidth, mapheight;
	protected int[] Tiles;

	public Level(int w, int h) {
		this.mapwidth = w;
		this.mapheight = h;
		this.Tiles = new int[mapwidth * mapheight];
		generateLevel();
	}

	public Level(String path) {
	}

	protected void generateLevel() {
	}

	@SuppressWarnings("unused")
	private void LoadLevel(String path) {
	}

	public void Update() {
	}

	public void Render(int xscroll, int yscroll, Screen screen) {
		screen.setOffset(xscroll, yscroll);
		int x0 = xscroll >> 5;
		int x1 = (xscroll + screen.WIDTH + 32) >> 5;
		int y0 = yscroll >> 5;
		int y1 = (yscroll + screen.HEIGHT + 32) >> 5;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).Render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || y >= mapheight || x >= mapwidth)
			return Tile.Void;
		if (Tiles[x + y * mapwidth] == 0)
			return Tile.Grass;
		if (Tiles[x + y * mapwidth] == 1)
			return Tile.Water;
		if (Tiles[x + y * mapwidth] == 2)
			return Tile.Leaves;
		return Tile.Grass;
	}
}