package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.RandomNumberGenerator;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringELAccessingStaticMethod/src/main/resources/Bean.xml");

		RandomNumberGenerator randomNumberGenerator = appContext.getBean("randomNumberGenerator", RandomNumberGenerator.class);

		System.out.println(randomNumberGenerator.getPi() + "\t" + randomNumberGenerator.getRandomNumber());
		
		((AbstractApplicationContext) appContext).close();

	}

}
