package vlc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class Resizable extends ComponentAdapter {
	JFrame m_frame;
	JPanel m_soundP;
	JPanel m_playPauseB;
	int m_height;
	int m_width;

	Resizable(JFrame f, JPanel soundP, JPanel playPauseB, int height, int width) {
		m_frame = f;
		m_soundP = soundP;
		m_playPauseB = playPauseB;
		m_height = height;
		m_width = width;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		
		/*On assure une taille minimale de Width*/
		if(e.getComponent().getWidth() < m_width) {
			m_frame.setSize(m_width, e.getComponent().getHeight());
		}
		
		/*Si la hauteur dépasse un seuil de 120, on ajoute le panneau supplémentaire*/
		if(e.getComponent().getHeight() > 120) {
			/*Crée un nouveau panel VLC pour contenir 
			 * tout ce qu'on a de la frame*/
			JPanel VLC = new JPanel();
			VLC.setLayout(new BorderLayout());
			VLC.add(m_playPauseB, BorderLayout.WEST);
			VLC.add(m_soundP);
			
			/*Utilise une JScrollPane contenant une JList 
			 *pour simuler le panneau supplémentaire*/
			JList list = new JList();
			JScrollPane listMusic = new JScrollPane(list);
			m_frame.getContentPane().removeAll();//Il est important d'enlever tous les composants de la frame avant
			m_frame.add(VLC, BorderLayout.NORTH);
			m_frame.add(listMusic);
			m_frame.setVisible(true);
		}else {/*Si la hauteur est inférieure au seuil on garde sa taille*/
			m_frame.getContentPane().removeAll();
			m_frame.add(m_soundP, BorderLayout.CENTER);
			m_frame.add(m_playPauseB, BorderLayout.WEST);
		}
		
	}
}
