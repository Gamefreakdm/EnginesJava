package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas {
	private static final long serialVersionUID = 1L;
	private int[] Pixels;
	public int OpSelected = 0;
	private char Game_State = 'm';
	private int Width, Height;
	private BufferedImage bimg;
	private float Trx = 10, Try = 10;
	private int flip = 100;

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			if (Pixels[i] != 0)
				Pixels[i] = 0;
		}
	}

	public void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = (((DataBufferInt) bimg.getRaster().getDataBuffer()).getData());
			createBufferStrategy(3);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		clearPixels();
		switch (Game_State) {
		case 'm':
			RenderMain(0xff0000ff);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.setColor(Color.black);
			g.drawString("Transformation!!!!!", 460, 100);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			if (OpSelected == 0) {
				g.setColor(Color.green);
				g.drawString("Translate", 670, 400);
				g.setColor(Color.BLACK);
				g.drawString("Reflect", 670, 500);
				g.drawString("Re-Size", 670, 600);
			} else if (OpSelected == 1) {
				g.setColor(Color.green);
				g.drawString("Reflect", 670, 500);
				g.setColor(Color.BLACK);
				g.drawString("Translate", 670, 400);
				g.drawString("Re-Size", 670, 600);
			} else if (OpSelected == 2) {
				g.setColor(Color.green);
				g.drawString("Re-Size", 670, 600);
				g.setColor(Color.BLACK);
				g.drawString("Reflect", 670, 500);
				g.drawString("Translate", 670, 400);
			}
			break;
		case 't':
			RenderMain(0);
			RenderTrans(100, 100, Trx, Try);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			break;
		case 'r':
			RenderMain(0);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			g.setColor(Color.BLUE);
			g.drawArc(10, 10, 600, 600, 0, flip);
			break;
		}
		g.dispose();
		BS.show();
	}

	private void RenderMain(int Col) {
		for (int y = 0; y < Height; y++) {
			for (int x = 0; x < Width; x++) {
				Pixels[x + (y * Width)] = Col;
			}
		}
	}

	private void RenderTrans(int OW, int OH, float X, float Y) {
		for (int y = 0; y < OH; y++) {
			int ya = (int) (y + Y);
			if (ya < 0 || ya > Height)
				break;
			for (int x = 0; x < OW; x++) {
				int xa = (int) (x + X);
				if (xa < 0 || xa > Width)
					break;
				Pixels[xa + (ya * Width)] = 0xff0000;
			}
		}
	}

	public void setWH(int w, int h) {
		Width = w;
		Height = h;
	}

	public void setGameState(char gs) {
		Game_State = gs;
	}

	public char getGameState() {
		return Game_State;
	}

	public void setTrx(float x) {
		if (Trx > 1 && Trx < Width)
			Trx += x;
	}

	public void setTry(float y) {
		if (Try > 1 && Try < Height)
			Try += y;
	}

	public int getFlip() {
		return flip;
	}

	public void setFlip(int flip) {
		this.flip = flip;
	}
}
