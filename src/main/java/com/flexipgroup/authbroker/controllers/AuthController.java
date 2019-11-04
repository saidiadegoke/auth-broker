package com.flexipgroup.authbroker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tests")
public class AuthController {
	
	@GetMapping
	public String getTest() {
		return "Return stirng here";
	}

}
