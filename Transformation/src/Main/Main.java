package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Graphics.Screen;
import Input.KeyHandler;

public class Main implements Runnable {
	private boolean Running;
	private int Timer = 0;
	private final String Title;
	private final JFrame Frame;
	private final Screen screen;
	private final KeyHandler KH;
	private final int Width, Height;
	private final Dimension screenSize;

	private Main() {
		System.out.println("[System] Starting...");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Width = (int) screenSize.getWidth();
		Height = (int) screenSize.getHeight();
		Title = "Title";
		KH = new KeyHandler();
		Frame = new JFrame("Loading...");
		screen = new Screen();
		screen.setWH(Width, Height);
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M.screen);
		M.Frame.addKeyListener(M.KH);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Start();
	}

	private void Start() {
		if (Running)
			return;
		Thread thread = new Thread(this);
		thread.start();
		Running = true;
	}

	public void run() {
		int Frames = 0;
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		long nowTime = 0;
		final double NS = 1000000000.0 / 60;
		System.out.println("[System] Started");
		while (Running) {
			nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				if (Frame.getTitle() != Title)
					Update();
				Delta--;
			}
			if (Frame.getTitle() == "Loading...")
				Frame.setVisible(true);
			screen.Render();
			Frames++;
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		Stop();
	}

	private void Update() {
		KeyUpdate();
	}

	private void KeyUpdate() {
		Timer++;
		Frame.requestFocus();
		KH.Update();
		if (KH.Keys[0])
			Running = false;
		if (KH.Keys[4] && screen.getGameState() == 't')
			screen.setTrx((float) -1.2);

		if (KH.Keys[5] && screen.getGameState() == 't')
			screen.setTrx((float) 1.2);
		if (KH.Keys[1] && screen.getGameState() == 't' && screen.getGameState() == 't')
			screen.setTry((float) -1.2);
		if (KH.Keys[1] && screen.getGameState() == 'r')
			screen.setFlip(-100);
		if (KH.Keys[2] && screen.getGameState() == 'r')
			screen.setFlip(100);

		if (KH.Keys[2] && screen.getGameState() == 't' && screen.getGameState() == 't')
			screen.setTry((float) 1.2);
		if (Timer >= 10) {
			if (KH.Keys[1] && screen.OpSelected >= 1 && screen.getGameState() == 'm') {
				screen.OpSelected -= 1;
				Timer = 0;
			}
			if (KH.Keys[2] && screen.OpSelected + 1 <= 2 && screen.getGameState() == 'm') {
				screen.OpSelected += 1;
				Timer = 0;
			}
			if (KH.Keys[3] && screen.OpSelected == 0) {
				screen.setGameState('t');
				Timer = 0;
			}
			if (KH.Keys[3] && screen.OpSelected == 1) {
				screen.setGameState('r');
				Timer = 0;
			}
		}
	}

	private void Stop() {
		if (Running)
			return;
		System.out.println("[System] Stopping...");
		CleanUp();
	}

	private void CleanUp() {
		screen.clearPixels();
		Frame.dispose();
	}
}