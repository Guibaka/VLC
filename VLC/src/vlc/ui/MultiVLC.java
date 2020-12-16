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

/*Ce Panel contient un JSlider pour la progression de la vidéo 
 *et un JLabel de la vidéo pour sa description*/
public class MultiVLC extends JPanel {

	MultiVLC() {
		/*On utilise un BoxLayout sur le Panel MultiVLC
		 *pour empiler label et le JSlider*/
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border bLine = BorderFactory.createLoweredBevelBorder();
		setBorder(bLine);
		
		/*On initialise un JPanel pour lui affecter un Label
		 *et sa progression en chiffre*/
		JPanel texts = new JPanel();
		texts.setLayout(new BorderLayout());
		JLabel vlc = new JLabel("Lecteur mulitmédia VLC");
		JLabel time = new JLabel("00:00"); 
		texts.add(vlc, BorderLayout.WEST);
		texts.add(time, BorderLayout.EAST);
		
		
		JSlider slide = new JSlider();
		
		/*On rajoute ces 2 éléments dans le Panel MultiVLC*/
		add(texts, BorderLayout.NORTH);
		add(slide);
		setVisible(true);
	}
}
