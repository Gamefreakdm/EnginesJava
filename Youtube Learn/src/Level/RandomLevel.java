package Level;

import java.util.Random;

public class RandomLevel extends Level {
	private static final Random random = new Random();

	public RandomLevel(int w, int h) {
		super(w, h);
	}

	protected void generateLevel() {
		for (int y = 0; y < mapheight; y++) {
			if (y < 0 || y >= mapheight)
				continue;
			for (int x = 0; x < mapwidth; x++) {
				if (x < 0 || x >= mapwidth)
					continue;
				Tiles[x + y * mapwidth] = random.nextInt(4);
			}
		}
	}
}