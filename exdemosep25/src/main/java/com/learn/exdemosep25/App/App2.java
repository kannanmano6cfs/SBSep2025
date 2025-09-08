package com.learn.exdemosep25.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.exdemosep25.Config.AppConfig1;
import com.learn.exdemosep25.Model.Employee;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig1.class);
		
		Employee em3=context.getBean("getdet",Employee.class);
		System.out.println(em3);
		
		Employee em4=context.getBean("empdet",Employee.class);
		System.out.println(em4);
	}

}
