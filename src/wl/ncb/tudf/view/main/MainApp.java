package wl.ncb.tudf.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


//import wl.ncb.tudf.ControlDialog;
//import wl.ncb.tudf.ControlDialog;
import wl.ncb.tudf.view.dialog.DialogLogin;
import wl.ncb.tudf.view.frame.FrmGenTUCRS;
import wl.ncb.tudf.view.frame.FrmNCBExtra;
import wl.ncb.tudf.view.frame.FrmProcDataTUCRS;
//import wl.ncb.tudf.view.frame.FrmNCBExtra;
import wl.ncb.tudf.view.frame.FrmProcessingDataNcb;
//import wl.ncb.tudf.view.frame.test;


public class MainApp  {

	private JFrame frmCunsumerDataInput;
	DialogLogin d = new DialogLogin();
	//private DialogLogin control;
//	private JLabel controlDialogLabel = new JLabel("  ");
	private JLabel lblUserID = new JLabel(" ");
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		
		String name = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(name);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmCunsumerDataInput.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
		
		  
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCunsumerDataInput = new JFrame();
		frmCunsumerDataInput.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				if(DialogLogin.login==false){
				
					d.setVisible(true);
					
				
				}
				
				
			}
		
		});
		// desktopPane = new JDesktopPane();
		 JLayeredPane desktopPane = new JDesktopPane();
		frmCunsumerDataInput.getContentPane().add(desktopPane, BorderLayout.CENTER);
		frmCunsumerDataInput.setTitle("Cunsumer Data Input Format");
		frmCunsumerDataInput.setBounds(100, 100,1366, 900);
		frmCunsumerDataInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCunsumerDataInput.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inquiry |");
		mnNewMenu.setFont(new Font("AngsanaUPC", Font.BOLD, 26));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u0E42\u0E2D\u0E19\u0E40\u0E1B\u0E25\u0E35\u0E48\u0E22\u0E19\u0E2A\u0E31\u0E0D\u0E0D\u0E32");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	txtUsername.setText(d.getUserName());
				System.out.println("Username"+d.getUserName());
			}
		});
		mntmNewMenuItem.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E19\u0E33\u0E2A\u0E48\u0E07NCB");
		mntmNewMenuItem_1.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuItem.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnNewMenu.add(menuItem);
		
		JMenu mnProcess = new JMenu("Process |");
		mnProcess.setFont(new Font("AngsanaUPC", Font.BOLD, 26));
		menuBar.add(mnProcess);
		
		JMenuItem mntmncb = new JMenuItem("\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E33\u0E2A\u0E48\u0E07NCB");
		mntmncb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//desktopPane.add(new FrmGenTUCRS("FrmGenTUCRS >>Username:"+d.getUserName()), JLayeredPane.POPUP_LAYER);
				desktopPane.add(new FrmProcDataTUCRS("FrmProcDataTUCRS >>Username:"+d.getUserName()), JLayeredPane.POPUP_LAYER);
					
				
			}
		});
		
		JMenuItem menuItem_5 = new JMenuItem("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E1E\u0E34\u0E40\u0E28\u0E29(\u0E01\u0E48\u0E2D\u0E19\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25)");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new FrmNCBExtra("FrmNCBExtra >>Username:"+d.getUserName()), JLayeredPane.POPUP_LAYER);
	
			}
		});
		menuItem_5.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnProcess.add(menuItem_5);
		mntmncb.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnProcess.add(mntmncb);
		
		JMenuItem mntmExportConsumerData = new JMenuItem("Export Consumer Data (TUCRS File)");
		mntmExportConsumerData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				desktopPane.add(new FrmProcessingDataNcb("Export"), JLayeredPane.POPUP_LAYER);
			}
		});
		mntmExportConsumerData.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnProcess.add(mntmExportConsumerData);
		
		JMenu mnReports = new JMenu("Reports |");
		mnReports.setFont(new Font("AngsanaUPC", Font.BOLD, 26));
		menuBar.add(mnReports);
		
		JMenuItem menuItem_1 = new JMenuItem("\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E2A\u0E48\u0E07\u0E08\u0E14\u0E2B\u0E21\u0E32\u0E22 \u0E23\u0E32\u0E22\u0E40\u0E14\u0E37\u0E2D\u0E19");
		menuItem_1.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnReports.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E2A\u0E48\u0E07\u0E08\u0E14\u0E2B\u0E21\u0E32\u0E22 \u0E23\u0E32\u0E22\u0E1B\u0E35");
		menuItem_2.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnReports.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E25\u0E39\u0E01\u0E2B\u0E19\u0E35\u0E49\u0E17\u0E33\u0E22\u0E2D\u0E21");
		menuItem_3.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnReports.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E17\u0E30\u0E40\u0E1A\u0E35\u0E22\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01\u0E01\u0E32\u0E23\u0E41\u0E08\u0E49\u0E07\u0E43\u0E2B\u0E49\u0E25\u0E39\u0E01\u0E04\u0E49\u0E32");
		menuItem_4.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnReports.add(menuItem_4);
		
		JMenuItem mntmncb_1 = new JMenuItem("\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E19\u0E33\u0E2A\u0E48\u0E07NCB");
		mntmncb_1.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnReports.add(mntmncb_1);
		
		JMenu mnSetting = new JMenu("Setting");
		mnSetting.setFont(new Font("AngsanaUPC", Font.BOLD, 26));
		menuBar.add(mnSetting);
		
		JMenuItem mntmtextfilencb = new JMenuItem("\u0E15\u0E31\u0E49\u0E07\u0E04\u0E48\u0E32\u0E0A\u0E37\u0E48\u0E2DTextFile\u0E19\u0E33\u0E2A\u0E48\u0E07NCB");
		mntmtextfilencb.setFont(new Font("AngsanaUPC", Font.PLAIN, 26));
		mnSetting.add(mntmtextfilencb);
		
		JPanel panel = new JPanel();
		frmCunsumerDataInput.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblCunsumerDataInput = new JLabel("Cunsumer Data Input Format");
		lblCunsumerDataInput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCunsumerDataInput.setBounds(100, 89, 229, 32);
		lblCunsumerDataInput.setForeground(new Color(128, 0, 0));
		panel.add(lblCunsumerDataInput);
		
		//JLabel lblUserID = new JLabel("lblUserID");
		panel.add(lblUserID);
	
	
		
		
	}
}
