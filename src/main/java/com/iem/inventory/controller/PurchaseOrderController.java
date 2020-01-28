package com.iem.inventory.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iem.inventory.entity.PurchaseOrder;
import com.iem.inventory.entity.Supplier;
import com.iem.inventory.service.PurchaseOrderService;
import com.iem.inventory.service.SupplierService;

@Controller
public class PurchaseOrderController {
	
private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);
	
	@Autowired
	private PurchaseOrderService service;
	
	@RequestMapping("/purchases")
	public ResponseEntity<List<PurchaseOrder>> getPurchases() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping("/purchaseorder")
    public ResponseEntity create(@Valid @RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(service.save(purchaseOrder));
    }

    @GetMapping("/purchases/{id}")
    public ResponseEntity<PurchaseOrder> findById(@PathVariable Long id) {
        Optional<PurchaseOrder> purchaseOrder = service.findById(id);
        if (!purchaseOrder.isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(purchaseOrder.get());
    }

    @PutMapping("/purchaseorder/update/{id}")
    public ResponseEntity<PurchaseOrder> update(@PathVariable Long id, @Valid @RequestBody PurchaseOrder purchaseOrder) {
        if (!service.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.save(purchaseOrder));
    }

    @DeleteMapping("/purchaseorder/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
	

}
