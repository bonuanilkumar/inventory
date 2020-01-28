package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>{

}
