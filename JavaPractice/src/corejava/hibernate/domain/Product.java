package corejava.hibernate.domain;

public class Product {
	private int id;
	private String name;
	private double price;
	private Uom uom;
	
	public Product(){
		
	}
	public Product(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	@Override
	public String toString() {
		return "[ID :"+id+" Name :"+name+" Price :"+price+" UOM :"+uom+"]";
	}
	
	
}
