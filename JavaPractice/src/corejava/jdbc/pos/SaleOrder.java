package corejava.jdbc.pos;

import java.util.Date;
import java.util.List;

public class SaleOrder {
	private int orderId;
	private Date saleDate;
	private int itemCount;
	private double cost;
	private List<LineItem> lineItems;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public java.sql.Date getOrderDate() {
		return new java.sql.Date(saleDate.getTime());
	}
}
