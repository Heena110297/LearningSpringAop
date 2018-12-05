package com.LearningSpring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

	//@Before("execution(public void addAccount())")
	//@Before("execution(public void com.LearningSpring.aop.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(com.LearningSpring.aop.demo.Account,..))")
	//@Before("execution(* add*(..))")
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
		
	}
	
	
}










