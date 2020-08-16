package com.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//Please note it is not the recommended approach because suppose there are hundreds of bean available in application then for each bean we have to implement initializing and disposable bean 
public class Message {

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

	@PostConstruct
	public void init() throws Exception {	//Any custom method name
		System.out.println("init custome name to afterPropertiesSet is called after bean initialization ");
	}
	// In real scenario we can use - setting of property files, database connection
	// etc as soon as bean is initialized

	@PreDestroy
	public void destroyMethod() throws Exception {	//Any custom method name
		System.out.println("destroMethod custome name to destroy bean is going to destroy");
	}

}
