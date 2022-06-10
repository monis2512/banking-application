package com.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.AccountDTO;
import com.banking.exception.CustomerException;
import com.banking.service.AccountServiceImpl;

@RestController
@RequestMapping("/account-controller")
public class AccountController {

	
	@Autowired
	private AccountServiceImpl service;

	@PostMapping("/addAccount")
	public ResponseEntity<String> addAccount(@Valid @RequestBody AccountDTO dto) throws CustomerException {
		
		String response=service.createAccount(dto);
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("getBalance/{accountId}")
	public ResponseEntity<Long> getCustomer(@PathVariable Integer accountId) throws CustomerException {
		
		Long balance=service.getBalance(accountId);
		
		return new ResponseEntity<Long>(balance,HttpStatus.OK);
	}
	
}
