package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnect {

	public Connection connect(){
		Connection conn = null;
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; // DB URL

		// Driver Found
		try{
			Class.forName("oracle.jdbc.OracleDriver"); // JDBC DRIVER
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}

		// DriverManager getConnection
		try{

			conn = DriverManager.getConnection(dbUrl, "CHEN", "1234"); // database connection

		}catch(Exception e){
			e.printStackTrace();
		}finally{

		}

		return conn;
	}
}
