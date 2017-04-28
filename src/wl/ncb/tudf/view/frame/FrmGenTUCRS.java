package wl.ncb.tudf.view.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wl.ncb.tudf.bean.ConnDB;

import wl.ncb.tudf.connDB.ConnectDB10g;
import wl.ncb.tudf.connDB.ConnectOracle10g;
import wl.ncb.tudf.view.dialog.AnimateProgress;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.io.OutputStreamWriter;

public class FrmGenTUCRS extends JInternalFrame {
	private JTextField txtAsOfDate;
	static Logger log = Logger.getLogger(FrmProcessingDataNcb.class.getName());
	ConnDB conndb;
	private ConnectOracle10g connoracle10g;
	private static Connection conn = null;
	private JTextField txtTotalRec;
	private JLabel txtOutputPath;
	Timer timer;
	private JLabel lblProcess;
	int width = 80;
	int height = 15;
	int i=1;
    int totalrec=0;
	  AnimateProgress dialog = new AnimateProgress();
	BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_ARGB);

	/**
	 * Create the frame.
	 */

	public FrmGenTUCRS(String s) {
	    getContentPane().add(new JLabel(s), BorderLayout.CENTER);
	    setBounds(100, 2, 865, 709);
	    setResizable(true);
	    setClosable(true);
	    setMaximizable(true);
	    setIconifiable(true);
	    setTitle(s);
	    setVisible(true);

	
	getContentPane().setLayout(null);
	
	JPanel pnlFooter = new JPanel();
	pnlFooter.setBounds(0, 722, 1008, 10);
	pnlFooter.setBackground(Color.GRAY);
	getContentPane().add(pnlFooter);
	
	JPanel panel = new JPanel();
	panel.setBounds(178, 141, 474, 78);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E1B\u0E23\u0E30\u0E21\u0E27\u0E25\u0E1C\u0E25");
	label.setFont(new Font("Tahoma", Font.BOLD, 16));
	label.setBounds(0, 20, 120, 30);
	panel.add(label);
	
	txtAsOfDate = new JTextField();
	txtAsOfDate.setFont(new Font("Tahoma", Font.BOLD, 16));
	txtAsOfDate.setBounds(132, 13, 133, 44);
	panel.add(txtAsOfDate);
	txtAsOfDate.setColumns(10);
	
	JButton btnNewButton = new JButton("Process");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton.setBounds(311, 17, 151, 34);
	panel.add(btnNewButton);
	
	JLabel lblYyyymm = new JLabel("YYYYMM");
	lblYyyymm.setBounds(142, 62, 81, 16);
	panel.add(lblYyyymm);
	lblYyyymm.setForeground(Color.RED);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 
			
			if (initApplicationContext()) {
				log.debug("Load init Application context Success.");
				if (initConnectDatabaseOracle()) {
					System.out.println("เชื่อมต่อฐานข้อมูลได้");
					log.debug("เชื่อมต่อฐานข้อมูลได้");
					
			
					lblProcess.setText("กำลังประมวลผล..");

		
					//genTextFileNCB(txtAsOfDate.getText());
					 Thread pc = new Thread(() -> {
						 System.out.println("Processing..");
					   genTextFileNCB(txtAsOfDate.getText());
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
					/*SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							genTextFileNCB(txtAsOfDate.getText());
							  lblProcess.setText("ประมวลผลเสร็จสิ้นแล้ว !");

						}
					});*/
					
					
					 
					   // Runs outside of the Swing UI thread
					  /*/  new Thread(new Runnable() {
					      public void run() {
					
					   do{
					    		
					    	
					    	
					             SwingUtilities.invokeLater(new Runnable() {
					            public void run() {
					            	
					            	lblProcess.setText("กำลังประมวลผล..");
					            	
					            
					            }
					          });

					          try {
					        	  
					        	  System.out.println("Wait.."+i);
					            java.lang.Thread.sleep(50);
					          }
					          catch(Exception e) { }
					          
					         
				    		 
					
					          i++;
					      }while(!txtTotalRec.getText().equals("Reading") );
					   lblProcess.setText("ประมวลผลเสร็จสิ้นแล้ว !");
					    }
					  
					    }).start();
					*/
				
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
	
	txtTotalRec = new JTextField();
	txtTotalRec.setText("0");
	txtTotalRec.setHorizontalAlignment(SwingConstants.CENTER);
	txtTotalRec.setBackground(Color.GRAY);
	txtTotalRec.setForeground(Color.GREEN);
	txtTotalRec.setFont(new Font("Tahoma", Font.BOLD, 16));
	txtTotalRec.setBounds(309, 257, 137, 38);
	getContentPane().add(txtTotalRec);
	txtTotalRec.setColumns(10);
	
	 lblProcess = new JLabel("**STATUS**");
	 lblProcess.setFont(new Font("Tahoma", Font.BOLD, 16));
	 lblProcess.setForeground(Color.BLUE);
	lblProcess.setBounds(178, 356, 270, 43);
	getContentPane().add(lblProcess);
	
	JLabel label_1 = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19\u0E41\u0E16\u0E27");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_1.setBounds(216, 268, 81, 16);
	getContentPane().add(label_1);
	
	JLabel label_2 = new JLabel("\u0E41\u0E16\u0E27");
	label_2.setForeground(Color.DARK_GRAY);
	label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_2.setBounds(473, 268, 81, 16);
	getContentPane().add(label_2);
	
	JButton btnOpen = new JButton("Open");
	btnOpen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(  txtOutputPath.getText().length()<=0){
				 
				 JOptionPane.showMessageDialog(null,
					      "กรุณาเลือกสถานที่เก็บFile",
					      "Inane warning",
					      JOptionPane.WARNING_MESSAGE);
				 return;
			 
			 }
			
			File file = new File (txtOutputPath.getText());
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	});
	btnOpen.setForeground(Color.BLACK);
	btnOpen.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnOpen.setBounds(491, 322, 93, 25);
	getContentPane().add(btnOpen);
	
	txtOutputPath = new JLabel("C:\\NCBWL\\textfile");
	txtOutputPath.setForeground(Color.GRAY);
	txtOutputPath.setFont(new Font("Tahoma", Font.BOLD, 16));
	txtOutputPath.setBounds(309, 327, 189, 16);
	getContentPane().add(txtOutputPath);
	
	JLabel lblTextFile = new JLabel("\u0E2A\u0E23\u0E49\u0E32\u0E07 Text File \u0E2A\u0E48\u0E07 NCB");
	lblTextFile.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblTextFile.setBounds(226, 47, 328, 38);
	getContentPane().add(lblTextFile);
	
	JLabel lblOutputPath = new JLabel("Output Path:");
	lblOutputPath.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblOutputPath.setBounds(178, 327, 112, 16);
	getContentPane().add(lblOutputPath);


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

private void genTextFileNCB(String pAsOfMonth) {
    
	


	try {
	//	String sql = "SELECT  SEGMENT_DETAIL,ITEMID FROM TUDF_AS_MONTH  WHERE ASOFDATE=? ORDER BY ITEMID ASC";
		String sql ="SELECT  ITEMID,SEGMENT_DETAIL,CASE ITEMID WHEN 0 THEN TO_NUMBER(SUBSTR(SEGMENT_DETAIL,93,8)) ELSE NULL END as HS10 FROM TUDF_AS_MONTH  WHERE ASOFDATE=? ORDER BY ITEMID ASC";

		PreparedStatement pre = ConnectDB10g.getConn().prepareStatement(sql);
		pre.setString(1, pAsOfMonth);
		ResultSet rs = pre.executeQuery();

		//File partTUCRS = new File("C:/NCBWL/textfile/TUCRS-WL-"+pAsOfMonth.substring(0, 4)+"-"+pAsOfMonth.substring(4)+".txt");
		String partTUCRS = "C:/NCBWL/textfile/TUCRS-WL-"+pAsOfMonth.substring(0, 4)+"-"+pAsOfMonth.substring(4)+".txt";
		
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(partTUCRS),"Cp1252"));
		  while (rs.next()) {
			  
	
                  if (Integer.parseInt(rs.getString("ITEMID")) == 0) {
                      System.out.println("Itemid0>>"+rs.getString("SEGMENT_DETAIL"));

                      System.out.println(Integer.toString(rs.getInt("HS10")));
                      totalrec=rs.getInt("HS10");
                	
                  }
                  
		    	       
		    	        writer.write(rs.getString("SEGMENT_DETAIL")+ System.getProperty("line.separator"));
		    	        
		    	     
		    	     
		    	     
		    	     if(!rs.getString("SEGMENT_DETAIL").equals("TRLR")){
		    	          writer.write("\r\n");
		    	     }
		
		 
		}
	
		  txtTotalRec.setText(String.valueOf(totalrec));

      
	      writer.close();
	    rs.close();
	    pre.close();
		connoracle10g.closeConnorcl10g(conn);
		
		
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	
}

}
