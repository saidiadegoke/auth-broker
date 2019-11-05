package com.flexipgroup.app.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tests")
public class AuthController {
	
	@GetMapping
	public String getAuthentication() {
		return "get Authentication";
	}
	
	@PostMapping
	public String createAuthentication ()
	{
		return "create Authentication";
	}
	
	
	@PutMapping
	public String updateAuthentication () 
	{
		return "request Authentication";
	}
	
	
	@DeleteMapping
	public String deleteAuthentication ()
	{
		return "delete Authentication";
	}

}
