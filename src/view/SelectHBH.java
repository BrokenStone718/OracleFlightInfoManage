package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Flight;
import utils.StringTools;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SelectHBH extends JInternalFrame {
	private JTextField HBHtxt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectHBH frame = new SelectHBH();
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
	public SelectHBH() {
		setTitle("\u6309\u822A\u73ED\u53F7\u67E5\u8BE2");
		setBounds(100, 100, 598, 486);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 567, 290);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u822A\u73ED\u53F7", "\u822A\u7AD9\u697C", "\u5019\u673A\u5385", "\u673A\u957F\u59D3\u540D", "\u9884\u8BA1\u98DE\u884C\u65F6\u95F4", "\u662F\u5426\u5EF6\u8BEF", "\u59CB\u53D1\u57CE\u5E02", "\u76EE\u7684\u5730"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4F60\u8981\u67E5\u8BE2\u7684\u822A\u73ED\u53F7");
		lblNewLabel.setIcon(new ImageIcon(SelectHBH.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(55, 21, 172, 40);
		getContentPane().add(lblNewLabel);
		
		HBHtxt = new JTextField();
		HBHtxt.setBounds(238, 27, 172, 30);
		getContentPane().add(HBHtxt);
		HBHtxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(SelectHBH.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton.setBounds(348, 389, 140, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setIcon(new ImageIcon(SelectHBH.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HBHselectActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(96, 389, 140, 40);
		getContentPane().add(btnNewButton_1);

	}

	protected void HBHselectActionPerformed(ActionEvent e) {
		String hbh = HBHtxt.getText();
		if(StringTools.isEmpty(hbh)) {
			JOptionPane.showMessageDialog(null, "不能为空");
			return;
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//设置成0行
		List<Flight> b = UserDAO.getHBHList(hbh);
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

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		FlightSelect fs = new FlightSelect();
		fs.setVisible(true);
		userFrame.table.add(fs);
	}
}
