package com.demo.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//Please note it is not the recommended approach because suppose there are hundreds of bean available in application then for each bean we have to implement initializing and disposable bean 
public class Message implements InitializingBean, DisposableBean {

	private int messageId;
	private String message;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet is called after bean initialization ");
	}
	// In real scenario we can use - setting of property files, database connection
	// etc as soon as bean is initialized

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean is going to destroy");
	}

}
