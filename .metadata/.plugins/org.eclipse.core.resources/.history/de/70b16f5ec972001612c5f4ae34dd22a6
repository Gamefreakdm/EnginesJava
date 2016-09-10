package Main;

import java.awt.Canvas;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import Input.InputHandler;

public class Window extends Canvas {
	private int[] Pixels;
	private JFrame Frame;
	private InputHandler IH;
	private int Width, Height;
	private BufferedImage Bimg;
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, int x, int y, String Title, InputHandler ih) {
		Width = width;
		Height = height;
		setIH(ih);
		Frame.addKeyListener(ih);
		Frame.addMouseListener(ih);
		Frame.addMouseMotionListener(ih);
		Frame.addMouseWheelListener(ih);
		Frame.setTitle(Title);
		Frame.setSize(width, height);
		Frame.setLocation(x, y);
		Frame.setVisible(true);
		setPixels(new int[Width * Height]);
	}

	public Window(int width, int height, String Title, InputHandler ih) {
		Width = width;
		Height = height;
		setIH(ih);
		Frame.addKeyListener(ih);
		Frame.addMouseListener(ih);
		Frame.addMouseMotionListener(ih);
		Frame.addMouseWheelListener(ih);
		Frame.setTitle(Title);
		Frame.setSize(width, height);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		setPixels(new int[Width * Height]);
	}

	public Window(String Title, InputHandler ih) {
		Width = 800;
		Height = 600;
		setIH(ih);
		Frame.addKeyListener(ih);
		Frame.addMouseListener(ih);
		Frame.addMouseMotionListener(ih);
		Frame.addMouseWheelListener(ih);
		Frame.setTitle(Title);
		Frame.setSize(Width, Height);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		setPixels(new int[Width * Height]);
	}

	public int[] getPixels() {
		return Pixels;
	}

	public void setPixels(int[] pixels) {
		Pixels = pixels;
	}

	public BufferedImage getBimg() {
		return Bimg;
	}

	public void setBimg(BufferedImage bimg) {
		Bimg = bimg;
	}

	public InputHandler getIH() {
		return IH;
	}

	public void setIH(InputHandler iH) {
		IH = iH;
	}

	public JFrame getFrame() {
		return this.Frame;
	}
}