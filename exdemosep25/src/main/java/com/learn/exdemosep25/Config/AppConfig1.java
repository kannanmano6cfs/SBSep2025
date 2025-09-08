package com.learn.exdemosep25.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.learn.exdemosep25.Model.Employee;

@ComponentScan("com.learn.exdemosep25") // Annotation based configuration
//@Configuration   Java Based Configuration
public class AppConfig1 {

	@Bean
	public Employee getdet() {
		return new Employee(13,"Akshay",30);
	}
	
	@Bean(name="empdet")
	public Employee getdet1() {
		return new Employee(14,"Sakshi",30);
	}
}
