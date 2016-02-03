package corejava.jdbc.pos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POSDao {
	public POSDao() throws IOException {
		Properties props = new Properties();
		FileInputStream fin = new FileInputStream("dsn.properties");
		props.load(fin);
		
		url = props.getProperty("url");
		user = props.getProperty("user");
		pwd = props.getProperty("pwd");
	}
	public List<Product> loadProducts(){
		List<Product> productList = null;
		try(Connection conn = getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			productList = new ArrayList<Product>();
			Product prodObj;
			while(rs.next()) {
				prodObj = new Product(rs.getString("PRODUCT_NAME"),getUomDesc(conn,rs.getInt("UOM")),rs.getDouble("PRICE"));
				prodObj.setProductId(rs.getInt("PRODUCT_ID"));
				productList.add(prodObj);
			}
			
		} catch(SQLException ex){
			ex.printStackTrace();
		}
		return productList;
	}
	private String getUomDesc(Connection conn,int uomId) throws SQLException{
		String desc = "";
		PreparedStatement stmt = conn.prepareStatement("select UOM_DESC from uom where UOM_ID=?");
		stmt.setInt(1, uomId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
			desc = rs.getString(1);
		return desc;
	}
	public void saveOrder(SaleOrder order) {
		try(Connection conn = getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("insert into saleorder(COST,saleDate,ITEM_COUNT) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, order.getCost());
			stmt.setDate(2, order.getOrderDate());
			stmt.setInt(3,order.getLineItems().size());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			int orderId = 0;
			if(rs.next())
				orderId = rs.getInt(1);
			order.setOrderId(orderId);
			List<LineItem> items = order.getLineItems();
			for(LineItem item:items) {
				item.setOrder(order);
				saveLineItem(conn,item);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	private void saveLineItem(Connection conn,LineItem item) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into lineitem(PRODUCT,QUANTITY,COST,SALEORDER) values(?,?,?,?)");
		stmt.setInt(1, item.getProduct().getProductId());
		stmt.setDouble(2, item.getQuantity());
		stmt.setDouble(3, item.getCost());
		stmt.setInt(4, item.getOrder().getOrderId());
		stmt.executeUpdate();
	}
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user,pwd);
	}
	private String url;
	private String user;
	private String pwd;
}
