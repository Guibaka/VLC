package vlc.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

/*Ce Panel contient un JSlider pour le volume et les 2 boutons d'option # et = */
public class Sound extends JPanel{
	Sound(){
		setLayout(new BorderLayout());
		JSlider slide = new JSlider();
		
		/*On initialise un JPanel pour les boutons # et =*/
		JPanel selections = new JPanel();
		/*On lui donne un FlowLayout pour aligner les boutons horizontalement*/
		selections.setLayout(new FlowLayout());
		JButton diese = new JButton("#");
		JButton egal = new JButton("=");
		selections.add(diese);
		selections.add(egal);
		
		/*On ajoute ces 2 component dans notre Panel Sound*/
		add(slide, BorderLayout.WEST);
		add(selections, BorderLayout.EAST);
		
	}
}
