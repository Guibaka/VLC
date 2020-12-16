package vlc.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*Le Panel Box représente la partie gauche 
 * de notre lecteur qui contient les 6 boutons*/
public class Box extends JPanel {
	Box(){
		/*Box contion un BoxLayout qui empile 
		 * 2 Panel dont chacun d'entre eux contiennent 
		 * 3 boutons*/
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/*Preminer panel contenant un FlowLayout pour 
		 * alligner les 3 boutons du haut verticalement*/
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		JButton doubleL = new JButton("<<");
		JButton doubleR = new JButton(">>");
		JButton singleR = new JButton(">") {
			/*On augmente la taille du bouton*/
			public Dimension getPreferredSize() {
			    Dimension size = getUI().getPreferredSize(this);
			    size.height = size.height*3/2;
			    return size;
			  }
		};
		top.add(doubleL);
		top.add(singleR);
		top.add(doubleR);
		
		/*Second panel contenant un FlowLayout pour 
		 * alligner les 3 boutons du bas verticalement*/
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		JButton batonL = new JButton("|<");
		JButton batonR = new JButton(">|");
		JButton batonD = new JButton("||");
		bottom.add(batonL);
		bottom.add(batonD);
		bottom.add(batonR);
		
		/*On rajoute ces 2 panel dans le panel Box */
		add(top);
		add(bottom);
		
	}
}
