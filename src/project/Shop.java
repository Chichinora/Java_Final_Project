package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
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
	
	public String result = null;
	/**
	 * Create the frame.
	 */
	public Shop() {
		setTitle("刀劍神域Online");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 328);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelContent = new JLabel("<html>請選擇你要購買的角色 (輸入0回到主選單)<br />\r\n角色列表：<br />\r\n(1) Kirito (300金幣)<br />\r\n(2) Shino (200金幣)");
		labelContent.setForeground(new Color(255, 255, 255));
		labelContent.setBackground(new Color(128, 64, 0));
		labelContent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		labelContent.setBounds(20, 52, 213, 145);
		labelContent.setOpaque(true);
		contentPane.add(labelContent);
		
		JLabel lblNewLabel = new JLabel(": "+App.money);
		ImageIcon imageIcon = new ImageIcon(menu.class.getResource("/project/dollar.png"));
		Image image = imageIcon.getImage(); //transform it
		Image newimg = image.getScaledInstance(16, 16, java.awt.Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(newimg); // transform it back
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setIcon(new ImageIcon(Shop.class.getResource("/project/dollar.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 10, 127, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(128, 64, 0));
		textField.setBounds(20, 207, 213, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("確定");
		btnConfirm.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				result = textField.getText();
				textField.setText("");
				App.result = result;
				App.Judge();
			}
		});
		btnConfirm.setBounds(20, 260, 85, 21);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("取消");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnCancel.setBounds(148, 260, 85, 21);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon imageIcon1 = new ImageIcon(menu.class.getResource("/project/direction-sign.png"));
		Image image1 = imageIcon1.getImage(); //transform it
		Image newimg1 = image1.getScaledInstance(460, 120, java.awt.Image.SCALE_SMOOTH);
		imageIcon1 = new ImageIcon(newimg1); // transform it back
		lblNewLabel_1.setIcon(imageIcon1);
		//lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(10, 10, 104, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(Shop.class.getResource("/project/shop.jpg")));
		labelBackground.setBounds(0, 0, 486, 291);
		contentPane.add(labelBackground);
		
		
		
	}
}
