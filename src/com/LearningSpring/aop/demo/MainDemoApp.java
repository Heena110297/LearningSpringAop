package com.LearningSpring.aop.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.LearningSpring.aop.dao.AccountDAO;
import com.LearningSpring.aop.dao.MembershipDAO;
import com.LearningSpring.aop.service.TrafficFortuneService;

public class MainDemoApp {
	 private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());
	public static void main(String[] args) {
       
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		/*
		 * AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		 * MembershipDAO theMembershipDAO = context.getBean("membershipDAO",
		 * MembershipDAO.class); // call the business method Account account = new
		 * Account(); account.setName("Madhu"); account.setLevel("Platinum");
		 * theAccountDAO.addAccount(account,true); theMembershipDAO.addSillyMember();
		 * theAccountDAO.setName("foobar"); theAccountDAO.setServiceCode("silver");
		 * 
		 * String name = theAccountDAO.getName(); String code =
		 * theAccountDAO.getServiceCode(); theAccountDAO.doWork();
		 * theMembershipDAO.goToSleep();
		 * 
		 */
		// close the context
		/*AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts = null;
		myLogger.info("\n\n Main Program: AfterThrowingDemoApp");
		try {
			boolean tripWire = true ;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exec) {
			myLogger.info("Exception Caught in Main Program");
		}
		/*
		 * myLogger.info("\n\n Main Program: AfterReturningDemoApp");
		 * myLogger.info("--------------"); myLogger.info(theAccounts);
		 * myLogger.info("\n");
		 */
		boolean tripwire = true ;
       TrafficFortuneService theFortuneService  = context.getBean("trafficFortuneService",TrafficFortuneService.class);
       myLogger.info("Main Program:  AroundDemo");
       myLogger.info("Calling Get Fortune");
       String data = null;
       try {
        data = theFortuneService.getFortune(tripwire);
       }
       catch(Exception exc) {
    	   myLogger.info("Finally exception caught");
       }
       myLogger.info("fortune is : "+data);
       myLogger.info("Finished");
		context.close();
	}

}
