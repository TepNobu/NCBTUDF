package wl.ncb.tudf.view.dialog;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wl.ncb.tudf.bean.ConnDB;

import wl.ncb.tudf.frmLogin;
import wl.ncb.tudf.connDB.ConnectDB10g;
import wl.ncb.tudf.connDB.ConnectOracle10g;
import wl.ncb.tudf.test.GradientTranslucentWindowDemo;
import wl.ncb.tudf.view.frame.FrmNCBExtra;
import wl.ncb.tudf.view.main.MainApp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DialogLogin extends JDialog {
   private JLabel label;
   private String s = "";
	FocusListener highlighter;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JLabel lblErrUser;
	public static boolean login = false;
	public static String  txtUserID = null;
	static Logger log = Logger.getLogger(DialogLogin.class.getName());
	ConnDB conndb;
	private ConnectOracle10g connoracle10g;
	private static Connection conn = null;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
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
		try {
			
			DialogLogin dialog = new DialogLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLogin() {
		
		setTitle("Login");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				  txtUserID=txtUsername.getText();
				 //   s = txtUserName.getText();
	               // label.setText(s);
	                
				dispose();
				
			//	System.out.println("User>>"+DialogLogin.txtUserID);
				//txtUsername.setText(DialogLogin.txtUserID);
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				//txtUsername.requestFocusInWindow();
				txtPassword.requestFocusInWindow();
				txtUsername.requestFocusInWindow();
			}
		});
		setAlwaysOnTop(true);
		highlighter = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				e.getComponent().setBackground(Color.GREEN);
			}

			@Override
			public void focusLost(FocusEvent e) {
				e.getComponent().setBackground(
						UIManager.getColor("TextField.background"));
			}
		};

		setBounds(220, 300, 1115, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		
		
        
		
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmLogin.class.getResource("/wl/ncb/tudf/img/img_left.jpg")));
		lblNewLabel.setBounds(33, 58, 680, 322);
		
		
		contentPanel.add(lblNewLabel);
		

		JPanel panel = new JPanel()
		{
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 100;
                    final int G = 100;
                    final int B = 100;

                    Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                            0.0f, getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
     //   panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(714, 57, 371, 323);
		
		 panel.setLayout(null);

		contentPanel.add(panel);
		{
		
			
			JLabel lblUserName = new JLabel("Username:");
			lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblUserName.setBounds(12, 78, 98, 16);
			panel.add(lblUserName);
			
		
		}
		{
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPassword.setBounds(12, 124, 98, 16);
			panel.add(lblPassword);
		}
		
		/*txtUserName = new JTextField();
		txtUserName.setBounds(116, 94, 116, 22);
		panel.add(txtUserName);
		txtUserName.setColumns(10);*/
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		//txtUsername.setBounds(104, 89, 229, 32);
		txtUsername.setBounds(104, 72, 229, 38);
		txtUsername.addFocusListener(highlighter);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(104, 190, 229, 32);
			panel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Passing UserID"+txtUsername.getText());
						//dispose();
						if (initApplicationContext()) {
							log.debug("Load init Application context Success.");
							if (initConnectDatabaseOracle()) {
								System.out.println("เชื่อมต่อฐานข้อมูลได้");
								log.debug("เชื่อมต่อฐานข้อมูลได้");
								
								frmCheckUsername();
								
							
							} else {
								log.error("ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
								System.out
										.println("ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
								JOptionPane
										.showMessageDialog(null,
												"ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
								return;
							}
							
						}else {
							log.error("Con't Load init Application Context");
							JOptionPane.showMessageDialog(null,
									"Con't Load init Application Context");
							return;
						}
					}
				});
				btnLogin.setVerticalAlignment(SwingConstants.TOP);
				btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
			//	btnLogin.setBounds(174, 196, 97, 32);
				
				btnLogin.setBounds(60, 0, 97, 32);
				//btnLogin.setActionCommand("OK");
				buttonPane.add(btnLogin);
				getRootPane().setDefaultButton(btnLogin);
			}
		}
		
	    lblErrUser = new JLabel();
		lblErrUser.setForeground(Color.RED);
		lblErrUser.setBounds(101, 241, 241, 23);
		panel.add(lblErrUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPassword.setBounds(104, 123, 229, 38);
		txtPassword.addFocusListener(highlighter);
		panel.add(txtPassword);
		
		JLabel lblCunsumerDataInput = new JLabel("Cunsumer Data Input Format");
		lblCunsumerDataInput.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCunsumerDataInput.setForeground(new Color(128, 0, 0));
		lblCunsumerDataInput.setBounds(50, 29, 293, 16);
		contentPanel.add(lblCunsumerDataInput);
		
		JLabel lblTransUnionData = new JLabel("Trans Union Data Format (TUDF)");
		lblTransUnionData.setForeground(new Color(0, 0, 255));
		lblTransUnionData.setBackground(new Color(0, 0, 255));
		lblTransUnionData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTransUnionData.setBounds(376, 393, 300, 16);
		contentPanel.add(lblTransUnionData);
	}
	
	/* public DialogLogin(final Frame frame, boolean modal, final JLabel label) {
	    	 super(frame, modal);
	        this.label = label;
	 }*/
	 

		    
		  

	// to allow outside classes to get the text held by the JTextField
	   public String getUserName() {
	      return txtUsername.getText();
	   }
	   
	 
	   public void frmCheckUsername() {
			if (txtUsername.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "กรุณาใส่ Username !");
				return;
			}
			log.debug(">>>>>>>>>>>>Login<<<<<<<<<<<<<<< ");

					if (initConnectDatabaseOracle()) {
						System.out.println("เชื่อมต่อฐานข้อมูลได้");
						log.debug("เชื่อมต่อฐานข้อมูลได้");
						//  char[] pwd = txtPassword.getPassword();
						
						String password = new String(txtPassword.getPassword());
				
						if (loginAuthentication(txtUsername.getText(), password)) {
							//lbluser.setText(txtUsername.getText().toString());
							//txtUsername.setText(null);// clear text fill first
														// Username                 
						
							log.debug("Login by "+txtUsername.getText());
						    dispose();
						} else {
							txtUsername.requestFocusInWindow();
							log.error("ไม่พบรหัสผู้ใช้นี้ในระบบ !");
							System.out.println("ไม่พบรหัสผู้ใช้นี้ในระบบ !");
							txtUsername.setText(null);
							txtPassword.setText(null);
							lblErrUser.setText("***Username&Password ไม่ถูกต้อง !");
						
						}

					} else {
						log.error("ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
						System.out
								.println("ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
						JOptionPane
								.showMessageDialog(null,
										"ไม่สามารถเชื่อมต่อฐานข้อมูลได้ กรุณาติดต่อ Database Admin !");
						return;
					}	
		}
		
		public boolean initApplicationContext() {

			boolean AppcontextFound = false;
			try {
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
						"file:C:/NCBWL/resources/application-context.xml");
				System.out.println("Spring context initialized.");

			
				conndb = (ConnDB) applicationContext.getBean("conndb");

				log.debug("Host='" + conndb.dbhost + "'");
				System.out.println("Host='" + conndb.dbhost + "'");
				log.debug("Connect database status:" + conndb.getCondbstatus());
				System.out.println("Connect database status='"
						+ conndb.getCondbstatus() + "'");
				
		
				AppcontextFound = true;

			} catch (Exception e) {
				AppcontextFound = false;
			}

			return AppcontextFound;
		}
		
		public boolean initConnectDatabaseOracle() {
			boolean verifyConnDB = false;

			try {
				connoracle10g = new ConnectOracle10g(conndb.getDbdriver(),
						conndb.getDbhost(), conndb.getDbport(), conndb.getDbname(),
						conndb.getDbusername(), conndb.getDbpassword());

				conn = connoracle10g.opendborcl10g();
				
				ConnectDB10g.setConn(conn);
				log.debug("Connect-->" + ConnectDB10g.getConn().toString());
				System.out
						.println("Connect-->" + ConnectDB10g.getConn().toString());

				verifyConnDB = true;

				// saveLog();//Keep log

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("Error Connect:" + e);
				verifyConnDB = false;
			}

			return verifyConnDB;
		}
		
		public boolean loginAuthentication(String pUsername, String pPassWord) {
			boolean verifyUsername = false;
			String ckUsername = "";

			try {

				String sql = "" + " SELECT 'X' AS CKUSER " + " FROM BTW.USERS "
						+ " WHERE USERNAME=?  AND PASSWORD= BTW.TOOLKIT.ENCRYPT(?)";

				PreparedStatement pre = ConnectDB10g.getConn()
						.prepareStatement(sql);
				pre.setString(1, pUsername);
				pre.setString(2, pPassWord);
				ResultSet rs = pre.executeQuery();
				System.out.println("Username:" + pUsername);

				if (rs.next()) {

					ckUsername = rs.getString("CKUSER");

					verifyUsername = true;
					System.out.println("Has Username:" + ckUsername);

				} else {
					verifyUsername = false;
				}
				rs.close();
				pre.close();
				connoracle10g.closeConnorcl10g(conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return verifyUsername;
		}
}
