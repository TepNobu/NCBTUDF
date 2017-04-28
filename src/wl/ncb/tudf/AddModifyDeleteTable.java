package wl.ncb.tudf;


import javax.swing.*;
import quick.dbtable.*;

import java.awt.Dimension;
import java.sql.*;

public class AddModifyDeleteTable extends JFrame
{
   public AddModifyDeleteTable()
   {
      //set Frame properties
      setSize(300,200);
      setVisible(true);

      //create a new quicktable
      quick.dbtable.DBTable dBTable1 = new quick.dbtable.DBTable();

      //add to frame
      getContentPane().add(dBTable1);
  //    JButton saveButton = new JButton("Save");
      
   //   dBTable1.setPreferredSize(new Dimension(400, 150));
    //  this.getContentPane().add(dBTable1);
     // this.getContentPane().add(addButton);
    //  this.getContentPane().add(saveButton);
      //this.getContentPane().add(deleteButton);

      //to create the navigation bars for the table
     dBTable1.createControlPanel();

      // set the select statement which should be used by the table
    /*  dBTable1.setSelectSql("SELECT Employee.Emp_Number, " +
                                                      "Employee.Emp_Name, " +
                                                      "Employee_status.Emp_Status " +
                                        "FROM Employee , Employee_status " +
                                        "WHERE Employee.Emp_Number = Employee_status.Emp_no");
      */
      dBTable1.setSelectSql("select * from emp");

      //since 2 tables are involved in the above query , we need to add 2 update statements
      dBTable1.addUpdateSql("update emp set emp_name =? where emp_id =?",                                            "2,1");
     // dBTable1.addUpdateSql("update Employee_status set emp_status=? where emp_no=?",                                             "3,1");

      //Add the insert statements
      dBTable1.addInsertSql("insert into emp (emp_id, emp_name) values (?,?)",                                            "1,2");
     // dBTable1.addInsertSql("insert into employee_status (emp_no, emp_status) values (?, ?)",                                            "1,3");

      //Add delete statements
      dBTable1.addDeleteSql("delete from emp where emp_id = ?", "1");
     // dBTable1.addDeleteSql("delete from emp where emp_no = ?", "1");

      try
      {
         //set database properties
        
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

      //some jdbc drivers don't give the correct meta data for editable property of a column
      dBTable1.getColumn(0).setReadOnly(false);
      dBTable1.getColumn(1).setReadOnly(false);
      dBTable1.getColumn(2).setReadOnly(false);

   }

   public static void main(String[] args)
   {
      //create a new table frame
      AddModifyDeleteTable myframe = new AddModifyDeleteTable();
   }
}

