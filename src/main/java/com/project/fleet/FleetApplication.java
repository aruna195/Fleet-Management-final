package com.project.fleet;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
@Controller
@SpringBootApplication
@ComponentScan("com.*")

	
	public class FleetApplication  extends SpringBootServletInitializer {
		
			protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
				return application.sources(FleetApplication.class);
			}
	
	


	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext run = SpringApplication.run(FleetApplication.class, args);
		FleetApplication app = new FleetApplication();
		
	}

}
