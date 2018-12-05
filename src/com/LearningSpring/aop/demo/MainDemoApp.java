package com.LearningSpring.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.LearningSpring.aop.dao.AccountDAO;
import com.LearningSpring.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
	/*	AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		theAccountDAO.addAccount(account,true);
		theMembershipDAO.addSillyMember();
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
	  String name =  theAccountDAO.getName();
	  String code = theAccountDAO.getServiceCode();
 theAccountDAO.doWork();
 theMembershipDAO.goToSleep();
		
				*/
		// close the context
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account>  theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\n Main Program: AfterReturningDemoApp");
		System.out.println("--------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		context.close();
	}

}










