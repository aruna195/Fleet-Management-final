package com.project.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@AutoConfigu
public class HomeControllerTest {

	public HomeControllerTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testShowHomePage() throws URISyntaxException {
		
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080" + "/";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("/"));	}

}
