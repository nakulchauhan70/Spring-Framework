package com.demo.model;

import java.util.List;

public class BookCollection {

	private List<Book> bookList;
	private Book firstBook;

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getFirstBook() {
		return firstBook;
	}

	public void setFirstBook(Book firstBook) {
		this.firstBook = firstBook;
	}

}
