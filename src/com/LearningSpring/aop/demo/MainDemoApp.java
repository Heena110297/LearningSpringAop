package com.LearningSpring.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.LearningSpring.aop.dao.AccountDAO;
import com.LearningSpring.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		Account account = new Account();
		
		theAccountDAO.addAccount(account,true);
		theMembershipDAO.addSillyMember();
 theAccountDAO.doWork();
 theMembershipDAO.goToSleep();
		
				
		// close the context
		context.close();
	}

}










