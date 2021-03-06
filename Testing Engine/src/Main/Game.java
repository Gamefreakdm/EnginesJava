package Main;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import GameObject.Player.Player;
import Graphics.Image.AnimatedSprite;
import Graphics.Render.Screen;
import Input.InputHandler;
import Level.Level;

public class Game {
	private double Time = 0;
	private String gs = "Main";
	private Level Level1 = new Level(64);
	private Player player = new Player(0, 20, 40, AnimatedSprite.Glob, this);

	public void Update() {
		if (Time >= 20.0)
			Time = 0;
		Time += 0.1;
	}

	public void Render(Screen screen) {
		Level1.Render(screen, 0, 0);
		player.Render(screen);
	}

	public void KeyUpdate(JFrame Frame) {
		Frame.requestFocus();
		if (InputHandler.getKey(KeyEvent.VK_ESCAPE))
			System.exit(0);
		if (gs == "Playing") {
		}
	}

	public double getTime() {
		return Time;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}
}