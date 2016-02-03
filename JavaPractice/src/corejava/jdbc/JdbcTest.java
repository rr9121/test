package corejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
		String user = "root";
		String pwd = "password";
		//Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(url,user, pwd);){
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");
			
			while(rs.next()) {
				for(int i=1;i<=4;i++) {
					System.out.print(rs.getString(i)+", ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}*/
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {}
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {}
		}

	}

}
