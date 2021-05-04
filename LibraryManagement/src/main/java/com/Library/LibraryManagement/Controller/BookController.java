package com.Library.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Library.LibraryManagement.Entity.Books;
import com.Library.LibraryManagement.Service.BookService;

@Controller
@RequestMapping("/BookManagement")
public class BookController {

	private BookService booksService;
	@Autowired
	public BookController(BookService booksService) {
		this.booksService = booksService;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String BooksList(Model theModel) {
//		BindingResult errorList = null;
		List<Books> booksList =	booksService.getBooks();
		theModel.addAttribute("bookList", booksList);	
		return "Books/bookList";
	}
	
	@RequestMapping(value="/showFormForBookSave" , method =RequestMethod.GET)
	public String showForSave(Model theModel) {
		Books books= new Books();
		theModel.addAttribute("bookForm", books);
		return "Books/bookForm";
	}

	@RequestMapping(value="/saveBooks",method = {RequestMethod.POST,RequestMethod.GET})
	public String saveBook(@ModelAttribute("bookForm")Books books,BindingResult errorList) {
		if(books!=null) {
			booksService.SaveBook(books, errorList);
		}else {
			errorList.addError(new ObjectError("error","Please enter required details"));
		}
		return "redirect:/BookManagement/list";
	}
	
	@RequestMapping(value = "/updateBookShowForm",method = RequestMethod.GET)
	public String showFormForBookUpdate(@RequestParam("bookId") Integer id,Model theModel) {
		Books book = null;
		
		if(id !=null) {
			book = booksService.getBookByID(id);
			theModel.addAttribute("bookForm", book);
		}else {
		}
		return "Books/bookForm";
	}
	
	@RequestMapping(value = "/deleteBook")
	public String deleteBook(@RequestParam("bookId") Integer id) {
		
		if(id !=null) {
		 booksService.DeleteBook(id);
		}
		return "redirect:/BookManagement/list";
	}
	
}
