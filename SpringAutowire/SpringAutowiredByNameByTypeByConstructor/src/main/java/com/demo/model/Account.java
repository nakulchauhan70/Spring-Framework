package com.demo.model;

public class Account {

	private String accNo;
	private String accHolderName;

	private Pancard pancard;

	public Account(Pancard pancard) {
		super();
		this.pancard = pancard;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public Pancard getPan() {
		return this.pancard;
	}
}
