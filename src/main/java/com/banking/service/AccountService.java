package com.banking.service;

import com.banking.dto.AccountDTO;
import com.banking.exception.CustomerException;

public interface AccountService {
	
	public String createAccount(AccountDTO dto) throws CustomerException;
	
	public Long getBalance(Integer accountId) throws CustomerException;

}
