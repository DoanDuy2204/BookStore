package com.dvd.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Defined a class was used to Configuration
@Configuration
//Declared class use Model Web MVC
@EnableWebMvc
@ComponentScan(basePackages="com.dvd")
@PropertySource("classpath:jdbc_hibernate.properties")
public class SpringConfig implements WebMvcConfigurer {
	
	//Defined a view for project
	@Bean
	public ViewResolver view() {
		InternalResourceViewResolver viewResource = new InternalResourceViewResolver();
		viewResource.setPrefix("/WEB-INF/view");
		viewResource.setSuffix(".jsp");
		return viewResource;
	}
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//Config Hibernate
	
	//Defined DataSource
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {	e.printStackTrace();}
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jbdc.password"));
		
		logger.info("<<< jdbc.driver = "+env.getProperty("jdbc.driver"));
		logger.info("<<< jdbc.driver = "+env.getProperty("jdbc.url"));
		logger.info("<<< jdbc.driver = "+env.getProperty("jdbc.user"));
		
		dataSource.setInitialPoolSize(getPool(env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMinPoolSize(getPool(env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(getPool(env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(getPool(env.getProperty("connection.pool.maxIdleTime")));
		
		return dataSource;	
	}
	
	public int getPool(String name) {
		String pool = env.getProperty(name);
		int intPool = Integer.parseInt(pool);
		return intPool;
	}
	
	@Autowired
	private DataSource dataSource;
	
	//Defined Session Factory
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;

			{
				setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
				setProperty("hibernate_globally_quoted_indenifirs", "true");
			}
		};
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManger(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}
