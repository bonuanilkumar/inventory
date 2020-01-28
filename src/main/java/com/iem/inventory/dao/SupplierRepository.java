package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
