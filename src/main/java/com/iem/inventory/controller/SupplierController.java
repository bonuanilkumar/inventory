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

import com.iem.inventory.entity.Supplier;
import com.iem.inventory.service.SupplierService;

@Controller
public class SupplierController {
	
private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/suppliers")
	public ResponseEntity<List<Supplier>> getSuppliers() {
		return ResponseEntity.ok(supplierService.findAll());
	}
	
	@PostMapping("/addsupplier")
    public ResponseEntity create(@Valid @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.save(supplier));
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Long id) {
        Optional<Supplier> supplier = supplierService.findById(id);
        if (!supplier.isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(supplier.get());
    }

    @PutMapping("/suppliers/update/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @Valid @RequestBody Supplier supplier) {
        if (!supplierService.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(supplierService.save(supplier));
    }

    @DeleteMapping("/suppliers/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!supplierService.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        supplierService.deleteById(id);

        return ResponseEntity.ok().build();
    }
	

}
