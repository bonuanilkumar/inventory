package com.iem.inventory.model;

import java.util.List;

public class SenderOrderRequest {

	private long customerId;
	private double totalAmount;
	private double taxAmount;
	private String soldBy;

	private List<SalesOrderDetailRequest> orderDetails;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public List<SalesOrderDetailRequest> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<SalesOrderDetailRequest> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "SenderOrderRequest [customerId=" + customerId + ", totalAmount=" + totalAmount + ", taxAmount="
				+ taxAmount + ", soldBy=" + soldBy + ", orderDetails=" + orderDetails + "]";
	}
	
	

}

class SalesOrderDetailRequest {

	private long itemId;
	private double unitAmount;
	private double totalAmount;
	private String status;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SalesOrderDetailRequest [itemId=" + itemId + ", unitAmount=" + unitAmount + ", totalAmount="
				+ totalAmount + ", status=" + status + ", quantity=" + quantity + "]";
	}
	
	

}
