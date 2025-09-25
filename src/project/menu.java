package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void invisiable() {
		this.setVisible(false);
	}
	public void visiable() {
		this.setVisible(true);
	}
	public menu() {
		setTitle("刀劍神域Online");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 636, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setBounds(0, 0, 636, 463);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setLocation(81, 91);
		lblTitle.setSize(460, 120);
		
		ImageIcon imageIcon1 = new ImageIcon(menu.class.getResource("/project/title.png"));
		Image image1 = imageIcon1.getImage(); //transform it
		Image newimg1 = image1.getScaledInstance(460, 120, java.awt.Image.SCALE_SMOOTH);
		imageIcon1 = new ImageIcon(newimg1); // transform it back
		lblTitle.setIcon(imageIcon1);
		panel.add(lblTitle);
		
		JButton btnStartGame = new JButton("開始遊戲");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				App.Choose_Character();
			}
		});
		btnStartGame.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnStartGame.setIcon(null);
		btnStartGame.setBackground(new Color(255, 255, 255));
		btnStartGame.setBounds(253, 237, 123, 48);
		panel.add(btnStartGame);
		
		JButton btnShop = new JButton("商店");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				App.Shop();
			}
		});
		btnShop.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnShop.setBackground(Color.WHITE);
		btnShop.setBounds(253, 301, 123, 48);
		panel.add(btnShop);
		
		JButton btnExitGame = new JButton("退出遊戲");
		btnExitGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnExitGame.setBackground(Color.WHITE);
		btnExitGame.setBounds(253, 365, 123, 48);
		panel.add(btnExitGame);
		
		ImageIcon imageIcon = new ImageIcon(menu.class.getResource("/project/menu_background.png"));
		Image image = imageIcon.getImage(); //transform it
		Image newimg = image.getScaledInstance(650, 506, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg); // transform it back
		lblBackground.setIcon(imageIcon);
		panel.add(lblBackground);
		
	}
}
