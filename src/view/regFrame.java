package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userTXT;
	private JTextField pwdTXT;
	private JTextField confirmTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regFrame frame = new regFrame();
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
	public regFrame() {
		setForeground(SystemColor.activeCaption);
		setTitle("\u6CE8\u518C");
		setIconImage(Toolkit.getDefaultToolkit().getImage(regFrame.class.getResource("/image/\u80CC\u666F.jpg"))); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 382);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setIcon(new ImageIcon(regFrame.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel.setBounds(87, 58, 65, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(regFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(102, 125, 50, 31);
		contentPane.add(lblNewLabel_1);
		
		userTXT = new JTextField();
		userTXT.setBounds(162, 61, 174, 26);
		contentPane.add(userTXT);
		userTXT.setColumns(10);
		
		pwdTXT = new JTextField();
		pwdTXT.setColumns(10);
		pwdTXT.setBounds(162, 128, 174, 26);
		contentPane.add(pwdTXT);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u518D\u6B21\u786E\u5B9A\u5BC6\u7801");
		lblNewLabel_1_1.setIcon(new ImageIcon(regFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(40, 193, 112, 31);
		contentPane.add(lblNewLabel_1_1);
		
		confirmTXT = new JTextField();
		confirmTXT.setColumns(10);
		confirmTXT.setBounds(162, 196, 174, 26);
		contentPane.add(confirmTXT);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setIcon(new ImageIcon(regFrame.class.getResource("/image/\u6CE8\u518C.png")));
		btnNewButton.setBounds(97, 263, 97, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetActionPerformed();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setIcon(new ImageIcon(regFrame.class.getResource("/image/\u91CD\u7F6E.png")));
		btnNewButton_1.setBounds(278, 263, 97, 38);
		contentPane.add(btnNewButton_1);
	}

	protected void reSetActionPerformed() {
		userTXT.setText("");
		pwdTXT.setText("");
		confirmTXT.setText("");	
	}

	protected void regActionPerformed(ActionEvent e) {
		String username = userTXT.getText();
		String pwd = pwdTXT.getText();
		String pwd2 = confirmTXT.getText();
		if(pwd.equals(pwd2)) {
			int i = UserDAO.reg(username,pwd);
			if(i!=0) {
				JOptionPane.showMessageDialog(null, "注册成功");
				this.dispose();
				new mainFrame().setVisible(true);
			}
		}else {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致");
		}
		
	}
}
