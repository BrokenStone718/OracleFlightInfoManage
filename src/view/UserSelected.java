package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Userinfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSelected extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSelected frame = new UserSelected();
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
	public UserSelected() {
		setBounds(100, 100, 450, 357);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 418, 247);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID","\u7528\u6237\u540D", "\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(UserSelected.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton.setBounds(151, 279, 122, 28);
		getContentPane().add(btnNewButton);
		fillTable();

	}
	//返回事件
	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		
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
}
