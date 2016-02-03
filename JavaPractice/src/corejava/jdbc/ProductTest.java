package corejava.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class ProductTest {

	public static void main(String[] args) {
		try (Connection c = getConnection();){
			addUom(c,"test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void addUom(Connection conn,String description) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into uom(UOM_DESC) values(?)",Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, description);
		int i = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(i > 0) {
			rs.next();
			System.out.println("Inserted the UOM "+description+" "+rs.getInt(1));
		}
	}
	
	private static Connection getConnection() throws IOException, SQLException{
		Connection conn = null;
		
		Properties props = new Properties();
		FileInputStream fin = new FileInputStream("dsn.properties");
		props.load(fin);
		
		String url = props.getProperty("url");
		String user = props.getProperty("user");
		String pwd = props.getProperty("pwd");
		
		conn = DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}

}
