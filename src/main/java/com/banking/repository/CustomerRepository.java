package com.banking.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banking.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>{
	
	@Query("UPDATE CustomerEntity customerEntity SET customerEntity.phoneNo=:phoneNo WHERE customerEntity.customerId=:customerId")
	@Modifying
	@Transactional
	public Integer updatePhoneNumber(@Param("phoneNo") Long phoneNo,@Param("customerId") Integer customerId);
	
	@Query("UPDATE CustomerEntity customerEntity SET customerEntity.emailId=:emailId WHERE customerEntity.customerId=:customerId")
	@Modifying
	@Transactional
	public Integer updateEmailId(@Param("emailId") String emailId,@Param("customerId") Integer customerId);
	
	
	@Query("UPDATE CustomerEntity customerEntity SET customerEntity.age=:age WHERE customerEntity.customerId=:customerId")
	@Modifying
	@Transactional
	public Integer updateAge(@Param("age") Integer age,@Param("customerId") Integer customerId);
	

}
