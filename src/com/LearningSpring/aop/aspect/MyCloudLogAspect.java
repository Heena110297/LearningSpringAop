package com.LearningSpring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
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
	public void logToCloudAdvice() {
		System.out.println("\n=======> Clouding logging");
	}
}
