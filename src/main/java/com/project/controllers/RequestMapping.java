package com.project.controllers;

import org.springframework.web.bind.annotation.RequestMethod;

public @interface RequestMapping {

	String value();

	RequestMethod method();

	
	
}
