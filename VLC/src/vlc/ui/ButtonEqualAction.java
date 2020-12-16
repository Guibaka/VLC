package vlc.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class ButtonEqualAction implements ActionListener{
	JFrame m_frame;
	/*m_playPauseB Panel de gauche si l'on découpe verticalement 
	 * à partir du Panel Box contenant tous les boutons à gauche*/
	JPanel m_playPauseB;
	
	/*m_soundP Panel de droite contenant le Panel MultiVLC et Sound*/
	JPanel m_soundP; 
	
	/*Servant à déterminer si on doit étendre la fenêtre ou non*/	
	boolean extended;
	
	ButtonEqualAction(JFrame frame, JPanel soundP, JPanel playPauseB){
		m_frame = frame;
		m_soundP = soundP;
		m_playPauseB = playPauseB;
		extended = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!extended) { // cas où on doit étendre la JFrame
			int width = m_frame.getWidth();
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
			m_frame.getContentPane().removeAll(); //Il est important d'enlever tous les composants de la frame avant
			m_frame.add(VLC, BorderLayout.NORTH);
			m_frame.add(listMusic);
			m_frame.setSize(width, 400);
			
			m_frame.setVisible(true);
			extended = true;
		}else { // cas où on doit enlever le panneau supplémentaire
			m_frame.getContentPane().removeAll();
			m_frame.add(m_soundP, BorderLayout.CENTER);
			m_frame.add(m_playPauseB, BorderLayout.WEST);
			m_frame.pack();
			extended = false;
		}
	}

}
