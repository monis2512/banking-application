package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.AccountDTO;
import com.banking.entity.AccountEntity;
import com.banking.exception.CustomerException;
import com.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	private static Integer number=10;
	private static Integer accNumber;
	
	@Autowired
	private AccountRepository repo;
	
	@Override
	public String createAccount(AccountDTO dto) throws CustomerException {
		// TODO Auto-generated method stub
		
		Integer acNumber=AccountServiceImpl.generateAccountNumber();
		AccountEntity accountEntity=new AccountEntity();
		
		accountEntity.setAccountNumber(acNumber);
		accountEntity.setAccountType(dto.getAccountType());
		accountEntity.setBalance(dto.getBalance());
		accountEntity.setCustomerId(dto.getCustomerId());
		repo.save(accountEntity);
		return "Account created";
	}
	
	public static Integer generateAccountNumber() {
		number++;
		AccountServiceImpl.accNumber=number;
		return AccountServiceImpl.accNumber;
	}

	@Override
	public Long getBalance(Integer accountId) throws CustomerException {
		
		Optional<AccountEntity> opt=repo.findById(accountId);
		
		AccountEntity entity=opt.orElseThrow(()->new CustomerException("ACCOUNT.NOT.FOUND"));
		
		if(entity.getAccountType().equalsIgnoreCase("Loan"))	
			throw new CustomerException("ACCOUNT.TYPE.INVALID");
		
		Long balance=entity.getBalance();
		
		
		return balance;
	}

}
