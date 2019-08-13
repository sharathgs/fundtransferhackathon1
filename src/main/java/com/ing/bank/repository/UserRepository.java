package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	public User findByaccountNo(long accountNo);
}
