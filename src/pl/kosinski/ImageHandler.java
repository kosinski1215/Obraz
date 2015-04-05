package pl.kosinski;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageHandler extends JPanel {
    public static AffineTransform at    = null;
    private BufferedImage         obraz = null;
    public int[][] obraz_tab;
    public ImageHandler() {
        super();

        try {
            obraz = ImageIO.read(new File("C:\\Users\\Kooooo\\Desktop\\WIN_20150405_145705.JPG"));
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	obraz_tab = new int[obraz.getWidth()][obraz.getHeight()];
        binaryzacja();
        Dimension dimension = new Dimension(obraz.getWidth() / 2, obraz.getHeight() / 2);
        setPreferredSize(dimension);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        at = new AffineTransform();
        at.scale(0.5, 0.5);
        g2d.drawImage(obraz, at, this);
    }
private void binaryzacja(){
	int stary = 0;
	for (int i = 0; i < obraz.getHeight(); i++) {
        for (int j = 0; j < obraz.getWidth(); j++) {
            int pxl = obraz.getRGB(j,i);
            int b = (pxl & 0x000000ff);
            int g = ((pxl >> 8) & 0x000000ff);
            int r = ((pxl >> 16) & 0x000000ff);
            int c = (int) (0.299 * r + 0.587 * g + 0.114 * b);
            
            pxl = c | c << 8 | c << 16 | 0xff << 24;
            obraz_tab[j][i]=c;
            if((c-stary)>7 || (stary-c)>7){
            obraz.setRGB(j, i, 0xffffffff);
            }else{
            obraz.setRGB(j, i, 0);
            }
            stary = c;

            //System.out.println(c);

        }
    }
	
	
	
}}



//~ Formatted by Jindent --- http://www.jindent.com
