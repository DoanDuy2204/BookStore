package com.dvd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Defined a class was used to Configuration
@Configuration
//Declared class use Model Web MVC
@EnableWebMvc
@ComponentScan(basePackages="com.dvd")
public class SpringConfig implements WebMvcConfigurer {
	
	//Defined a view for project
	public ViewResolver view() {
		InternalResourceViewResolver viewResource = new InternalResourceViewResolver();
		viewResource.setPrefix("/WEB-INF/view");
		viewResource.setSuffix(".jsp");
		return viewResource;
	}
	
}
