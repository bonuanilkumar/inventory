package com.iem.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iem.inventory.dao.UserRoleRepository;
import com.iem.inventory.entity.UserRole;

@Service
public class UserRoleService {

	private final UserRoleRepository userRoleRepository;
	
	public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

	public List<UserRole> findAll() {
		return userRoleRepository.findAll();
	}

}
