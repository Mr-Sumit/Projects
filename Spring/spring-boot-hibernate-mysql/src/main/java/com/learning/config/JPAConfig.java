package com.learning.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JPAConfig {
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springboothibernatedb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public Properties getProperties(){
	    Properties properties = new Properties();
	    properties.put( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" );
	    properties.put( "hibernate.hbm2ddl.auto", "update" );
	    properties.put( "hibernate.show_sql", true);
	    return properties;
	}
	
	/*@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactory(){
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("localEntity");
		return emf;
	}*/
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setJpaProperties(getProperties());
		emf.setPackagesToScan("com.learning.model");
		emf.setPersistenceUnitName("localContainerEntity");
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emf.afterPropertiesSet();
		return emf;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager txnManager = new JpaTransactionManager();
		txnManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getObject());
		return txnManager;
	}
}