package com.iem.inventory.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id")
	private Item itemId;
	
	
	private int quantity;
	
	@Column(name="avg_price")
	private double avgPrice;
	
	private String batch;
	
	@UpdateTimestamp
    @Column(name = "updated_date")
    private Date lastUpdatedDate;

    @Column(name = "updated_by")
    private String lastUpdatedBy;
    
    public Inventory() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
    
    
	
	
	
}
