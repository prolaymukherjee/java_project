import java.sql.*;
import javax.swing.*;
public class SConnection {
	
	Connection connection=null;
	
public static Connection DConnector1(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\LENOVO\\Documents\\DataB\\LTable1.sqlite");
			JOptionPane.showMessageDialog(null, "successful");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	

}
