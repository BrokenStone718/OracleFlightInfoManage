package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Flight;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class HBHselected extends JInternalFrame {
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HBHselected frame = new HBHselected();
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
	public HBHselected() {
		setBounds(100, 100, 527, 419);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 495, 301);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u822A\u73ED\u53F7", "\u822A\u7AD9\u697C", "\u5019\u673A\u5385", "\u673A\u957F\u59D3\u540D", "\u662F\u5426\u5EF6\u8BEF", "\u9884\u8BA1\u98DE\u884C\u65F6\u95F4", "\u59CB\u53D1\u57CE\u5E02", "\u76EE\u7684\u5730"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(HBHselected.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton.setBounds(198, 332, 97, 36);
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
		List<Flight> b = UserDAO.getList();
		if(b==null) {
			JOptionPane.showMessageDialog(null, "无此航班信息");
		}else {
			for(Flight f:b) {
				Vector v = new Vector<>();
				v.add(f.getHBH());
				v.add(f.getHZL());
				v.add(f.getHJT());
				v.add(f.getJZXM());
				v.add(f.getYJFXSJ());
				v.add(f.getSFYW());
				v.add(f.getSFCS());
				v.add(f.getMDD());
				dtm.addRow(v);
			}
		}
	}
}
