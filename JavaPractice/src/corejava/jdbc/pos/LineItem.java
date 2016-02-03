package corejava.jdbc.pos;

public class LineItem {
	private Product product;
	private double quantity;
	private double cost;
	private SaleOrder order;
	public LineItem(){
		this(new Product("","",0.0));
	}
	public LineItem(Product product){
		this.product = product;
		
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductName() {
		return product.getName();
	}
	
	public String getUom() {
		return product.getUom();
	}
	
	public double getPrice() {
		return product.getPrice();
	}
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
		this.cost = quantity*product.getPrice();
	}
	public double getCost() {
		return cost;
	}
	public SaleOrder getOrder() {
		return order;
	}
	public void setOrder(SaleOrder order) {
		this.order = order;
	}
	
}
