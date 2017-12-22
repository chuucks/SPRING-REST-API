package org.codesolt.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({ "classpath:persistance.properties" })
public class JDBCConfiguration {

	@Autowired
    private Environment env;
	
	@Bean
	public Properties jpaProperties() { 
		Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.dialect", "com.oracle.jdbc.Oracle");
	    jpaProperties.put("hibernate.hbm2ddl.auto", "validate");
	    jpaProperties.put("hibernate.show_sql", "true");
	    jpaProperties.put("hibernate.format_sql", "true");
		return jpaProperties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource manager = new DriverManagerDataSource();
		manager.setDriverClassName(env.getProperty("jdbc.driver"));
		manager.setUrl(env.getProperty("jdbc.url"));
		manager.setUsername(env.getProperty("jdbc.user"));
		manager.setPassword(env.getProperty("jdbc.pass"));
		manager.setConnectionProperties(jpaProperties()); 	
		return manager;		
	}
	
}
