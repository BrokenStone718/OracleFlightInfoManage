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

public class userFrame extends JFrame {

	private JPanel contentPane;
	static JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userFrame frame = new userFrame();
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
	public userFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 556);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem out = new JMenuItem("\u9000\u51FA\u767B\u5F55");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outActionPerformed(e);
			}
		});
		mnNewMenu.add(out);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePWDactionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E8B\u52A1");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem select_info = new JMenuItem("\u67E5\u8BE2\u822A\u73ED\u4FE1\u606F");
		select_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectActionPerformed(e);
			}
		});
		mnNewMenu_1.add(select_info);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		table.setBounds(10, 10, 687, 486);
		contentPane.add(table);
	}

	//修改密码事务
	protected void updatePWDactionPerformed(ActionEvent e) {
		UpdatePWD up = new UpdatePWD();
		up.setVisible(true);
		table.add(up);
		
	}

	//查询航班事务
	protected void selectActionPerformed(ActionEvent e) {
		FlightSelect fs = new FlightSelect();
		fs.setVisible(true);
		table.add(fs);
		
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
