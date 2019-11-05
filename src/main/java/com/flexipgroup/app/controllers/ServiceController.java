package com.flexipgroup.app.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services")
public class ServiceController {
	
	
	@GetMapping
	public String index() {
		return "Serivces Controller Get";
	}
	
	@PostMapping
	public String createService ()
	{
		return "create service";
	}
	
	
	@PutMapping
	public String updateService () 
	{
		return "request service update";
	}
	
	
	@DeleteMapping
	public String deleteService ()
	{
		return "service deleted";
	}
	
}
