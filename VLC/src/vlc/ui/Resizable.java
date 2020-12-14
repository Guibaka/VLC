package vlc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Resizable extends ComponentAdapter {
	JFrame m_frame;
	JPanel m_soundP;
	JPanel m_playPauseB;
	int m_height;

	Resizable(JFrame f, JPanel soundP, JPanel playPauseB, int height) {
		m_frame = f;
		m_soundP = soundP;
		m_playPauseB = playPauseB;
		m_height = height;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		//System.out.println("Before resize : " + e.getComponent().getSize().getHeight());
		//super.componentResized(e);
		//System.out.println("After resize : " + e.getComponent().getSize().getHeight());
		if(e.getComponent().getHeight() > 120) {
			m_frame.setSize(e.getComponent().getWidth(), 200); //ici
			JPanel VLC = new JPanel();
			VLC.setLayout(new BorderLayout());
			VLC.add(m_playPauseB, BorderLayout.WEST);
			VLC.add(m_soundP);
			JList listMusic = new JList();
			JSplitPane sl = new JSplitPane(JSplitPane.VERTICAL_SPLIT, VLC, listMusic);
			m_frame.getContentPane().removeAll();
			m_frame.add(sl);
			m_frame.setVisible(true);
		}else {
			m_frame.getContentPane().removeAll();
			m_frame.add(m_soundP, BorderLayout.CENTER);
			m_frame.add(m_playPauseB, BorderLayout.WEST);
		}
	}
}
