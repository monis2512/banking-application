package com.banking.service;

import com.banking.dto.CustomerDTO;
import com.banking.exception.CustomerException;

public interface CustomerService {
	
	public String addCustomer(CustomerDTO dto) throws CustomerException;
	public String updateCustomer(CustomerDTO dto) throws CustomerException;
	public CustomerDTO getCustomer(Integer customerId) throws CustomerException;
	public String deleteCustomer(Integer customerId) throws CustomerException;

}
