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
	private static int HEIGHT = 100;
	private static int WIDTH = 400;
	
	Main(String title){
		super(title);
		setSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		Box playPauseB = new Box();
		add(playPauseB, BorderLayout.WEST);
		
		MultiVLC vlcProgression = new MultiVLC();		
		Sound volume = new Sound();
		
		
		
		
		JPanel soundP = new JPanel();
		soundP.setLayout(new BorderLayout());
		soundP.add(vlcProgression);
		soundP.add(volume, BorderLayout.SOUTH);
		add(soundP, BorderLayout.CENTER);
		
		addComponentListener(new Resizable(this, soundP, playPauseB, HEIGHT));
		
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
	
	void addButtonEqualAction(JPanel volume, JPanel soundP, JPanel playPauseB) {
		for(int i=0; i<volume.getComponentCount(); i++) {
			Component c = volume.getComponent(i)  ;
			if(c instanceof JPanel){
				JPanel buttons = (JPanel) volume.getComponent(i);
				for(int j=0; j<buttons.getComponentCount(); j++ ) {
					if(buttons.getComponent(j) instanceof JButton) {
						JButton b = (JButton) buttons.getComponent(j);
						if(b.getText().equals("=")) {
							b.addActionListener(new ButtonEqualAction(this, soundP, playPauseB));
						}
					}
				}
				
			}
		}
	}
}


