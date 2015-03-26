package pl.kosinski;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageHandler extends JPanel {
	private BufferedImage obraz = null;
	private BufferedImage obraz2 = null;
	public ImageHandler() {
		super();
		
		try {
			obraz = ImageIO.read(new File("C:\\Users\\konrad\\Desktop\\IMG_20150325_151143203.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension dimension = new Dimension(obraz.getWidth()/2, obraz.getHeight()/2);
		setPreferredSize(dimension);
		int[][] obraz_tab = new int[obraz.getWidth()][obraz.getHeight()];
		
		for(int i = 0; i < obraz.getWidth();i++){
			for(int j = 0; j < obraz.getHeight();j++){
				obraz_tab[i][j] = obraz.getRGB(i,j);
			}
		}

		//NIE DZIA£A
		BufferedImage obraz2 = new BufferedImage(obraz.getWidth(),obraz.getHeight(),obraz.getType());
		for(int i = 0; i < obraz2.getWidth();i++){
			for(int j = 0; j < obraz2.getHeight();j++){
				obraz2.setRGB(i,j,obraz_tab[i][j]);
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.scale(0.5,0.5);
		g2d.drawImage(obraz,at,this);
	}
	
}
