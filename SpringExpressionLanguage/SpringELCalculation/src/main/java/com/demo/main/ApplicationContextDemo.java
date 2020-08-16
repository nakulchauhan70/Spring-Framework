package com.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.PerimeterCalculator;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringELCalculation/src/main/resources/Bean.xml");

		PerimeterCalculator perimeter = appContext.getBean("perimeter", PerimeterCalculator.class);

		System.out.println(perimeter.getPerimeter());
		
		((AbstractApplicationContext) appContext).close();

	}

}
