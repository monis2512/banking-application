package com.banking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CustomerDTO {
	
	private Integer customerId;
	@NotEmpty(message = "{name.absent}")
	private String name;
	@Email(message = "{email.format.invalid}")
	private String emailId;
	private Long phoneNo;
	private Integer age;
	
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
