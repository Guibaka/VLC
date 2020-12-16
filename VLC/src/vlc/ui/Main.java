package vlc.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame{
	int HEIGHT = 110;
	int WIDTH = 500;
	
	Main(String title){
		super(title);
		setSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		/*Panel contenant les 6 boutons à gauche 
		 * de notre Frame*/
		Box playPauseB = new Box();
		add(playPauseB, BorderLayout.WEST);
		
		MultiVLC vlcProgression = new MultiVLC();		
		Sound volume = new Sound();		
		
		/*Panel contenant la progression de la vidéo 
		 * ainsi que les composant situé en dessous*/
		JPanel soundP = new JPanel();
		soundP.setLayout(new BorderLayout());
		soundP.add(vlcProgression);
		soundP.add(volume, BorderLayout.SOUTH);
		add(soundP, BorderLayout.CENTER);
		
		/*Listener pour connaître la taille de la frame lors d'un resize*/
		addComponentListener(new Resizable(this, soundP, playPauseB, HEIGHT, WIDTH));
		
		/*Ajout d'un Listener abonné au bouton "=" situé en bas à droite de notre frame*/
		addButtonEqualAction(volume, soundP, playPauseB);
				
		pack();
	}
	
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				(new Main("VLC")).setVisible(true);
			}
		});
	}
	
	/*Méthode permettant au ActionListener ButtonEqualAction
	 * de s'abonner au bon bouton et en passant les bons éléments
	 * pour créer un panneau supplémentaire lors d'un ActionPerformed*/
	void addButtonEqualAction(JPanel volume, JPanel soundP, JPanel playPauseB) {
		/*On parcourt tous les component de notre JFrame*/
		for(int i=0; i<volume.getComponentCount(); i++) {
			Component c = volume.getComponent(i)  ;
			if(c instanceof JPanel){
				JPanel buttons = (JPanel) volume.getComponent(i);
				/*Parcours tous les éléments de notre sous Panel*/
				for(int j=0; j<buttons.getComponentCount(); j++ ) {
					/*Retrouve les component qui sont des JButton*/
					if(buttons.getComponent(j) instanceof JButton) {
						JButton b = (JButton) buttons.getComponent(j);
						if(b.getText().equals("=")) { // on s'interesse au bouton = 
							b.addActionListener(new ButtonEqualAction(this, soundP, playPauseB));
						}
					}
				}
				
			}
		}
	}
	
}


