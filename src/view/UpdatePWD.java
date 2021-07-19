package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.UserDAO;
import User.Userinfo;
import utils.StringTools;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdatePWD extends JInternalFrame {
	private JTextField Newpwd;
	private JTextField Oldpwd;
	private JTextField Newpwd2;
	private JTextField Username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePWD frame = new UpdatePWD();
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
	public UpdatePWD() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 16));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 602, 486);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65E7\u5BC6\u7801");
		lblNewLabel.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(132, 135, 74, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(132, 206, 74, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u786E\u8BA4\u65B0\u5BC6\u7801");
		lblNewLabel_2.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(76, 272, 122, 23);
		getContentPane().add(lblNewLabel_2);
		
		Newpwd = new JTextField();
		Newpwd.setColumns(10);
		Newpwd.setBounds(208, 201, 189, 34);
		getContentPane().add(Newpwd);
		
		Oldpwd = new JTextField();
		Oldpwd.setColumns(10);
		Oldpwd.setBounds(208, 130, 189, 34);
		getContentPane().add(Oldpwd);
		
		Newpwd2 = new JTextField();
		Newpwd2.setColumns(10);
		Newpwd2.setBounds(208, 267, 189, 34);
		getContentPane().add(Newpwd2);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u4FEE \u6539.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepwdActionPerformed(e);
			}
		});
		btnNewButton.setBounds(106, 348, 122, 41);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(347, 348, 122, 41);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_3.setIcon(new ImageIcon(UpdatePWD.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(132, 70, 74, 23);
		getContentPane().add(lblNewLabel_3);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(208, 65, 189, 34);
		getContentPane().add(Username);

	}

	protected void updatepwdActionPerformed(ActionEvent e) {
		String username = Username.getText();
		String oldpwd = Oldpwd.getText();
		String newpwd = Newpwd.getText();
		String newpwd2 = Newpwd2.getText();
		if(StringTools.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringTools.isEmpty(oldpwd)) {
			JOptionPane.showMessageDialog(null, "原密码不能为空");
			return;
		}
		if(StringTools.isEmpty(newpwd)) {
			JOptionPane.showMessageDialog(null, "新密码不能为空");
			return;
		}
		if(!StringTools.rexCheckPassword(newpwd)) {
			JOptionPane.showMessageDialog(null, "新密码不规范，格式为5-18位数字和字母");
			return;
		}
		if(StringTools.isEmpty(newpwd2)) {
			JOptionPane.showMessageDialog(null, "新密码不能为空");
			return;
		}
		if(!StringTools.rexCheckPassword(newpwd2)) {
			JOptionPane.showMessageDialog(null, "新密码不规范，格式为5-18位数字和字母");
			return;
		}
		if(!newpwd.equals(newpwd2)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致");
			return;
		}
		int j = UserDAO.confirm(username,oldpwd);
		if(j==0) {
			JOptionPane.showMessageDialog(null, "用户名与原密码不一致");
			return;
		}else {
			int i = UserDAO.updateUserinfo(username,newpwd);
			if(i!=0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}


		
	}

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		
	}
}
