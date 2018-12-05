package com.LearningSpring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAdvice {

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
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performApiAnalyticsAdvice() {
		System.out.println("\n ========> Performing Api analytics");
	}
}
