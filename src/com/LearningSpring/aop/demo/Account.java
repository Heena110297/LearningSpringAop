package com.LearningSpring.aop.demo;

public class Account {

	private String name ;
	private String level ;
	
	public String getName() {
		System.out.println("get name method");
		return name;
	}
	
	public void setName(String name) {
		System.out.println("set name method");
		this.name = name;
	}
	
	public String getLevel() {
		System.out.println("get level method");
		return level;
	}
	
	public void setLevel(String level) {
		System.out.println("set level method");
		this.level = level;
	} 
	
}
