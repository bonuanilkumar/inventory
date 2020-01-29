package com.iem.inventory.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_detail_id")
	private Long purchaseOrderDetailsId;

	@ManyToOne
	@JoinColumn(name = "purchase_order_id")
	public PurchaseOrder purchaseOrder;

	@OneToOne
	@JoinColumn(name = "supplier_id")
	public Supplier supplier;

	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "unit_amount")
	private double unitAmount;

	@Column(name = "total_amount")
	private double totalAmount;

	private int quantity;

	@UpdateTimestamp
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "status")
	private String status;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	public PurchaseOrderDetails() {

	}

	public Long getPurchaseOrderDetailsId() {
		return purchaseOrderDetailsId;
	}

	public void setPurchaseOrderDetailsId(Long purchaseOrderDetailsId) {
		this.purchaseOrderDetailsId = purchaseOrderDetailsId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getItemAmount() {
		return unitAmount;
	}

	public void setItemAmount(double itemAmount) {
		this.unitAmount = itemAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
