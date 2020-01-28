package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}