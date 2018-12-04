package com.LearningSpring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public Boolean addSillyMember() {
		System.out.println(getClass()+"Doing Stuff : Adding a membership account");
		return true ; 
	}
}
