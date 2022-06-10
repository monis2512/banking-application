package com.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer>{

}
