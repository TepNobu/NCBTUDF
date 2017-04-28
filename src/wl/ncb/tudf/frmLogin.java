package wl.ncb.tudf;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wl.ncb.tudf.bean.ConnDB;

import wl.ncb.tudf.connDB.ConnectDB10g;
import wl.ncb.tudf.connDB.ConnectOracle10g;
import wl.ncb.tudf.view.frame.FrmProcessingDataNcb;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	FocusListener highlighter;
	static Logger log = Logger.getLogger(frmLogin.class.getName());
	ConnDB conndb;
	private ConnectOracle10g connoracle10g;
	private static Connection conn = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
						String name = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
						UIManager.setLookAndFeel(name);
				
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
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
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmLogin.class.getResource("/wl/ncb/tudf/img/img_left.jpg")));
		lblNewLabel.setBounds(33, 58, 680, 322);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(714, 57, 371, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(12, 95, 98, 16);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(12, 140, 98, 16);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(104, 89, 229, 32);
		txtUsername.addFocusListener(highlighter);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(104, 134, 229, 32);
		txtPassword.addFocusListener(highlighter);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*frmCheckUsername();*/
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
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(174, 196, 97, 32);
		panel.add(btnLogin);
		
		JLabel lblCurrentDate = new JLabel("Current date:");
		lblCurrentDate.setForeground(new Color(128, 0, 0));
		lblCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentDate.setBounds(12, 13, 111, 16);
		panel.add(lblCurrentDate);
		
		JLabel lblshwCurrentDate = new JLabel("");
		lblshwCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblshwCurrentDate.setForeground(new Color(0, 0, 128));
		lblshwCurrentDate.setBackground(new Color(255, 255, 255));
		lblshwCurrentDate.setBounds(104, 13, 116, 16);
		panel.add(lblshwCurrentDate);
		
		JLabel lblNewLabel_1 = new JLabel("Cunsumer Data Input Format");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 13, 339, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTransUnionData = new JLabel("Trans Union Data Format (TUDF)");
		lblTransUnionData.setForeground(new Color(0, 0, 128));
		lblTransUnionData.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTransUnionData.setBounds(374, 386, 339, 16);
		contentPane.add(lblTransUnionData);
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				   //get current date time with Calendar()
				   Calendar cal = Calendar.getInstance();
				   lblshwCurrentDate.setText(dateFormat.format(cal.getTime()));
				//   System.out.println(dateFormat.format(cal.getTime()));

			}
		});
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
					if (loginAuthentication(txtUsername.getText())) {
						//lbluser.setText(txtUsername.getText().toString());
						//txtUsername.setText(null);// clear text fill first
													// Username
						log.debug("Login by "+txtUsername.getText());
					//	dispose();
					} else {
						log.error("ไม่พบรหัสผู้ใช้นี้ในระบบ !");
						System.out.println("ไม่พบรหัสผู้ใช้นี้ในระบบ !");
						JOptionPane.showMessageDialog(null,
								"ไม่พบรหัสผู้ใช้นี้ในระบบ !");
						return;
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
	
	public boolean loginAuthentication(String pUsername) {
		boolean verifyUsername = false;
		String ckUsername = "";

		try {

			String sql = "" + " SELECT 'X' AS CKUSER " + " FROM BTW.USERS "
					+ " WHERE USERNAME=? ";

			PreparedStatement pre = ConnectDB10g.getConn()
					.prepareStatement(sql);
			pre.setString(1, pUsername);
			ResultSet rs = pre.executeQuery();
			System.out.println("Username:" + pUsername);

			if (rs.next()) {

				/*
				 * txtIDCard.setText(rs.getString("IDCARD_NUM"));
				 * txtCustName.setText(rs.getString("CUST_NAME"));
				 * txtApplication_num.setText(rs.getString("APPLICATION_NUM"));
				 * txtCustNo.setText(rs.getString("CUST_NO"));
				 */

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
