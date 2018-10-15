package com.learning.springboothibernatemysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.config.JPAConfig;

@SpringBootApplication
@ComponentScan(basePackages = "com.learning.*")
@EnableJpaRepositories(basePackages="com.learning.repository")
//@EnableCircuitBreaker
public class SpringBootHibernateMysqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateMysqlApplication.class, args);
	}
}