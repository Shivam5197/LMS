package com.Library.LibraryManagement.Serviceimpl;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.Library.LibraryManagement.Entity.Books;
import com.Library.LibraryManagement.Service.BookService;
import com.Library.LibraryManagement.Utils.Constants;

@Repository
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = LogManager.getLogger(BookServiceImpl.class);
	private EntityManager entityManager;

	@Autowired
	public BookServiceImpl(EntityManager entityManager) {
		this.entityManager =entityManager;
	}

	@Override
	@Transactional
	public void SaveBook(Books books, BindingResult errorList) {
		try {
			if(books!=null) {
				/*
				 * if(books.getBookDescription().isEmpty()&& books.getBookInStock() !=null &&
				 * books.getBookLanguage().isEmpty() && books.getBookName().isEmpty() &&
				 * books.getBookPublisherName().isEmpty() ) {
				 */
					books.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
					books.setDeleted(Constants.BookStatus.AVAILABLE);
					LOGGER.info(books);
					entityManager.merge(books);
				/*}else {
					errorList.addError(new ObjectError("error","Please enter Required Data"));
					LOGGER.info("GETTING FAILED TO ADD BOOK");
					LOGGER.info("BOOKS:" + books );
				}*/
			}else {
				errorList.addError(new ObjectError("error","Please enter Required Data"));
				LOGGER.info("GETTING FAILED TO ADD BOOK");
				LOGGER.info("BOOKS:" + books );

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public Books getBookByID(Integer id) {
		Books book = null;
		try {
			if(id !=null) {
				book = entityManager.find(Books.class, id);	
				if(book !=null) {
					return book;
				}else {
				}
			}else {
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Books> getBooks() {
		List<Books> booksList = null;

		try {
			Query query = entityManager.createQuery("SELECT b FROM Books b WHERE b.id !=0 AND b.deleted ="+Constants.BookStatus.AVAILABLE);
			booksList = query.getResultList();
			if(booksList !=null) {
//				LOGGER.info("BOOKS :::: " + booksList);
				return booksList;
			}else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("Hume YE Retrun KR rhy hai");
		return booksList;
	}

	@Override
	@Transactional
	public void DeleteBook(Integer id) {
		Books book = null;
		try {
			if(id !=null) {
				book = entityManager.find(Books.class, id);
				book.setDeleted(Constants.BookStatus.DELETED);
			}else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
