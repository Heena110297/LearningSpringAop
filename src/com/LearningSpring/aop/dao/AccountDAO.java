package com.LearningSpring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.LearningSpring.aop.demo.Account;

@Component
public class AccountDAO {
private String name;
private String serviceCode ;


public List<Account> findAccounts(){
	List<Account> myAccounts = new ArrayList<>();
	
	Account temp1 = new Account("John","Silver");
	Account temp2 = new Account("Madhu","Platinum");
	Account temp3 = new Account("Luca","Gold");
	myAccounts.add(temp1);
	myAccounts.add(temp2);
	myAccounts.add(temp3);
	return myAccounts ;
}

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
