package com.iem.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/")
	public String home() {
		logger.debug("Sample log");
		return "index";
	}

}