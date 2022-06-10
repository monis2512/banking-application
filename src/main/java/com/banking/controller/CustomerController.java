package com.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.CustomerDTO;
import com.banking.exception.CustomerException;
import com.banking.service.CustomerService;

@RestController
@RequestMapping("/banking-controller")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO dto) throws CustomerException {
		
		String response=service.addCustomer(dto);
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO dto) throws CustomerException {
		
		String response=service.updateCustomer(dto);
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("getCustomer/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws CustomerException {
		
		CustomerDTO dto=service.getCustomer(customerId);
		
		return new ResponseEntity<CustomerDTO>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws CustomerException {
		
		String response=service.deleteCustomer(customerId);
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	
}
