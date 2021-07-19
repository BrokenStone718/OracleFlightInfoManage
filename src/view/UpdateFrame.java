package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.UserDAO;
import User.Flight;
import utils.StringTools;

public class UpdateFrame extends JInternalFrame {
	private JTable table;
	private JTextField HBHtxt;
	private JTextField HZLtxt;
	private JTextField HJTtxt;
	private JTextField JZXMtxt;
	private JTextField YJFXSJtxt;
	private JTextField SFYWtxt;
	private JTextField SFCStxt;
	private JTextField MDDtxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
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
	public UpdateFrame() {
		setTitle("\u4FEE\u6539\u822A\u73ED\u4FE1\u606F");
		setBounds(100, 100, 624, 537);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 592, 250);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FlightMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u822A\u73ED\u53F7", "\u822A\u7AD9\u697C", "\u5019\u673A\u5385", "\u673A\u957F\u59D3\u540D", "\u9884\u8BA1\u98DE\u884C\u65F6\u95F4", "\u662F\u5426\u5EF6\u8BEF", "\u59CB\u53D1\u57CE\u5E02", "\u76EE\u7684\u5730"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u822A\u73ED\u53F7");
		lblNewLabel.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 277, 77, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u822A\u7AD9\u697C");
		lblNewLabel_1.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 312, 67, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5019\u673A\u5385");
		lblNewLabel_2.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 354, 77, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u673A\u957F\u59D3\u540D");
		lblNewLabel_3.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u673A\u957F.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 394, 87, 21);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u9884\u8BA1\u98DE\u884C\u65F6\u95F4");
		lblNewLabel_4.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u65F6 \u95F4.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(324, 277, 106, 21);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u662F\u5426\u5EF6\u8BEF");
		lblNewLabel_5.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u5EF6\u8BEF.png")));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(355, 312, 87, 21);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u59CB\u53D1\u57CE\u5E02");
		lblNewLabel_6.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u57CE  \u5E02.png")));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(355, 354, 87, 21);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel_7.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u57CE  \u5E02.png")));
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(365, 394, 77, 21);
		getContentPane().add(lblNewLabel_7);
		
		HBHtxt = new JTextField();
		HBHtxt.setBounds(116, 277, 120, 21);
		getContentPane().add(HBHtxt);
		HBHtxt.setColumns(10);
		HBHtxt.setEditable(false);
		
		HZLtxt = new JTextField();
		HZLtxt.setColumns(10);
		HZLtxt.setBounds(116, 312, 120, 21);
		getContentPane().add(HZLtxt);
		
		HJTtxt = new JTextField();
		HJTtxt.setColumns(10);
		HJTtxt.setBounds(116, 354, 120, 21);
		getContentPane().add(HJTtxt);
		
		JZXMtxt = new JTextField();
		JZXMtxt.setColumns(10);
		JZXMtxt.setBounds(116, 394, 120, 21);
		getContentPane().add(JZXMtxt);
		
		YJFXSJtxt = new JTextField();
		YJFXSJtxt.setColumns(10);
		YJFXSJtxt.setBounds(452, 277, 120, 21);
		getContentPane().add(YJFXSJtxt);
		
		SFYWtxt = new JTextField();
		SFYWtxt.setColumns(10);
		SFYWtxt.setBounds(452, 312, 120, 21);
		getContentPane().add(SFYWtxt);
		
		SFCStxt = new JTextField();
		SFCStxt.setColumns(10);
		SFCStxt.setBounds(452, 354, 120, 21);
		getContentPane().add(SFCStxt);
		
		MDDtxt = new JTextField();
		MDDtxt.setColumns(10);
		MDDtxt.setBounds(452, 394, 120, 21);
		getContentPane().add(MDDtxt);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UpdateFrame.class.getResource("/image/\u4FEE \u6539.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(116, 448, 125, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DeleteFrame.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(355, 448, 125, 39);
		getContentPane().add(btnNewButton_1);
		fillTable();
	}
	protected void updateActionPerformed(ActionEvent e) {
		String HBH = HBHtxt.getText();
		String HZL = HZLtxt.getText();
		String HJT = HJTtxt.getText();
		String JZXM = JZXMtxt.getText();
		String YJFXSJ = YJFXSJtxt.getText();
		String SFYW = SFYWtxt.getText();
		String SFCS = SFCStxt.getText();
		String MDD = MDDtxt.getText();
		if(StringTools.isEmpty(HBH)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据");
			return;
		}
		int input = JOptionPane.showConfirmDialog(null, "你确定要修改吗？");
		if(input == 0) {
			int i = UserDAO.update(HBH,HZL,HJT,JZXM,YJFXSJ,SFYW,SFCS,MDD);
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

	protected void FlightMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();//获得行号
		HBHtxt.setText((String)table.getValueAt(row, 0));
		HZLtxt.setText((String)table.getValueAt(row, 1));
		HJTtxt.setText((String)table.getValueAt(row, 2));
		JZXMtxt.setText((String)table.getValueAt(row, 3));
		YJFXSJtxt.setText((String)table.getValueAt(row, 4));
		SFYWtxt.setText((String)table.getValueAt(row, 5));
		SFCStxt.setText((String)table.getValueAt(row, 6));
		MDDtxt.setText((String)table.getValueAt(row, 7));
		
	}

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
