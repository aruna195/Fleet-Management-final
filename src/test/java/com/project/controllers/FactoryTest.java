package com.project.controllers;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.db.datasource.DataBaseFactory;
import com.project.db.datasource.MyDataSource;
import com.project.db.datasource.MySQLDataSource;

@RunWith(SpringRunner.class)
public class FactoryTest {
	
	
	public FactoryTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testFactoryPattern() throws URISyntaxException {
		MyDataSource dataSource = DataBaseFactory.getDataSource("mysql");
		Assert.assertNotNull(dataSource);
		Assert.assertTrue(dataSource instanceof MySQLDataSource);
		
	}
}
