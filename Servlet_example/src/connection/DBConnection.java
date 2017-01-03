package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection OracleConnect() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;
		
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; // DB URL
		
		Class.forName("oracle.jdbc.OracleDriver"); // JDBC DRIVER
		
		conn = DriverManager.getConnection(dbUrl, "dasom", "dasom1204");
		
		return conn;
	}

}
