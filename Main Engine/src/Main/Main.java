package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import GameObject.Entity.EntityHandler;
import Graphics.Render.Screen;
import Input.InputHandler;

public class Main extends Canvas implements Runnable {
	private final JFrame Frame = new JFrame("Loading...");
	private static final long serialVersionUID = 1L;
	private final InputHandler IH = new InputHandler();
	private final int Width = 800, Height = 600;

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.Frame.add(M);
		M.addMouseListener(M.IH);
		M.addMouseMotionListener(M.IH);
		M.addMouseWheelListener(M.IH);
		M.Frame.addKeyListener(M.IH);
		M.Frame.setResizable(false);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setVisible(true);
		M.Start();
	}

	private boolean Running;

	private void Start() {
		if (Running)
			return;
		Thread thread = new Thread(this);
		thread.start();
		Running = true;
	}

	private final Game game = new Game();
	private final String Title = "Title";

	public void run() {
		int Frames = 0;
		int Updates = 0;
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
				game.Update();
				game.KeyUpdate(Frame);
				Updates++;
				Delta--;
			}
			Render();
			Frames++;
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps" + "   |   " + Updates + " Updates");
				Frames = 0;
				Updates = 0;
			}
		}
		Stop();
	}

	private Screen screen;
	private int[] Pixels;
	private BufferedImage bimg;

	private void Render() {
		final BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			createBufferStrategy(3);
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			screen = new Screen(Width, Height, Pixels);
			return;
		}
		screen.clearPixels();
		if (game.getGs() == "Playing") {
			EntityHandler.RenderMobs(screen);
			EntityHandler.RenderItems(screen);
		}
		screen.RenderCol(0, 0, Width, Height, 0x0ff00ff);
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		g.dispose();
		BS.show();
	}

	public void Stop() {
		System.out.println("[System] Stopping...");
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		if (Running)
			return;
		screen.clearPixels();
		Frame.dispose();
	}
}