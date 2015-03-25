package pl.kosinski;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageHandler extends JPanel {
	private BufferedImage obraz = null;
	public ImageHandler() {
		super();
		
		try {
			obraz = ImageIO.read(new File("C:\\Users\\konrad\\Desktop\\IMG_20150325_151356972.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dimension dimension = new Dimension(obraz.getWidth(), obraz.getHeight());
		setPreferredSize(dimension);
		
		
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(obraz, 0, 0, this);
	}
	
}
