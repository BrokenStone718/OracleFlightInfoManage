package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Flight;
import User.Userinfo;
import utils.StringTools;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class DeleteUserFrame extends JInternalFrame {
	private JTextField pwdTXT;
	private JTextField usernameTXT;
	private JTable table;
	private JTextField idTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUserFrame frame = new DeleteUserFrame();
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
	public DeleteUserFrame() {
		setBounds(100, 100, 430, 513);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 397, 294);
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
		lblNewLabel.setIcon(new ImageIcon(DeleteUserFrame.class.getResource("/image/\u7528\u6237\u540D (1).png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 321, 68, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(DeleteUserFrame.class.getResource("/image/\u5BC6 \u7801.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(227, 329, 58, 21);
		getContentPane().add(lblNewLabel_1);
		
		pwdTXT = new JTextField();
		pwdTXT.setColumns(10);
		pwdTXT.setBounds(285, 323, 103, 26);
		getContentPane().add(pwdTXT);
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		usernameTXT.setBounds(77, 323, 103, 26);
		getContentPane().add(usernameTXT);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUserActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(DeleteUserFrame.class.getResource("/image/\u5220  \u9664 1.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(84, 424, 96, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DeleteUserFrame.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(241, 424, 96, 38);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(51, 370, 27, 29);
		getContentPane().add(lblNewLabel_2);
		
		idTXT = new JTextField();
		idTXT.setColumns(10);
		idTXT.setBounds(77, 374, 103, 26);
		getContentPane().add(idTXT);
		fillTable();
		

	}
	//删除用户信息事件
	protected void deleteUserActionPerformed(ActionEvent e) {
		String username = usernameTXT.getText();
		String pwd = pwdTXT.getText();
		
		if(StringTools.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的数据");
			return;
		}
		int input = JOptionPane.showConfirmDialog(null, "你确定要删除吗？");
		if(input == 0) {
			int i = UserDAO.deleteUserInfo(username,pwd);
			if(i!=0) {
				JOptionPane.showMessageDialog(null, "删除成功");
				fillTable();
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}else{
			return;
		}
		
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

	protected void UserMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();
		usernameTXT.setText((String)table.getValueAt(row, 1));
		pwdTXT.setText((String)table.getValueAt(row, 2));
		idTXT.setText((String)table.getValueAt(row, 0));
		
	}

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		
	}
}
