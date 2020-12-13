package vlc.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Sound extends JPanel{
	Sound(){
		setLayout(new BorderLayout());
		JSlider slide = new JSlider();
		
		JPanel selections = new JPanel();
		selections.setLayout(new FlowLayout());
		JButton diese = new JButton("#");
		JButton egal = new JButton("=");
		selections.add(diese);
		selections.add(egal);
		
		add(slide, BorderLayout.WEST);
		add(selections, BorderLayout.EAST);
		
	}
}
