package com.Library.LibraryManagement.Service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.Library.LibraryManagement.Entity.Books;
import com.Library.LibraryManagement.Entity.Student;

public interface StudentService {

	public void SaveStudent(Student student);
	public List<Student> getListOfStudent(Student student);
	public Student getStudentByID(Integer id);
	public void softDeleteStudent(Integer id);
	public void issueBook(Student student, Books book);
	public void returnBok(Student student,Books book);
	public Boolean checkifUserNameExists(String studentUserName);
}
