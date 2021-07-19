package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FlightSelect extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightSelect frame = new FlightSelect();
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
	public FlightSelect() {
		setTitle("\u822A\u73ED\u67E5\u8BE2");
		setBounds(100, 100, 541, 390);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u6309\u822A\u73ED\u53F7\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSelectActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(FlightSelect.class.getResource("/image/\u822A\u73ED\u53F7.png")));
		btnNewButton.setBounds(140, 37, 224, 48);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6309\u76EE\u7684\u5730\u67E5\u8BE2");
		btnNewButton_1.setIcon(new ImageIcon(FlightSelect.class.getResource("/image/\u57CE  \u5E02.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(140, 116, 224, 48);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6309\u65F6\u95F4\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(FlightSelect.class.getResource("/image/\u5EF6\u8BEF.png")));
		btnNewButton_2.setBounds(140, 204, 224, 48);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(FlightSelect.class.getResource("/image/\u8FD4\u56DE.png")));
		btnNewButton_3.setBounds(201, 302, 97, 36);
		getContentPane().add(btnNewButton_3);

	}

	//按时间查询事件
	protected void DateActionPerformed(ActionEvent e) {
		this.dispose();
		DateSelect ds = new DateSelect();
		ds.setVisible(true);
		userFrame.table.add(ds);	
	}

	//按目的地查询事件
	protected void ecActionPerformed(ActionEvent e) {
		this.dispose();
		EcSelect es = new EcSelect();
		es.setVisible(true);
		userFrame.table.add(es);
	}

	//按航班号查询事件
	protected void FlightSelectActionPerformed(ActionEvent e) {
		this.dispose();
		SelectHBH sh = new SelectHBH();
		sh.setVisible(true);
		userFrame.table.add(sh);
		
	}

	protected void returnActionPerformed(ActionEvent e) {
		this.dispose();
		
	}
}
