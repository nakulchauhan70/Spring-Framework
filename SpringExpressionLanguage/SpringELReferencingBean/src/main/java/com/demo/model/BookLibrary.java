package com.demo.model;

import java.util.List;

public class BookLibrary {

	private List<Book> allBook;
	private Book firstBook;

	public List<Book> getAllBook() {
		return allBook;
	}

	public void setAllBook(List<Book> allBook) {
		this.allBook = allBook;
	}

	public Book getFirstBook() {
		return firstBook;
	}

	public void setFirstBook(Book firstBook) {
		this.firstBook = firstBook;
	}

}
