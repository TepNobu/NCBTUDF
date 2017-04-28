package wl.ncb.tudf.connDB;

import java.sql.Connection;

public class ConnectDB10g {
	

	private static Connection conn = null;

	public ConnectDB10g(Connection conndb) {
		conn = conndb;
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conndb) {
		conn = conndb;
	}


}
