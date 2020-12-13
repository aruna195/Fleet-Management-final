package com.project.db.datasource;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFactory {
	
	//FactoryPattern is used here
	

	public static MyDataSource getDataSource(String dbType){
		
	
		if("mysql".equals(dbType)){
			return new MySQLDataSource();
		}
		
		return null;
	}
}