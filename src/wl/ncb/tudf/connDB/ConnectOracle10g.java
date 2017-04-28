package wl.ncb.tudf.connDB;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
public class ConnectOracle10g {
	static Logger log = Logger.getLogger(ConnectOracle10g.class.getName());

	private String dbdriver;
	private String dbhost;
	private String dbport;
	private String dbsid;
	private String dbusername;
	private String dbpassword;
	private Connection conn;

	public ConnectOracle10g(String driver, String host, String port,
			String sid, String username, String password) {
		dbdriver = driver;
		dbhost = host;
		dbport = port;
		dbsid = sid;
		dbusername = username;
		dbpassword = password;

	}
	
	


	public Connection opendborcl10g()  throws Exception {
		conn = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

			// Connection conn = DriverManager.getConnection(
			// "jdbc:oracle:thin:@192.168.25.18:1521/orcl", "BTW", "BTW");
		       conn = DriverManager.getConnection(""+dbdriver+":@"+ dbhost + ":" + dbport+ "/" + dbsid + "",dbusername,dbpassword);
		       if (conn == null) {
	              // throw new SQLException("Cannot initail database connection, because it's NULL.");
	               log.debug("Cannot initail database connection, because it's NULL.");
	               System.out.println("Cannot initail database connection, because it's NULL.");
	             
	           }else{
	        	   log.debug("Connected initail database");
	        	   System.out.println("onnected initail database");
	        	  
	        	   
	        	   
	           }
	        	   
			
			return conn;

		} catch (Exception e) {
			return null;
		}
	}
	
    public static void closeConnorcl10g(Connection conn) throws Exception {
        if (conn != null) {
            System.out.println("#: Database connection {"+conn+"} has been droped.");
        	log.debug("disconnect oracle database 10g");
            conn.close();
        }
    }
    
    public String toString(){
    	String str = "Connect Oracle Database10g";
       str += " Driver="+dbdriver;
    	str += " Host="+dbhost;
        str += " Port="+dbport;
    	str += " Sid="+dbsid;
    	str += " Username="+dbusername;
    	str += " Password="+dbpassword;
    	
    	
     return str;
    }
	

}
