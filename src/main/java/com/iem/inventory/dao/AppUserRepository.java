package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	

}
