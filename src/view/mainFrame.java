package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import utils.StringTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField pwdText;
	private JComboBox IDconfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setTitle("\u822A\u73ED\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 466);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel backGround = new JLabel("New label");
		backGround.setIcon(new ImageIcon(mainFrame.class.getResource("/image/\u80CC\u666F.jpg")));
		backGround.setBounds(0, 0, 582, 144);
		contentPane.add(backGround);
		
		JLabel userName = new JLabel("\u7528\u6237\u540D");
		userName.setFont(new Font("宋体", Font.PLAIN, 16));
		userName.setIcon(new ImageIcon(mainFrame.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		userName.setBounds(77, 174, 81, 32);
		contentPane.add(userName);
		
		userText = new JTextField();
		userText.setBounds(168, 176, 239, 32);
		contentPane.add(userText);
		userText.setColumns(10);
		
		JLabel passWord = new JLabel("\u5BC6\u7801");
		passWord.setIcon(new ImageIcon(mainFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		passWord.setFont(new Font("宋体", Font.PLAIN, 14));
		passWord.setBounds(96, 248, 63, 21);
		contentPane.add(passWord);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(168, 243, 239, 32);
		contentPane.add(pwdText);
		ButtonGroup bp = new ButtonGroup();
		JButton loginButton = new JButton("\u767B\u9646");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginButton.setIcon(new ImageIcon(mainFrame.class.getResource("/image/\u767B\u9646.png")));
		loginButton.setBounds(123, 359, 113, 32);
		contentPane.add(loginButton);
		JButton regButton = new JButton("\u6CE8\u518C");
		regButton.setIcon(new ImageIcon(mainFrame.class.getResource("/image/\u6CE8\u518C.png")));
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regActionPerformed(e);
			}
		});
		regButton.setBounds(310, 359, 113, 32);
		contentPane.add(regButton);
		IDconfirm = new JComboBox();
		IDconfirm.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u7528\u6237"}));
		IDconfirm.setToolTipText("");
		IDconfirm.setBounds(234, 309, 91, 23);
		contentPane.add(IDconfirm);
	}
	
	//登陆事件处理
	protected void loginActionPerformed(ActionEvent e) {
		String username = userText.getText();
		String pwd = new String(pwdText.getPassword());
		if(StringTools.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(!StringTools.rexCheckUserName(username)) {
			JOptionPane.showMessageDialog(null, "用户名不规范，格式为5-16位数字和字母");
			return;
		}
		if(StringTools.isEmpty(pwd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(!StringTools.rexCheckPassword(pwd)) {
			JOptionPane.showMessageDialog(null, "密码不规范，格式为5-18位数字和字母");
			return;
		}
		String authorization = IDconfirm.getSelectedItem().toString();
		if(authorization.equals("管理员")) {//管理员登陆
			int i = UserDAO.adminlogin(username,pwd);
			if(i!=0) {//登陆成功
				JOptionPane.showMessageDialog(null, "登陆成功");
				this.dispose();
				new adminFrame().setVisible(true);
			}else {//登陆失败
				JOptionPane.showMessageDialog(null, "登陆失败");
			}
			
		}else {//普通用户登陆
			
			int i = UserDAO.userlogin(username,pwd);
			if(i!=0) {//登陆成功
				JOptionPane.showMessageDialog(null, "登陆成功");
				this.dispose();
				new userFrame().setVisible(true);
			}else {//登陆失败
				JOptionPane.showMessageDialog(null, "登陆失败");
			} 
		}
		
	}
	
	//注册事件
	protected void regActionPerformed(ActionEvent e) {
		this.dispose();
		new regFrame().setVisible(true);
		
	}
}
