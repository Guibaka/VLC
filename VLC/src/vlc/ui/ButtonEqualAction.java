package vlc.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ButtonEqualAction implements ActionListener{
	JFrame m_frame;
	JPanel m_soundP;
	JPanel m_playPauseB;
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
		if(!extended) {
			int width = m_frame.getWidth();
			JPanel VLC = new JPanel();
			VLC.setLayout(new BorderLayout());
			VLC.add(m_playPauseB, BorderLayout.WEST);
			VLC.add(m_soundP);
			JList listMusic = new JList();
			JSplitPane sl = new JSplitPane(JSplitPane.VERTICAL_SPLIT, VLC, listMusic);
			m_frame.getContentPane().removeAll();
			m_frame.add(sl);
			m_frame.setSize(width, 400);
			m_frame.setVisible(true);
			extended = true;
		}else {
			m_frame.getContentPane().removeAll();
			m_frame.add(m_soundP, BorderLayout.CENTER);
			m_frame.add(m_playPauseB, BorderLayout.WEST);
			m_frame.pack();
			extended = false;
		}
	}

}
