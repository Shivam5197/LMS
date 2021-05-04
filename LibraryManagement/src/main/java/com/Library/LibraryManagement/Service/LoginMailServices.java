package com.Library.LibraryManagement.Service;

import java.util.List;

import com.Library.LibraryManagement.DTO.StudentDTO;
import com.Library.LibraryManagement.Entity.Student;

public interface LoginMailServices {

	public Student validateLogin(StudentDTO studentDto,List<String> errorList);
	
}
