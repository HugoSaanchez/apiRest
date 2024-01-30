package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerDTO;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestCustomer {
	
	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<CustomerDTO> getCustomers(){
		return customerService.listAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public CustomerDTO getCustomer(@PathVariable int customerId) {
		return customerService.findCustomerByIdModel(customerId);
	}
	
	@PostMapping("/newcustomers")
	public CustomerDTO createCustomer(@RequestBody CustomerDTO customer) {
		customerService.addCustomer(customer);
		return customer;
	}
	
	@PutMapping("/updatecustomers")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
		customerService.addCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/deletecustomers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.removeCustomer(customerId);
	}
	
	@GetMapping("/listCustomers")
	public ResponseEntity<?> getListCustomers(){
		List<CustomerDTO> list=customerService.listAllCustomers();
		if(list.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(list);
		
	}
	
	
	
	
	

}
