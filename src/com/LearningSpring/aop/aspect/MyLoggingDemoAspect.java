package com.LearningSpring.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.LearningSpring.aop.demo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.LearningSpring.aop.dao.*.*(..))")
	private void forDaoPackage() {

	}

	@Pointcut("execution(* com.LearningSpring.aop.dao.*.get*(..))")
	private void getter() {

	}

	@Pointcut("execution(* com.LearningSpring.aop.dao.*.set*(..))")
	private void setter() {

	}

	@Pointcut("(forDaoPackage() && !(getter() || setter()))")
	private void forDaoPackageNoGetterAndSetter() {

	}

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.LearningSpring.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*(com.LearningSpring.aop.demo.Account,..))")
	// @Before("execution(* add*(..))")

	/*
	 * @Before("forDaoPackageNoGetterAndSetter()") public void
	 * beforeAddAccountAdvice() {
	 * 
	 * myLogger.info("\n=====>>> Executing @Before advice on method");
	 * 
	 * }
	 */

	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);

		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			myLogger.info("" + tempArg);
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("account name:" + theAccount.getName());
				myLogger.info("account level:" + theAccount.getLevel());
			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.LearningSpring.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		{
			String method = theJoinPoint.getSignature().toShortString();
			myLogger.info("\n====>>> Executing @AfterReturning on method: " + method);

			myLogger.info("\n====>>> Result is : " + result);
			if (!result.isEmpty()) {
				convertAccountNamesToUpperCase(result);
			}

		}

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}

	@AfterThrowing(pointcut = "execution(* com.LearningSpring.aop.dao.AccountDAO.findAccounts(..))", throwing = "theExec")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExec) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterThrowing on method: " + method);
		myLogger.info("\n======>>> The Exception is: " + theExec);
	}

	@After("execution(* com.LearningSpring.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyMethodExceutes(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("Exceuting @After (finally) advice");
	}

	@Around("execution(* com.LearningSpring.aop.service.*.getFortune(..))")
	public Object afterGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// get begin timestamp
		Object result = null;
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("Executing @around on method" + method);
		long begin = System.currentTimeMillis();
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception exc) {
			myLogger.warning("@Around advice: We have a problem" + exc.getMessage());
			result = "Nothing Exciting her e. Move along !";
			throw exc; 
		}
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

}
