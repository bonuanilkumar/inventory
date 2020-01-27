CREATE USER 'coromandel'@'localhost' IDENTIFIED BY 'Abcd$1234';

GRANT ALL
  ON *.*
  TO 'coromandel'@'localhost'
  WITH GRANT OPTION;

  DROP DATABASE cgc;
  CREATE DATABASE cgc;
  
  USE cgc;

DROP TABLE IF EXISTS purchase_order_details;
DROP TABLE IF EXISTS sales_order_details;
DROP TABLE IF EXISTS purchase_order;
DROP TABLE IF EXISTS sales_order;  
DROP TABLE IF EXISTS tax_type;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS customer;  

CREATE TABLE `cgc`.`tax_type` (
  `tax_id` INT NOT NULL AUTO_INCREMENT,
  `type` INT NOT NULL,
  `percentage` DOUBLE NULL DEFAULT 0,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `created_date` VARCHAR(45) NOT NULL,
  `updated_by` VARCHAR(45) NOT NULL,
  `updated_date` DATETIME NOT NULL,
  PRIMARY KEY (`tax_id`),
  UNIQUE INDEX `id_UNIQUE` (`tax_id` ASC) VISIBLE);

CREATE TABLE `cgc`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE);
  
INSERT INTO user_role(role, created_by) values ('Admin', 'superuser');

CREATE TABLE `cgc`.`app_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) VISIBLE,
  INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `id`
    FOREIGN KEY (`role_id`)
    REFERENCES `cgc`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
    
INSERT INTO `cgc`.`app_user`(`user_name`,`password`,`role_id`,`created_by`)
VALUES('admin','company',1,'superuser');

-- Item table contains all the products handled by the application

CREATE TABLE `cgc`.`item` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(90) NOT NULL,
  `category` VARCHAR(90) NULL,
  `last_updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE INDEX `item_name_UNIQUE` (`item_name` ASC) VISIBLE); 
  
CREATE TABLE `cgc`.`supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_name` VARCHAR(90) NOT NULL,
  `phonenumber` VARCHAR(20) NOT NULL,
  `address` VARCHAR(90) NULL,
  `contact_name` VARCHAR(90) NULL,
  `mobile` VARCHAR(20) NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  UNIQUE INDEX `supplier_id_UNIQUE` (`supplier_id` ASC) VISIBLE,
  UNIQUE INDEX `supplier_name_UNIQUE` (`supplier_name` ASC) VISIBLE);
  
CREATE TABLE `cgc`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(90) NOT NULL,
  `phonenumber` VARCHAR(20) NOT NULL,
  `address` VARCHAR(90) NULL,
  `contact_name` VARCHAR(90) NULL,
  `mobile` VARCHAR(20) NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC) VISIBLE,
  UNIQUE INDEX `customer_name_UNIQUE` (`customer_name` ASC) VISIBLE);
  
CREATE TABLE `cgc`.`inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  `avg_price` VARCHAR(45) NOT NULL DEFAULT 0,
  `batch` VARCHAR(45) NULL,
  `updated_date` DATETIME NULL,
  `updated_by` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `item_id_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `cgc`.`item` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
   
ALTER TABLE `cgc`.`inventory` 
ADD PRIMARY KEY (`id`);
;    
    
CREATE TABLE `cgc`.`purchase_order` (
  `purchase_order_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id` INT NOT NULL,
  `total_amount` DOUBLE NOT NULL DEFAULT 0,
  `tax_amount` DOUBLE NULL,
  `order_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_by` VARCHAR(45) NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'CREATED',
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchase_order_id`),
  UNIQUE INDEX `purchase_order_id_UNIQUE` (`purchase_order_id` ASC) VISIBLE,
  INDEX `supplier_id_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `supplier_id`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `cgc`.`supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
 CREATE TABLE `cgc`.`purchase_order_details` (
  `po_detail_id` INT NOT NULL AUTO_INCREMENT,
  `purchase_order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `supplier_id` INT NOT NULL,
  `unit_amount` DOUBLE NOT NULL DEFAULT 0,
  `total_amount` DOUBLE NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'CREATED',
  `last_updated_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`po_detail_id`),
  UNIQUE INDEX `po_detail_id_UNIQUE` (`po_detail_id` ASC) VISIBLE,
  INDEX `purchase_order_id_idx` (`purchase_order_id` ASC) VISIBLE,
  INDEX `supplier_id_idx` (`supplier_id` ASC) VISIBLE,
  INDEX `item_id_idx` (`item_id` ASC) VISIBLE,
	FOREIGN KEY (`purchase_order_id`)
    REFERENCES `cgc`.`purchase_order` (`purchase_order_id`),
    FOREIGN KEY (`supplier_id`)
    REFERENCES `cgc`.`supplier` (`supplier_id`),
    FOREIGN KEY (`item_id`)
    REFERENCES `cgc`.`item` (`item_id`));   


CREATE TABLE `cgc`.`sales_order` (
  `sales_order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `total_amount` DOUBLE NOT NULL DEFAULT 0,
  `tax_amount` DOUBLE NULL,
  `sale_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sold_by` VARCHAR(45) NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'CREATED',
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `received_by` VARCHAR(45),
  PRIMARY KEY (`sales_order_id`),
  UNIQUE INDEX `sales_order_id_UNIQUE` (`sales_order_id` ASC) VISIBLE,
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `cgc`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
 CREATE TABLE `cgc`.`sales_order_details` (
  `sale_detail_id` INT NOT NULL AUTO_INCREMENT,
  `sales_order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `unit_amount` DOUBLE NOT NULL DEFAULT 0,
  `total_amount` DOUBLE NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'CREATED',
  `last_updated_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sale_detail_id`),
  UNIQUE INDEX `sale_detail_id_UNIQUE` (`sale_detail_id` ASC) VISIBLE,
  INDEX `sales_order_id_idx` (`sales_order_id` ASC) VISIBLE,
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `item_id_idx` (`item_id` ASC) VISIBLE,
	FOREIGN KEY (`sales_order_id`)
    REFERENCES `cgc`.`sales_order` (`sales_order_id`),
    FOREIGN KEY (`customer_id`)
    REFERENCES `cgc`.`customer` (`customer_id`),
    FOREIGN KEY (`item_id`)
    REFERENCES `cgc`.`item` (`item_id`));   

  
  