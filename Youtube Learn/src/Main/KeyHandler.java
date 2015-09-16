package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyHandler implements KeyListener {
	private boolean[] Codes = new boolean[400];
	public boolean[] Keys = new boolean[5];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_W] || Codes[KeyEvent.VK_UP];
		Keys[1] = Codes[KeyEvent.VK_S] || Codes[KeyEvent.VK_DOWN];
		Keys[2] = Codes[KeyEvent.VK_A] || Codes[KeyEvent.VK_LEFT];
		Keys[3] = Codes[KeyEvent.VK_D] || Codes[KeyEvent.VK_RIGHT];
		Keys[4] = Codes[KeyEvent.VK_ESCAPE];
	}

	public void keyPressed(KeyEvent KP) {
		Codes[KP.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent KR) {
		Codes[KR.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent KT) {
	}
}