package com.spring.springboot.决策者;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MyScaleService {

	HashMap<UserType,MyCalculateStrategy> map = new HashMap<UserType, MyCalculateStrategy>();
	public MyScaleService(List<MyCalculateStrategy> myCalculates) {
		for (MyCalculateStrategy myCalculate : myCalculates) {
			map.put(myCalculate.userType(), myCalculate);
		}
	}
	
	public double get2(UserType userType, double fee) {
		return map.get(userType).calculate(fee);
	}
	
	
	
	public double get(String userType, double fee) {
		if(!"normal".equals(userType)) {
			return fee *0.9;
		}else if(!"vip".equals(userType)) {
			return fee * 0.8;
		}else {
			return fee;
		}
	}
}
