package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.UserDAO;
import utils.StringTools;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class insertFrame extends JInternalFrame {
	private JTextField HBtxt;
	private JTextField HJtxt;
	private JTextField HZtxt;
	private JTextField JZtxt;
	private JTextField YWtxt;
	private JTextField SCtxt;
	private JTextField ECtxt;
	private JTextField SDtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertFrame frame = new insertFrame();
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
	public insertFrame() {
		setTitle("\u5F55\u5165\u822A\u73ED\u53F7");
		setBounds(100, 100, 471, 481);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u822A\u73ED\u53F7");
		lblNewLabel.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 54, 76, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5019\u673A\u5385");
		lblNewLabel_1.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(67, 96, 76, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u822A\u7AD9\u697C");
		lblNewLabel_2.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(67, 131, 76, 22);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u673A\u957F\u59D3\u540D");
		lblNewLabel_3.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u673A\u957F.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(57, 168, 86, 22);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u662F\u5426\u5EF6\u8BEF");
		lblNewLabel_4.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u5EF6\u8BEF.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(57, 206, 86, 22);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u59CB\u53D1\u57CE\u5E02");
		lblNewLabel_5.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u57CE  \u5E02.png")));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(57, 245, 86, 22);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel_6.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u57CE  \u5E02.png")));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(67, 283, 76, 22);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u9884\u8BA1\u8D77\u98DE\u65F6\u95F4");
		lblNewLabel_7.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u5EF6\u8BEF.png")));
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(24, 317, 119, 22);
		getContentPane().add(lblNewLabel_7);
		
		HBtxt = new JTextField();
		HBtxt.setBounds(166, 52, 190, 21);
		getContentPane().add(HBtxt);
		HBtxt.setColumns(10);
		
		HJtxt = new JTextField();
		HJtxt.setColumns(10);
		HJtxt.setBounds(166, 90, 190, 21);
		getContentPane().add(HJtxt);
		
		HZtxt = new JTextField();
		HZtxt.setColumns(10);
		HZtxt.setBounds(166, 126, 190, 21);
		getContentPane().add(HZtxt);
		
		JZtxt = new JTextField();
		JZtxt.setColumns(10);
		JZtxt.setBounds(166, 163, 190, 21);
		getContentPane().add(JZtxt);
		
		YWtxt = new JTextField();
		YWtxt.setColumns(10);
		YWtxt.setBounds(166, 201, 190, 21);
		getContentPane().add(YWtxt);
		
		SCtxt = new JTextField();
		SCtxt.setColumns(10);
		SCtxt.setBounds(166, 240, 190, 21);
		getContentPane().add(SCtxt);
		
		ECtxt = new JTextField();
		ECtxt.setColumns(10);
		ECtxt.setBounds(166, 282, 190, 21);
		getContentPane().add(ECtxt);
		
		SDtxt = new JTextField();
		SDtxt.setColumns(10);
		SDtxt.setBounds(166, 318, 190, 21);
		getContentPane().add(SDtxt);
		
		JButton btnNewButton = new JButton("\u5F55\u5165");
		btnNewButton.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u5F55\u5165.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luruActionPerformed(e);
			}
		});
		btnNewButton.setBounds(39, 377, 119, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(insertFrame.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setBounds(274, 377, 119, 35);
		getContentPane().add(btnNewButton_1);

	}

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void luruActionPerformed(ActionEvent e) {
		String HB = HBtxt.getText();
		String HJ = HJtxt.getText();
		String HZ = HZtxt.getText();
		String JZ = JZtxt.getText();
		String YW = YWtxt.getText();
		String SC = SCtxt.getText();
		String EC = ECtxt.getText();
		String SD = SDtxt.getText();
		if(StringTools.isEmpty(HB)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckHBH(HB)) {
			JOptionPane.showMessageDialog(null, "航班号格式错误");
			return;
		}
		if(StringTools.isEmpty(HJ)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckHJT(HJ)) {
			JOptionPane.showMessageDialog(null, "候机厅格式错误");
			return;
		}
		if(StringTools.isEmpty(HZ)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckHZL(HZ)) {
			JOptionPane.showMessageDialog(null, "航站楼格式错误");
			return;
		}
		if(StringTools.isEmpty(JZ)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckJZXM(JZ)) {
			JOptionPane.showMessageDialog(null, "机长姓名格式错误");
			return;
		}
		if(StringTools.isEmpty(YW)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckSFYW(YW)) {
			JOptionPane.showMessageDialog(null, "是否延误格式错误");
			return;
		}
		if(StringTools.isEmpty(SC)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckCity(SC)) {
			JOptionPane.showMessageDialog(null, "城市格式错误");
			return;
		}
		if(StringTools.isEmpty(EC)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckCity(EC)) {
			JOptionPane.showMessageDialog(null, "城市格式错误");
			return;
		}
		if(StringTools.isEmpty(SD)) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return;
		}
		if(!StringTools.rexCheckDate(SD)) {
			JOptionPane.showMessageDialog(null, "日期格式错误");
			return;
		}
		int i = UserDAO.insert(HB,HJ,HZ,JZ,YW,SC,EC,SD);
		if(i!=0) {
			JOptionPane.showMessageDialog(null, "录入成功");
			HBtxt.setText("");
			HJtxt.setText("");
			HZtxt.setText("");
			JZtxt.setText("");
			YWtxt.setText("");
			SCtxt.setText("");
			ECtxt.setText("");
			SDtxt.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "录入失败，该航班信息可能已经存在");
		}
		
		
	}
}
