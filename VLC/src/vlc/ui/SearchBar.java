package vlc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*Panel SearchBar contient la bar de recherche et ses boutons
 * dans le panneau supplémentaire*/
public class SearchBar extends JPanel {
	SearchBar(){
		setLayout(new BorderLayout());
		
		/*Inititalise un panel contenant les 3 boutons de gauche*/
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton plus = new JButton("+");
		JButton random = new JButton("random");
		JButton repeat = new JButton("repeat");
		buttons.add(plus);
		buttons.add(random);
		buttons.add(repeat);
		
		/*Utilise un panel pour le nombre d'éléments*/
		JLabel elt = new JLabel("Elements");
		JPanel eltP = new JPanel();
		/*GirdBagLayout nous permet de centrer le Label dans le panel*/
		eltP.setLayout(new GridBagLayout()); 
		eltP.add(elt);
		
		/*Initialise un JTextField pour la recherche d'éléments*/
		JTextField search = new JTextField();
		search.setPreferredSize(new Dimension(100, 10));
		
		/*Ajout de ces 3 components dans le panel*/
		add(buttons, BorderLayout.WEST);
		add(eltP, BorderLayout.CENTER);
		add(search, BorderLayout.EAST);
	}
}
