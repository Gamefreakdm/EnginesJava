package Entity.Mob;

import Entity.Entity;
import Graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int Dir;
	protected boolean Moving = false;

	public void Move(int xa, int ya) {
	}

	public void Update() {
	}

	public void Render() {
	}

	private boolean Collision() {
		return false;
	}
}