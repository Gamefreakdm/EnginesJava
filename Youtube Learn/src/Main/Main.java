package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;
import Level.Level;
import Level.RandomLevel;

public class Main extends Canvas implements Runnable {
	private JFrame Frame;
	private int[] Pixels;
	private Screen screen;
	private BufferStrategy BS;
	private Level Level;
	private BufferedImage bimg;
	private final int WIDTH, HEIGHT;
	public static KeyHandler KH;
	private static final long serialVersionUID = 1L;

	public Main() {
		Frame = new JFrame("Loading...");
		WIDTH = 1360;
		HEIGHT = 720;
		Level = new RandomLevel(64, 64);
		KH = new KeyHandler();
		bimg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
		screen = new Screen(WIDTH, HEIGHT);
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(KH);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setSize(M.WIDTH, M.HEIGHT);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setVisible(true);
		M.Start();
	}

	private void Start() {
		Thread mainThread = new Thread(this);
		mainThread.start();
	}

	public void run() {
		boolean Running = true;
		long lastTime = System.nanoTime();
		long Timer = System.currentTimeMillis();
		final double NS = 1000000000.0 / 60.0;
		double Delta = 0;
		int Frames = 0;
		while (Running) {
			long nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Delta--;
			}
			Update();
			Render();
			Frames++;
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle("Youtube Learn" + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		System.out.println("Main Boolean stopped");
		System.exit(-1);
	}

	int x, y;

	private void Update() {
		Frame.requestFocus();
		KH.Update();
		if (KH.Keys[0])
			y--;
		if (KH.Keys[1])
			y++;
		if (KH.Keys[2])
			x--;
		if (KH.Keys[3])
			x++;
		if (KH.Keys[4])
			System.exit(0);
	}

	private void Render() {
		BS = getBufferStrategy();
		if (BS == null) {
			createBufferStrategy(3);
			return;
		}
		screen.Clear();
		Level.Render(x, y, screen);
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = screen.Pixels[i];
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		BS.show();
	}
}