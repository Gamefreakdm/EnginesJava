package Graphics;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	private BufferedImage image;

	public final BufferedImage BufferedImageLoader(String path, String ImageName) {
		try {
			image = ImageIO.read(new FileInputStream(path));
		} catch (IOException e) {
			System.out.println("[System] Could not load image: " + ImageName);
			System.out.println("[System] " + path + " is incorrect make sure the path is correct.");
			e.printStackTrace();
		}
		return image;
	}
}