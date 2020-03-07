package com.project.config;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import CustomerDao.CustomerDao;
import CustomerDao.CustomerDaoImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class MyAppConfig {
	
	 @Value("${MYSQL_DB_DRIVER_CLASS}")
	 private String driverClassName;
	 @Value("${MYSQL_DB_URL}")
	private String jdbcURL;
	 @Value("${MYSQL_DB_USERNAME}")
	private String username;
	 @Value("${MYSQL_DB_PASSWORD}")
	private String password;

	public String getDriverClassName() {
		return driverClassName;
	}
	public MyAppConfig() {
		// TODO Auto-generated constructor stub
	}
    @Bean
	 public DataSource getDataSource() {
    	System.out.println("SQL**********************"+jdbcURL);
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(jdbcURL);
	    dataSource.setUsername(username);
	    dataSource.setPassword(password);
	    return dataSource;
	 }
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	@Bean
	public CustomerDao getCustomerDao() {
		
		return new CustomerDaoImpl();
		
	}
	
	}

