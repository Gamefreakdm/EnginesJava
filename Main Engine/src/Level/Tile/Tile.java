package Level.Tile;

import GameObject.Entity.Mob;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;
import Main.Game;

public abstract class Tile {
	private int X, Y;
	private final Game game;
	private final Sprite sprite;
	private final boolean IsSolid;

	public Tile(int x, int y, Sprite sp, boolean issolid, Game g) {
		sprite = sp;
		IsSolid = issolid;
		setX(x);
		setY(y);
		game = g;
	}

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
}