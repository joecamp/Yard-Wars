package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.MainView;

public class EscapeKeyListener implements KeyListener{
	
		public void keyPressed(KeyEvent e) {
		}
		
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == 27){
				MainView.frame.setVisible(false);
				MainView.frame.dispose();
				System.out.println("Escape key pressed, exiting game...");
				System.exit(0);
			}
		}
		
		public void keyTyped(KeyEvent e) {
		}

}
