package com.spring.springboot.决策者;

import org.springframework.stereotype.Component;

@Component
public class NormalUser implements MyCalculateStrategy {

	@Override
	public UserType userType() {
		 
		return UserType.NORMAL;
	}

	@Override
	public double calculate(double fee) {
		return fee*0.9;
	}

}
