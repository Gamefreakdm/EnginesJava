package Level.Tile;

import GameObject.Entity.Mob;
import Graphics.Image.AnimatedSprite;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;
import Main.Game;

public abstract class AnimatedTile {
	private int X, Y;
	private Sprite sprite;
	private final Game game;
	private final boolean IsSolid;
	private final AnimatedSprite sprites;

	public AnimatedTile(int x, int y, AnimatedSprite sps, boolean issolid, Game g) {
		sprites = sps;
		sprite = sps.getSprite(0);
		IsSolid = issolid;
		setX(x);
		setY(y);
		game = g;
	}

	// TODO: Animated Tile Function

	public abstract void Render(Screen screen);

	public boolean Collision(float x, float y, Mob mob) {
		if (x >= getX() && x <= getX() + getSprite().getWidth() && y <= getY() && y >= getY() + getSprite().getHeight())
			return true;
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean isIsSolid() {
		return IsSolid;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Game getGame() {
		return game;
	}

	public AnimatedSprite getSprites() {
		return sprites;
	}
}