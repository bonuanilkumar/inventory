package com.iem.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iem.inventory.dao.SupplierRepository;
import com.iem.inventory.entity.Supplier;

@Service
public class SupplierService {
	
	private SupplierRepository supplierRepository;
	
	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteById(Long id) {
    	supplierRepository.deleteById(id);
    }
    
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

}
