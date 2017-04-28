package wl.ncb.tudf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import quick.dbtable.DBTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import quick.dbtable.DBTableEventListener;

public class TestQuickDbTable extends JFrame {
	private static final long serialVersionUID = -631092023960707898L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestQuickDbTable frame = new TestQuickDbTable();
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
	public TestQuickDbTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        try {
            // Use system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // set Frame properties
            setSize(328, 381);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            // create a new quicktable
            DBTable dBTable1 = new DBTable();
     

            // add to frame
            getContentPane().add(dBTable1);

            // set the database driver to be used, we are using jdbc-odbc driver
         //   dBTable1.setDatabaseDriver("org.h2.Driver");

            /*
             * set the jdbc url,"quicktabledemo" is the data source we have
             * created for the database
             */
        //    dBTable1.setJdbcUrl("jdbc:h2:mem:test;INIT=create table employee as select * from CSVREAD('test.csv');");

          //  DBTable dBTable1 = new DBTable();
     	   dBTable1.connectDatabase(
     	         "oracle.jdbc.driver.OracleDriver",
     	         "jdbc:oracle:thin:@192.168.25.18:1521/orcl",
     	         "BTW" ,
     	         "BTW");
     	   dBTable1.setSelectSql("select * from emp");
     	   
     	   JPanel panel = new JPanel();
     	   contentPane.add(panel, BorderLayout.NORTH);
     	   
     	   JButton btnNewButton = new JButton("SAVE");
     	  
     	   panel.add(btnNewButton);
     	   dBTable1.refresh();
            // set the select statement which should be used by the table
           // dBTable1.setSelectSql("select * from employee");

            // to create the navigation bars for the table
            dBTable1.createControlPanel();

            // connect to database & create a connection
            dBTable1.connectDatabase();

            // fetch the data from database to fill the table
            dBTable1.refresh();
            btnNewButton.addActionListener(new ActionListener() {
         	   	public void actionPerformed(ActionEvent arg0) {
         	   	dBTable1.save();   
         	   	try {
					dBTable1.refresh();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         	   	}
         	   });
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
