package pl.kosinski;
import javax.swing.*;


public class Okno extends JFrame {
	
	public Okno(){
		super("Obrazek");
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel obrazPanel = new ImageHandler();
		add(obrazPanel);
		
		pack();
		setVisible(true);
	}
	
}
