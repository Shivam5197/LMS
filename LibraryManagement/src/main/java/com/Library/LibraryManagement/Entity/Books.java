package com.Library.LibraryManagement.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="book_name")
	private String bookName;
	@Column(name="book_publisher")
	private String bookPublisherName;
	@Column(name="book_description")
	private String bookDescription;
	@Column(name="book_language")
	private String bookLanguage;
	@Column(name="book_in_stock")
	private Integer bookInStock;
	@Column(name="added_at")
	private Timestamp addedAt;
	@Column(name="deleted")
	private Integer deleted;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="student_books",
				joinColumns=@JoinColumn(name = "books_id"),
				inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;
	
	public Books() {
		
	}
	
	public Books(String bookName, String bookPublisherName, String bookDescription, String bookLanguage,Timestamp addedAt,
			Integer bookInStock,Integer deleted) {
		this.bookName = bookName;
		this.bookPublisherName = bookPublisherName;
		this.bookDescription = bookDescription;
		this.bookLanguage = bookLanguage;
		this.bookInStock = bookInStock;
		this.addedAt =addedAt;
		this.deleted = deleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPublisherName() {
		return bookPublisherName;
	}

	public void setBookPublisherName(String bookPublisherName) {
		this.bookPublisherName = bookPublisherName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public Integer getBookInStock() {
		return bookInStock;
	}

	public void setBookInStock(Integer bookInStock) {
		this.bookInStock = bookInStock;
	}
	
	public Timestamp getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	public void removeBook(Student stu) {
		this.students.remove(stu);
		stu.getBooks().remove(this);
	}
	

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"bookName\":\"" + bookName + "\", \"bookPublisherName\":\"" + bookPublisherName
				+ "\", \"bookDescription\":\"" + bookDescription + "\", \"bookLanguage\":\"" + bookLanguage
				+ "\", \"bookInStock\":\"" + bookInStock + "\", \"addedAt\":\"" + addedAt + "\", \"deleted\":\""
				+ deleted + "\"}";
	}
	
	//Convience MEthods to help with adding the student
	public void addStudent(Student theStudent) {
		if(students ==null) {
			students = new ArrayList<>();
		}
		students.add(theStudent);
	}
	
	
}
