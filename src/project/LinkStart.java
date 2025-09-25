package project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class LinkStart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkStart frame = new LinkStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void invisiable() {
		this.setVisible(false);
	}
	public void visiable() {
		this.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public LinkStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 360);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 626, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon(LinkStart.class.getResource("/project/linkstart.gif")));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(0, 0, 626, 323);		
		panel.add(label1);	
		
		
	}
}
