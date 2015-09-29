package Graphics;

public class Screen {
	private static int[] Pixels;
	private static int Width, Height;

	public static void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public static void Render() {
		for (int y = 0; y < Height; y++) {
			if (y < 0 || y >= Height)
				break;
			for (int x = 0; x < Width; x++) {
				if (x < 0 || x >= Width)
					break;
				Pixels[x + y * Width] = 0x0;
			}
		}
	}

	public static void setWHP(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}
}