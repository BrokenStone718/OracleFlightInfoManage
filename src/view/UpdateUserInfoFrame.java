package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Userinfo;
import utils.StringTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class UpdateUserInfoFrame extends JInternalFrame {
	private JTable table;
	private JTextField usernameTXT;
	private JTextField pwdTXT;
	private JTextField idTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserInfoFrame frame = new UpdateUserInfoFrame();
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
	public UpdateUserInfoFrame() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		setBounds(100, 100, 430, 437);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 398, 221);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","\u7528\u6237\u540D", "\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setIcon(new ImageIcon(UpdateUserInfoFrame.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 239, 68, 29);
		getContentPane().add(lblNewLabel);
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		usernameTXT.setBounds(87, 241, 103, 26);
		getContentPane().add(usernameTXT);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(UpdateUserInfoFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(234, 247, 58, 21);
		getContentPane().add(lblNewLabel_1);
		
		pwdTXT = new JTextField();
		pwdTXT.setColumns(10);
		pwdTXT.setBounds(293, 241, 103, 26);
		getContentPane().add(pwdTXT);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserInfoActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UpdateUserInfoFrame.class.getResource("/image/\u4FEE \u6539.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(58, 353, 103, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UpdateUserInfoFrame.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(258, 353, 103, 29);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(57, 294, 31, 29);
		getContentPane().add(lblNewLabel_2);
		
		idTXT = new JTextField();
		idTXT.setColumns(10);
		idTXT.setBounds(87, 298, 103, 26);
		idTXT.setEditable(false);
		getContentPane().add(idTXT);
		fillTable();
	}

	protected void addUserInfoActionPerformed(ActionEvent e) {
		String username = usernameTXT.getText();
		String pwd = pwdTXT.getText();
		String id = idTXT.getText();
		
		if(StringTools.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据");
			return;
		}
		int input = JOptionPane.showConfirmDialog(null, "你确定要修改吗？");
		if(input == 0) {
			int i = UserDAO.updateUserInfo(username,pwd,id);
			if(i!=0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				fillTable();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}else{
			return;
		}	
		
	}

	protected void UserMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();
		usernameTXT.setText((String)table.getValueAt(row, 1));
		pwdTXT.setText((String)table.getValueAt(row, 2));
		idTXT.setText((String)table.getValueAt(row, 0));
		
	}

	public void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//设置成0行
		List<Userinfo> b = UserDAO.getUserList();
		if(b==null) {
			JOptionPane.showMessageDialog(null, "无用户信息");
		}else {
			for(Userinfo u:b) {
				Vector v = new Vector<>();
				v.add(u.getUserID());
				v.add(u.getUsername());
				v.add(u.getPassword());
				dtm.addRow(v);
			}
		}
	}
	//返回事件
	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
	}
}
