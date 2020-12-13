package vlc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class MultiVLC extends JPanel {

	MultiVLC() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border bLine = BorderFactory.createLoweredBevelBorder();
		setBorder(bLine);
		
		JPanel texts = new JPanel();
		texts.setLayout(new BorderLayout());
		JLabel vlc = new JLabel("Lecteur mulitmédia VLC");
		JLabel time = new JLabel("00:00");
		texts.add(vlc, BorderLayout.WEST);
		texts.add(time, BorderLayout.EAST);
		
		
		JSlider slide = new JSlider();
		add(texts, BorderLayout.NORTH);
		add(slide);
		setVisible(true);
	}
}
