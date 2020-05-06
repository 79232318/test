package com.spring.springboot.决策者;

public interface MyCalculateStrategy {

	public UserType userType();
	
	public double calculate(double fee);
}
