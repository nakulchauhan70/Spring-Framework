package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.Message;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringBeanLifeCycleCallBackUsingAnnotation/src/main/resources/Bean.xml");

		Message message = appContext.getBean("message", Message.class);

		System.out.println(message.getClass().getSimpleName() + "\t" + message.getMessageId() + "\t"
				+ message.getMessage() + "\n");

		((AbstractApplicationContext) appContext).close();
	}

}
