package pl.kosinski;
import java.awt.EventQueue;

public class Obraz {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Okno();
			}
			
			
		});
		
		
		
	}
	
}
