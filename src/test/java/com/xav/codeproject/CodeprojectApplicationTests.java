package com.xav.codeproject;

import com.xav.codeproject.dao.AlphaDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration (classes = CodeprojectApplication.class)
public class CodeprojectApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	 public void testApplicationContext() {
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
		AlphaDao alphaHerbinate = applicationContext.getBean("alphaHibernate", AlphaDao.class);
		System.out.println(alphaHerbinate.select());
	}


}
