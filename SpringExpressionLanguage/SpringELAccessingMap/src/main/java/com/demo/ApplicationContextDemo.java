package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.TelephoneDirectoryAccessor;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringELAccessingMap/src/main/resources/Bean.xml");

		TelephoneDirectoryAccessor telephoneDirectoryAccessor = appContext.getBean("telephoneDirectoryAccessor", TelephoneDirectoryAccessor.class);

		System.out.println(telephoneDirectoryAccessor.getTelNo());
		
		((AbstractApplicationContext) appContext).close();

	}

}
