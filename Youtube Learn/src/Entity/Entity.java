package Entity;

import java.util.Random;
import Graphics.Screen;
import Level.Level;

public class Entity {
	public int x, y;
	private boolean removed = false;
	private Level level;
	private Random random = new Random();

	public void Update() {
	}

	public void Render(Screen screen) {
	}

	public void Removed() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
}