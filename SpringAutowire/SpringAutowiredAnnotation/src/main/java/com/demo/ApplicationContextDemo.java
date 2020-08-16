package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.Employee;
import com.demo.model.Pancard;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringAutowiredAnnotation/src/main/resources/Bean.xml");

		Employee employee = appContext.getBean("employee", Employee.class);

		System.out.println(employee.getClass().getSimpleName() + ":\t" + employee.getId() + "\t" + employee.getName() + "\t" + employee.getEmail() + "\t" + employee.getAge());

		Pancard pancard = employee.getPancard();
		if(pancard != null) {
			System.out.println(pancard.getClass().getSimpleName() + ":\t" + pancard.getPanNo() + "\t" + pancard.getPanName());
			System.out.println("\n");
		}else {
			System.out.println("Pancard is not available");
		}

		((AbstractApplicationContext) appContext).close();
	}

}
