package com.LearningSpring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune(boolean tripwire) {
       if(tripwire) {
    	   throw new RuntimeException("Major Accident ! Highway is closed");
       }
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
			// sleep for about 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect Heavy Traffic this Morning";

	}
}
