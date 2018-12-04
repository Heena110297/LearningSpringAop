package com.LearningSpring.aop.dao;

import org.springframework.stereotype.Component;

import com.LearningSpring.aop.demo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, Boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ "Doing Work");
		return false;
		
	}
}
