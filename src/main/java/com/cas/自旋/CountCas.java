package com.cas.自旋;

import io.netty.channel.Channel.Unsafe;

public class CountCas implements Counter{

	private int i=0;
	
	static Unsafe unsafe; 
	@Override
	public int incr() {
		for (;;) {
			int current = i;
			int result = current +1;
			return result;
		}
	 
	}

	@Override
	public int get() {
		return i;
	}

}
