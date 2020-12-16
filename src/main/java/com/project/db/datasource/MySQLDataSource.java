package com.project.db.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MySQLDataSource implements MyDataSource{
	@Autowired
	private Environment env;
	
	public MySQLDataSource() {
		// TODO Auto-generated constructor stub
	}
	public  DataSource getDatasource()
	{
		BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("org.postgresql.Driver");
	        ds.setUrl("jdbc:postgresql://mydb.cwhbyojxrlzf.us-east-2.rds.amazonaws.com:5432/mydb");
	        ds.setUsername("postgres");
	        ds.setPassword("Anna2020");         
	        
	           return ds;
	}	

}
