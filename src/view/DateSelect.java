package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DateSelect extends JInternalFrame {
	private JTextField DATEtxt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateSelect frame = new DateSelect();
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
	public DateSelect() {
		setTitle("\u6309\u8D77\u98DE\u65F6\u95F4\u67E5\u8BE2");
		setBounds(100, 100, 651, 477);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u8D77\u98DE\u65F6\u95F4");
		lblNewLabel.setIcon(new ImageIcon(DateSelect.class.getResource("/image/\u5EF6\u8BEF.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(103, 31, 120, 28);
		getContentPane().add(lblNewLabel);
		
		DATEtxt = new JTextField();
		DATEtxt.setBounds(273, 29, 199, 34);
		getContentPane().add(DATEtxt);
		DATEtxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 619, 278);
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
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setIcon(new ImageIcon(DateSelect.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton.setBounds(379, 381, 149, 43);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DATEselectActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DateSelect.class.getResource("/image/\u5EF6\u8BEF.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(103, 381, 140, 40);
		getContentPane().add(btnNewButton_1);
		

	}


	//按时间查询事件
	protected void DATEselectActionPerformed(ActionEvent e) {
		String dt = DATEtxt.getText();
		if(StringTools.isEmpty(dt)) {
			JOptionPane.showMessageDialog(null, "不能为空");
			return;
		}
		if(!StringTools.rexCheckDate(dt)) {
			JOptionPane.showMessageDialog(null, "日期格式错误");
			return;
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//设置成0行
		List<Flight> b = UserDAO.getDATEList(dt);
		if(b.size()==0) {
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
