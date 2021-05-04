package com.Library.LibraryManagement.Serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Library.LibraryManagement.Controller.LoginController;
import com.Library.LibraryManagement.DTO.StudentDTO;
import com.Library.LibraryManagement.Entity.Student;
import com.Library.LibraryManagement.Service.LoginMailServices;
import com.Library.LibraryManagement.Service.StudentService;

@Repository
public class LoginMailServiceImpl implements LoginMailServices {

	private static final Logger LOGGER = LogManager.getLogger(LoginMailServiceImpl.class);
//	private EntityManager entityManager;

	private StudentService studentService;
	
	@Autowired
	public LoginMailServiceImpl(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	@Transactional
	public Student validateLogin(StudentDTO studentDto,List<String> errorList) {
		LOGGER.info("STUDENT DTO  IN SERVICE IMPL -----------------------: "+ studentDto);
		Student student = null;
		try {
			if(studentDto != null) {
				Student studentModel = new Student(studentDto);
				LOGGER.info("================================================================================="+studentModel);
				List<Student> list = studentService.getListOfStudent(studentModel);
				LOGGER.info("LIST STUDENT DTO :::::::::::::::::::::::::::: " + list);
				if(list !=null && list.size() == 1) {//Size one is mentioned to get only one user 
					
					student = list.get(0);
					LOGGER.info("Student List After Fetch = " + student);
					if(student !=null && new BCryptPasswordEncoder().matches(studentDto.getPassword(), student.getPassword())) {
						LOGGER.info("=============================Student Password Matched ======================= " + student);
						return student;
					}else {
						LOGGER.info("=============================Student Password Not Matched ======================= " + student);
						errorList.add("Invalid Credentials !");
					}
				}else {
					errorList.add("Invalid Credentials !");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exectpioon in Validation MEthod : " + e.getMessage());
			errorList.add("Internal Server Error ");
		}
		return student;
	}

}
