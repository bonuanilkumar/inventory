package com.iem.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iem.inventory.entity.UserRole;
import com.iem.inventory.service.UserRoleService;

@Controller
public class UserRoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@Autowired
	private UserRoleService roleService;
	
	@RequestMapping("/roles")
	public ResponseEntity<List<UserRole>> getUserRoles() {
		logger.debug("User Roles log");
		return ResponseEntity.ok(roleService.findAll());
	}
	
	

}
