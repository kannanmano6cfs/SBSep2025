package com.learn.exdemosep25.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.exdemosep25.Model.Employee;

public class App1 {

	public static void main(String[] args) {
		//Spring DI Container
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml"); 
		
		//Dependency Injection
		Employee em1=context.getBean("emp1",Employee.class);
		System.out.println(em1);
		
		Employee em2=context.getBean("emp2",Employee.class);
		System.out.println(em2);
		
	}

}
