package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{

}
