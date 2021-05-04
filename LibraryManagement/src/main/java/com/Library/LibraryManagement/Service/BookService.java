package com.Library.LibraryManagement.Service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.Library.LibraryManagement.Entity.Books;

public interface BookService {

	public void SaveBook(Books books, BindingResult errorList);
	public Books getBookByID(Integer id);
	public List<Books> getBooks();
	public void DeleteBook(Integer id);
	
}
