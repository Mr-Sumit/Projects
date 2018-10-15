package com.learning.springboothibernatemysql;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.learning.model.User;

public class SpringRestClient extends Thread {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/rest/user";
	
	private static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
	private void getUser(){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<>(getHeaders());
		ResponseEntity<User> response = restTemplate.exchange(REST_SERVICE_URI+"/load/1", HttpMethod.GET, request, User.class);
		User user = response.getBody();
		System.out.println(user);
	}
	
	public void run(){
		System.out.println("Name of Current Thread = "+ Thread.currentThread().getName());
		getUser();
	}
	
	public static void main(String[] args) {
		SpringRestClient src = new SpringRestClient();
		src.setName("SRC");
		src.start();
		
		SpringRestClient src1 = new SpringRestClient();
		src.setName("SRC1");
		src1.start();
		
		SpringRestClient src2 = new SpringRestClient();
		src.setName("SRC2");
		src2.start();
		
		SpringRestClient src3 = new SpringRestClient();
		src.setName("SRC3");
		src3.start();
		
	}
}
