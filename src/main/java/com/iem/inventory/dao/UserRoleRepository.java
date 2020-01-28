package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
}
