package Graphics;

public class Sprite {
	public final int SIZE;
	private int X, Y;
	public int[] Pixels;
	private SpriteSheet Sheet;
	public static Sprite Water = new Sprite(32, 0, 0, SpriteSheet.Tiles);
	public static Sprite Leaves = new Sprite(32, 1, 0, SpriteSheet.Tiles);
	public static Sprite Grass = new Sprite(32, 2, 0, SpriteSheet.Tiles);
	public static Sprite Void = new Sprite(32, 3, 0, SpriteSheet.Tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		Pixels = new int[size * size];
		Sheet = sheet;
		X = x * size;
		Y = y * size;
		Load();
	}

	private void Load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				Pixels[x + y * SIZE] = Sheet.Pixels[(x + this.X) + (y + this.Y) * Sheet.SIZE];
			}
		}
	}
}