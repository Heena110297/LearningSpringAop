package com.LearningSpring.aop.dao;

import org.springframework.stereotype.Component;

import com.LearningSpring.aop.demo.Account;

@Component
public class AccountDAO {
private String name;
private String serviceCode ;


	public String getName() {
		System.out.println("getter method");
	return name;
}

public void setName(String name) {
	System.out.println("setter method");
	this.name = name;
}

public String getServiceCode() {
	System.out.println("getter method");
	return serviceCode;
}

public void setServiceCode(String serviceCode) {
	System.out.println("setter method");
	this.serviceCode = serviceCode;
}

	public void addAccount(Account theAccount, Boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass()+ "Doing Work");
		return false;
		
	}
}
