package com.iem.inventory.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "sales_order_details")
public class SalesOrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_detail_id")
	private Long saleOrderDetailId;
	
	@OneToOne
	@JoinColumn(name = "sales_order_id")
	public SalesOrder SalesOrder;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	public Customer customer;
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;

	
	@Column(name = "unit_amount")
	public double unitAmount;
	
	@Column(name = "total_amount")
	public double totalAmount;

	
	@UpdateTimestamp
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "status")
	private String status;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	
	public SalesOrderDetails() {
		
	}

	public Long getSaleOrderDetailId() {
		return saleOrderDetailId;
	}

	public void setSaleOrderDetailId(Long saleOrderDetailId) {
		this.saleOrderDetailId = saleOrderDetailId;
	}

	public SalesOrder getSalesOrder() {
		return SalesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		SalesOrder = salesOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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

}
