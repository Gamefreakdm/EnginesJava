package Main;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Main extends Canvas {
	private static final long serialVersionUID = 1L;
	private final int Width, Height;
	private final String Title;
	private final JFrame Frame;

	private Main() {
		Width = 800;
		Height = 600;
		Title = "title";
		Frame = new JFrame();
	}

	public static void main(String args[]) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setVisible(true);
	}
}