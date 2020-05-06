package com.spring.springboot.决策者;

import org.springframework.stereotype.Component;

@Component
public class VipUser implements MyCalculateStrategy {

	@Override
	public UserType userType() {
		 
		return UserType.VIP;
	}

	@Override
	public double calculate(double fee) {
		return fee * 0.8;
	}

}
