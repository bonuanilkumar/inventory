package com.iem.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iem.inventory.dao.PurchaseOrderRepository;
import com.iem.inventory.entity.PurchaseOrder;

@Service
public class PurchaseOrderService {
	
	private PurchaseOrderRepository repository;
	
	public PurchaseOrderService(PurchaseOrderRepository repository) {
		this.repository = repository;
	}
	
	public Optional<PurchaseOrder> findById(Long id) {
        return repository.findById(id);
    }

    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    public void deleteById(Long id) {
    	repository.deleteById(id);
    }
    
    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

}
