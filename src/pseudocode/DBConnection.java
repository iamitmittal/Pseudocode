package pseudocode;
import java.sql.*;
public class DBConnection {
		
		static Connection con;
		
	public static Connection createC() {	
		try {			
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-R80A2UL:1521:xe","Sys as SYSDBA","admin"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
