package com.iem.inventory.model;

import java.util.List;

public class PurchaseOrderRequest {

	private long supplierId;

	private double totalAmount;

	private double taxAmount;

	private String status;

	private String orderBy;

	private List<PurchaseOrderDetailRequest> orderDetails;

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<PurchaseOrderDetailRequest> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<PurchaseOrderDetailRequest> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "PurchaseOrderRequest [supplierId=" + supplierId + ", totalAmount=" + totalAmount + ", taxAmount="
				+ taxAmount + ", status=" + status + ", orderBy=" + orderBy + ", orderDetails=" + orderDetails + "]";
	}

}

class PurchaseOrderDetailRequest {

	private Long itemId;

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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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
		return "PurchaseOrderDetailRequest [itemId=" + itemId + ", unitAmount=" + unitAmount + ", totalAmount="
				+ totalAmount + ", status=" + status + ", quantity=" + quantity + "]";
	}

}
