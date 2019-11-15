package com.mybatis分页;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bingfa.DemoRepository;
import com.bingfa.Service;
import com.bingfa.demo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
	@Autowired
	private DemoDao dao;
	@Test
	public void contextLoads() {
		List<demo> demos = dao.findAll();
		PageHelper.startPage(0,3);
		PageInfo<demo> pageInfo = new PageInfo<>(demos);
		 System.out.println("总数："+pageInfo.getTotal());
	      System.out.println(pageInfo);
	}

}
