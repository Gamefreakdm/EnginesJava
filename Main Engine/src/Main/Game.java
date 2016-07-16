package Main;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import GameObject.Entity.EntityHanlder;
import Graphics.Render.Screen;
import Input.InputHandler;

public class Game {
	private String gs;
	private double Time = 0;
	private EntityHanlder EnH = new EntityHanlder();

	public void Update(InputHandler IH, JFrame frame) {
		if (Time >= 20.0)
			Time = 0;
		Time += 0.1;
		frame.requestFocus();
		KeyUpdate(IH);
		UpdateGO();
	}

	private void UpdateGO() {
		EnH.UpdateMobs();
		EnH.UpdateItems();
	}

	private void KeyUpdate(InputHandler IH) {
		if (IH.getKey(KeyEvent.VK_ESCAPE))
			System.exit(0);
	}

	public void Render(Screen screen) {
		EnH.RenderMobs(screen);
		EnH.RenderItems(screen);
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