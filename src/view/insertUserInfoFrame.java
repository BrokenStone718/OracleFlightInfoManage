package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.UserDAO;
import utils.StringTools;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertUserInfoFrame extends JInternalFrame {
	private JTextField userTXT;
	private JTextField pwdTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertUserInfoFrame frame = new insertUserInfoFrame();
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
	public insertUserInfoFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setIcon(new ImageIcon(insertUserInfoFrame.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(79, 37, 73, 25);
		getContentPane().add(lblNewLabel);
		
		userTXT = new JTextField();
		userTXT.setBounds(156, 33, 137, 33);
		getContentPane().add(userTXT);
		userTXT.setColumns(10);
		
		pwdTXT = new JTextField();
		pwdTXT.setColumns(10);
		pwdTXT.setBounds(156, 107, 137, 33);
		getContentPane().add(pwdTXT);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(insertUserInfoFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(94, 111, 58, 25);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u5F55\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserInfoActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(insertUserInfoFrame.class.getResource("/image/\u5F55\u5165.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(80, 205, 97, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(insertUserInfoFrame.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(262, 205, 97, 33);
		getContentPane().add(btnNewButton_1);

	}

	//录入用户信息
	protected void addUserInfoActionPerformed(ActionEvent e) {
		String username = userTXT.getText();
		String pwd = pwdTXT.getText();
		if(StringTools.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(!StringTools.rexCheckUserName(username)) {
			JOptionPane.showMessageDialog(null, "用户名格式不规范");
			return;
		}
		if(StringTools.isEmpty(pwd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(!StringTools.rexCheckPassword(pwd)) {
			JOptionPane.showMessageDialog(null, "密码格式不规范");
			return;
		}
		
		int i = UserDAO.insertUserInfo(username,pwd);
		if(i!=0) {
			JOptionPane.showMessageDialog(null, "录入成功");
			userTXT.setText("");
			pwdTXT.setText("");

		}else {
			JOptionPane.showMessageDialog(null, "录入失败，该用户信息可能已经存在");
		}
		
	}

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
	}

}
