package corejava.jdbc.pos;

public class Product {
	private int productId;
	private String name;
	private String uom;
	private double price;
	public Product(String name,String uom,double price){
		this.name = name;
		this.uom = uom;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getUom() {
		return uom;
	}
	public double getPrice() {
		return price;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
