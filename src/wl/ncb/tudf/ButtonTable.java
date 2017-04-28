package wl.ncb.tudf;

import javax.swing.*;
import quick.dbtable.DBTable;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ButtonTable extends JFrame
{
  Random randomOrderNumber = new Random();
  private DBTable dBTable1 = new DBTable();

  public ButtonTable()
  {
    //set Frame properties
    setSize(425,250);
    setVisible(true);

    //set layout to flowlayout
    this.getContentPane().setLayout(new FlowLayout());

    //add dbtable to frame
    getContentPane().add(dBTable1);

    //Create buttons
    JButton addButton = new JButton("Add");
    JButton saveButton = new JButton("Save");
    JButton deleteButton = new JButton("Delete");

    dBTable1.setPreferredSize(new Dimension(400, 150));
    this.getContentPane().add(dBTable1);
    this.getContentPane().add(addButton);
    this.getContentPane().add(saveButton);
    this.getContentPane().add(deleteButton);

    // set the select statement which should be used by the table
   /* dBTable1.setSelectSql("SELECT Employee.Emp_Number, " +
                                  "Employee.Emp_Name, " +
                                  "Employee_status.Emp_Status " +
                          "FROM Employee , Employee_status " +
                          "WHERE Employee.Emp_Number = Employee_status.Emp_no");*/
    dBTable1.setSelectSql("select * from emp");

    //since 2 tables are involved in the above query , we need to add 2 update statements
   // dBTable1.addUpdateSql("update emp set emp_name =? where emp_id =?";         
    dBTable1.addUpdateSql("update emp set emp_name =? where emp_id =?", "2,1");
    //dBTable1.addUpdateSql("update Employee_status set emp_status=? where emp_no=?", "3,1");

    //Add the insert statements
    dBTable1.addInsertSql("insert into emp (emp_id, emp_name) values (?,?)", "1,2");
    //dBTable1.addInsertSql("insert into employee_status (emp_no, emp_status) values (?, ?)", "1,3");

    //Add delete statements
    dBTable1.addDeleteSql("delete from emp where emp_id = ?", "1");
 //   dBTable1.addDeleteSql("delete from Employee_status where emp_no = ?", "1");


    try
    {
      //set database properties
      /*  dBTable1.connectDatabase("org.hsqldb.jdbcDriver",
                "jdbc:hsqldb:file:src" + java.io.File.separatorChar + "main" + java.io.File.separatorChar + "resources" + java.io.File.separatorChar + "database" + java.io.File.separatorChar + "orderdb",
                "sa" ,"");
*/
    	  dBTable1.connectDatabase(
      	         "oracle.jdbc.driver.OracleDriver",
      	         "jdbc:oracle:thin:@192.168.25.18:1521/orcl",
      	         "BTW" ,
      	         "BTW");
      //fetch the data from database to fill the table
      dBTable1.refresh();
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    catch(ClassNotFoundException e)
    {
      e.printStackTrace();
    }

    //make all the columns to be editable
    dBTable1.setEditable(true);

    //we don't want the users to edit the primary column
    dBTable1.getColumn(0).setReadOnly(true);

    addButton.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e)
      {
        Vector emptyVector = new Vector();
        //this is just for example, don't follow this example of creating unique key because it may create duplicates
        emptyVector.addElement(new Integer(Math.abs(randomOrderNumber.nextInt()/100000)));
        emptyVector.addElement("");       //add employee name
        emptyVector.addElement("");       //add employee status

          dBTable1.insert(emptyVector);

        /*try
        {
          dBTable1.insert(emptyVector);
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null,ex.getMessage(),"Unable to insert!",JOptionPane.OK_OPTION);
        } */
	    }
    });

    deleteButton.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e)
      {
        try
        {
          dBTable1.delete(dBTable1.getSelectedRows());
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,ex.getMessage(),"Unable to delete!",JOptionPane.OK_OPTION);
        }
	    }
    });


    saveButton.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e)
      {
        dBTable1.save();
	    }
    });

  }

  public static void main(String[] args)
  {
    try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception e){}
    //create a new table frame
    ButtonTable myframe = new ButtonTable();
  }
}

