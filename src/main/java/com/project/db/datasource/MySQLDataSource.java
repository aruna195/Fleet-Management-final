package com.project.db.datasource;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MySQLDataSource {
	
	@Autowired
	private Environment env;

	public MySQLDataSource() {
		// TODO Auto-generated constructor stub
	}
	public DataSource getDatasource()
	{
		BasicDataSource ds = new BasicDataSource();
		
		//System.out.println("############################"+MyAppConfig.get;
		
		
				
		//System.out.println("############################"+ env.getProperty("MYSQL_DB_DRIVER_CLASS"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mydb");
        ds.setUsername("root");
        ds.setPassword("De@l12o603N!ll");

        return ds;
	}

}
