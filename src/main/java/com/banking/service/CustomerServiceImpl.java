package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.exception.CustomerException;
import com.banking.dto.CustomerDTO;
import com.banking.entity.CustomerEntity;
import com.banking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public String addCustomer(CustomerDTO dto) throws CustomerException{
		// TODO Auto-generated method stub
		
		String phoneNumber=String.valueOf(dto.getPhoneNo());
		
		if(phoneNumber.length()!=10) {
			throw new CustomerException("CUSTOMER.INVALID_PHONENO");
		}
		
		CustomerEntity entity=new CustomerEntity();
		entity.setAge(dto.getAge());
		entity.setEmailId(dto.getEmailId());
		entity.setName(dto.getName());
		entity.setPhoneNo(dto.getPhoneNo());
		
		CustomerEntity savedCustomer=repository.save(entity);
		
		return "Customer saved successfully with cust Id : "+savedCustomer.getCustomerId();
	}

	@Override
	public String updateCustomer(CustomerDTO dto) throws CustomerException{
		String s="";
		
		Optional<CustomerEntity> opt=repository.findById(dto.getCustomerId());
		
		CustomerEntity customerEntity=opt.orElseThrow(()-> new CustomerException("CUSTOMER.NOT_FOUND"));
		
;		if(dto.getPhoneNo()!=null) {
			repository.updatePhoneNumber(dto.getPhoneNo(), dto.getCustomerId());
			s="Phone number updated successfully";
		}
		else if(dto.getEmailId()!=null) {
			repository.updateEmailId(dto.getEmailId(), dto.getCustomerId());
			s="Email Id updated successfully";
		}
		else if(dto.getAge()!=null) {
			repository.updateAge(dto.getAge(), dto.getCustomerId());
			s="Age updated successfully";
		}
		
		return s;
	}

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws CustomerException {
		
		Optional<CustomerEntity> optional = repository.findById(customerId);
		
		CustomerEntity customerEntity = optional.orElseThrow(()->new CustomerException("CUSTOMER.NOT_FOUND"));
		CustomerDTO dto=new CustomerDTO();
		dto.setCustomerId(customerEntity.getCustomerId());
		dto.setAge(customerEntity.getAge());
		dto.setEmailId(customerEntity.getEmailId());
		dto.setName(customerEntity.getName());
		dto.setPhoneNo(customerEntity.getPhoneNo());
		return dto;
	}

	@Override
	public String deleteCustomer(Integer customerId) throws CustomerException {
		Optional<CustomerEntity> optional = repository.findById(customerId);
		CustomerEntity customerEntity=optional.orElseThrow(()->new CustomerException("CUSTOMER.NOT_FOUND"));
		
		repository.deleteById(customerEntity.getCustomerId());
		
		return "Customer Deleted Successfully";
	}
	
	 

}
