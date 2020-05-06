package com.cas.自旋;

public class CounterBasic implements Counter{

	private int i=0;
	@Override
	public int incr() {
		return i++;
	}
	@Override
	public int get() {
		return i;
	}

}
