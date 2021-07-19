package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class adminFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFrame frame = new adminFrame();
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
	public adminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 620);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem out = new JMenuItem("\u9000\u51FA\u767B\u5F55");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outActionPerformed(e);
			}
		});
		mnNewMenu.add(out);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepwdActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E8B\u52A1");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5220\u9664\u822A\u73ED\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5F55\u5165\u822A\u73ED\u4FE1\u606F");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HBHactionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6D4F\u89C8\u822A\u73ED\u4FE1\u606F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightInfoActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u822A\u73ED\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		table.setBounds(10, 10, 692, 565);
		contentPane.add(table);
	}

	
	//修改密码事件
	protected void updatepwdActionPerformed(ActionEvent e) {
		UpdatePWD up = new UpdatePWD();
		up.setVisible(true);
		table.add(up);
		
	}

	//修改航班信息事件
	protected void updateActionPerformed(ActionEvent e) {
		UpdateFrame uf = new UpdateFrame();
		uf.setVisible(true);
		table.add(uf);
		
	}

	//删除航班信息
	protected void deleteActionPerformed(ActionEvent e) {
		DeleteFrame df = new DeleteFrame();
		df.setVisible(true);
		table.add(df);
	}

	//浏览航班事件
	protected void FlightInfoActionPerformed(ActionEvent e) {
		HBHselected hs = new HBHselected();
		hs.setVisible(true);
		table.add(hs);
		
	}

	//插入航班事件
	protected void HBHactionPerformed(ActionEvent e) {
		insertFrame iFrame = new insertFrame();
		iFrame.setVisible(true);
		table.add(iFrame);
		
	}

	//登出事件
	protected void outActionPerformed(ActionEvent e) {
		int input = JOptionPane.showConfirmDialog(null, "你确定要退出吗");
		if(input == 0) {
			this.dispose();
			new mainFrame().setVisible(true);
		}else{
			return;
		}
		
	}
}
