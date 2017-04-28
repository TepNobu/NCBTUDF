package wl.ncb.tudf.view.frame;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import java.awt.Paint;
import java.sql.Connection;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wl.ncb.tudf.bean.ConnDB;

import wl.ncb.tudf.connDB.ConnectDB10g;
import wl.ncb.tudf.connDB.ConnectOracle10g;
import wl.ncb.tudf.view.dialog.AnimateProgress;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProcDataTUCRS extends JInternalFrame {
	private JTextField txtAsofDate;
	static Logger log = Logger.getLogger(FrmProcDataTUCRS.class.getName());
	ConnDB conndb;
	private ConnectOracle10g connoracle10g;
	private static Connection conn = null;
	private JLabel lblProcess;
	 AnimateProgress dialog = new AnimateProgress();
	 private JPanel panel_status_process;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProcDataTUCRS frame = new FrmProcDataTUCRS("test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrmProcDataTUCRS(String pUserName) {
		 getContentPane().setLayout(null);
		 JLabel label = new JLabel(pUserName);
		 label.setBounds(0, 0, 0, 0);
		 getContentPane().add(label);
		 
			setBounds(100, 2, 1024, 786);
		    setResizable(true);
		    setClosable(true);
		    setMaximizable(true);
		    setIconifiable(true);
		    setTitle(pUserName);
		    setVisible(true);
	
		    
		 // Determine what the GraphicsDevice can support.
	        GraphicsEnvironment ge = 
	            GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice gd = ge.getDefaultScreenDevice();
	        boolean isPerPixelTranslucencySupported = 
	            gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

	        //If translucent windows aren't supported, exit.
	        if (!isPerPixelTranslucencySupported) {
	            System.out.println(
	                "Per-pixel translucency is not supported");
	                System.exit(0);
	        }
	       

	     //   JFrame.setDefaultLookAndFeelDecorated(true);

	        // Create the GUI on the event-dispatching thread
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	FrmProcDataTUCRS gtw = new
	            			FrmProcDataTUCRS("FrmProcDataTUCRS");

	                // Display the window.
	                gtw.setVisible(true);
	            }
	        });
		    
		     JPanel panel = new JPanel(){
		            @Override
		            protected void paintComponent(Graphics g) {
		                if (g instanceof Graphics2D) {
		                    final int R = 240;
		                    final int G = 240;
		                    final int B = 240;

		                    Paint p =
		                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
		                            0.0f, getHeight(), new Color(R, G, B, 255), true);
		                    Graphics2D g2d = (Graphics2D)g;
		                    g2d.setPaint(p);
		                    g2d.fillRect(0, 0, getWidth(), getHeight());
		                }
		            }
		        };
		     panel.setBackground(new Color(0, 128, 0));
			 panel.setBounds(0, 2, 1008, 786);
			 getContentPane().add(panel);
			 panel.setLayout(null);
			 
		
			 
			 JPanel panel_1 = new JPanel(){
		            @Override
		            protected void paintComponent(Graphics g) {
		                if (g instanceof Graphics2D) {
		                    final int R = 200;
		                    final int G = 200;
		                    final int B = 200;

		                    Paint p =
		                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
		                            0.0f, getHeight(), new Color(R, G, B, 255), true);
		                    Graphics2D g2d = (Graphics2D)g;
		                    g2d.setPaint(p);
		                    g2d.fillRect(0, 0, getWidth(), getHeight());
		                }
		            }
		        };
				panel_1.setForeground(Color.WHITE);
			    panel_1.setBackground(new Color(205, 92, 92));
				panel_1.setBounds(12, 13, 969, 58);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25TUCRS");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
				lblNewLabel.setBounds(351, 13, 300, 30);
				panel_1.add(lblNewLabel);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(12, 118, 969, 212);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblAsofdate = new JLabel("AsOfDate :");
				lblAsofdate.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblAsofdate.setBounds(309, 83, 104, 25);
				panel_2.add(lblAsofdate);
				
				txtAsofDate = new JTextField();
				txtAsofDate.setFont(new Font("Tahoma", Font.BOLD, 16));
				txtAsofDate.setBounds(425, 83, 116, 30);
				panel_2.add(txtAsofDate);
				txtAsofDate.setColumns(10);
				
				JButton btnPrc = new JButton("\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25");
				btnPrc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (initApplicationContext()) {
							log.debug("Load init Application context Success.");
							if (initConnectDatabaseOracle()) {
								System.out.println("เชื่อมต่อฐานข้อมูลได้");
								log.debug("เชื่อมต่อฐานข้อมูลได้");
								
							
							
								panel_status_process.setVisible(true);
					
								 Thread pc = new Thread(() -> {
									 System.out.println("Processing..");
										lblProcess.setText("กำลังประมวลผล..");
								          //genTextFileNCB(txtAsOfDate.getText());
								   
								  lblProcess.setText("ประมวลผลเสร็จสิ้นแล้ว !");
								  dialog.dispose();						
								  });
								 pc.start();
								 Thread pg = new Thread(() -> {
									 System.out.println("dialog..process");
									   dialog.getDefaultCloseOperation(); // HIDE_ON_CLOSE

									    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
										dialog.setVisible(true);
										dialog.setAlwaysOnTop(true);
										
										dialog.setBounds(390, 400, 490, 300);
										
										dialog.show();
										dialog.go();
								   });
								 pg.start();
							
							
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
				btnPrc.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnPrc.setBounds(566, 85, 100, 30);
				panel_2.add(btnPrc);
				
				panel_status_process = new JPanel();
				panel_status_process.setBackground(new Color(248, 248, 255));
				panel_status_process.setBounds(369, 384, 281, 51);
				panel_status_process.setVisible(false);
				panel.add(panel_status_process);
				panel_status_process.setLayout(null);
				
				
				 lblProcess = new JLabel("\u0E01\u0E33\u0E25\u0E31\u0E07\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25...");
				lblProcess.setBounds(65, 13, 156, 23);
				lblProcess.setForeground(new Color(255, 0, 0));
				lblProcess.setFont(new Font("Tahoma", Font.BOLD, 19));
				panel_status_process.add(lblProcess);
             
			 
	     	
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

}
