package com.LearningSpring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	 * System.out.println("\n=====>>> Executing @Before advice on method");
	 * 
	 * }
	 */

	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("account name:" + theAccount.getName());
				System.out.println("account level:" + theAccount.getLevel());
			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.LearningSpring.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		{
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

			System.out.println("\n====>>> Result is : " + result);
			if (!result.isEmpty()) {
                  convertAccountNamesToUpperCase(result);
			}

		}

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
		    tempAccount.setName(theUpperName);
		}
	}

}
