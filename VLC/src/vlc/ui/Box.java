package vlc.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Box extends JPanel {
	Box(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		JButton doubleL = new JButton("<<");
		JButton doubleR = new JButton(">>");
		JButton singleR = new JButton(">") {
			public Dimension getPreferredSize() {
			    Dimension size = getUI().getPreferredSize(this);
			    size.height = size.height*3/2;
			    return size;
			  }
		};
		top.add(doubleL);
		top.add(singleR);
		top.add(doubleR);
		add(top);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		JButton batonL = new JButton("|<");
		JButton batonR = new JButton(">|");
		JButton batonD = new JButton("||");
		bottom.add(batonL);
		bottom.add(batonD);
		bottom.add(batonR);
		add(bottom);
		
	}
}
