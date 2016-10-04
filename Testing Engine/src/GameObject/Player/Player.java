package GameObject.Player;

import GameObject.Entity.Mob;
import Graphics.Image.AnimatedSprite;
import Graphics.Render.Screen;
import Main.Game;

public class Player extends Mob {

	public Player(int id, float x, float y, AnimatedSprite sps, Game g) {
		super(id, x, y, sps, g);
		fM(sps);
	}

	private void fM(AnimatedSprite sps) {
		if (sps == AnimatedSprite.Glob) {
			setHealth(5.0);
		}
	}

	@Override
	public void Update() {
	}

	@Override
	public void Render(Screen screen) {
		screen.RenderSprite(getSprite(), getX(), getY());
	}

	@Override
	public void AI() {
	}
}