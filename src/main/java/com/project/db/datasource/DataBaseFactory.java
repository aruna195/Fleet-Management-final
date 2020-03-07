package com.project.db.datasource;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFactory {
	

	public static DataSource getDataSource(String dbType){
		

		if("mysql".equals(dbType)){
			return new MySQLDataSource().getDatasource();
		}
		
		return null;
	}
}