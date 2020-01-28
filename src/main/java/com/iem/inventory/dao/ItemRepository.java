package com.iem.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iem.inventory.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
