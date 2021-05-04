package com.Library.LibraryManagement.Controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Library.LibraryManagement.Entity.Books;
import com.Library.LibraryManagement.Entity.Student;
import com.Library.LibraryManagement.Service.BookService;
import com.Library.LibraryManagement.Service.StudentService;
import com.Library.LibraryManagement.Utils.Utils;
import com.Library.LibraryManagement.Utils.Mail.MailService;

@Controller
@RequestMapping("/Students")
public class StudentController {

	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
	private StudentService studentService;
	@Autowired
	private BookService bookService;

	@Autowired
	private MailService mailService;

	@Autowired
	public StudentController( StudentService studentService) {
		this.studentService=studentService;
	}

	@RequestMapping(value="/list",method = {RequestMethod.GET})
	public String ListOfStudentsPage(Model theModel) {
		List<Student> studentList = null;
		Student studentModel = new Student();
		try {
			studentList = studentService.getListOfStudent(studentModel);
			theModel.addAttribute("students", studentList);
			//			LOGGER.info(studentList.toString()+"{}{}{{}}{}}{{}}}}}}}}}}}}}}}}}}}}}}}}}}");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Exception occuerd at Get StundetLIST CONTROLLER ");
		}
		return "student/studentList";
	}

	@RequestMapping(value="/studentFormShow",method = {RequestMethod.POST,RequestMethod.GET})
	public String showSaveStudentForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("studentFormData", theStudent);
		return "student/studentForm";
	}

	@RequestMapping(value="/sendPasswordMail",method = {RequestMethod.POST,RequestMethod.GET})
	public String SaveStudent(@ModelAttribute("studentFormData") Student student,Model theModel,HttpSession session) {
		try {
			if(student!=null) {
				Boolean isexist = 	studentService.checkifUserNameExists(student.getUserName());
				if(isexist ==true) {
//					errorList.addError(new ObjectError("error","UserName is already taken please use different user name try : " + Utils.RandomAlphaString()));
					theModel.addAttribute("error","UserName is already taken by another user please use different user name you can try : " + Utils.RandomAlphaString());				
					return "student/studentForm";
				}else {
/*					studentService.SaveStudent(student);*/
					mailService.sendMail(student.getEmail(),student.getFirstName());
					theModel.addAttribute("error","We have sent a Password Set mail on "+student.getEmail());				
					session.setAttribute("loggedInUser", student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			theModel.addAttribute("error","Exception occured at our End ");				
			return "student/studentForm";
		}		
		return "redirect:/login/loginForm";
	}

	@RequestMapping(value = "/updateShowForm", method = {RequestMethod.GET})
	public String updateShowForm(@RequestParam("studentId") Integer id,Model theModel) {
		Student theStudent = null;
		try {
			if(id !=null) {
				theStudent = studentService.getStudentByID(id);
				theModel.addAttribute("studentFormData", theStudent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "student/studentForm";
	}

	@RequestMapping(value="/deleteStudent")
	public String DeleteShowForm(@RequestParam("studentId") Integer id) {
		try {
			if(id !=null) {
				studentService.softDeleteStudent(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Students/list";
	}

	@RequestMapping(value = "/showBookList", method = RequestMethod.GET)
	public String showBookListToStudent(@RequestParam("studentId") Integer id ,Model theModel, HttpSession session) {	
//	LOGGER.info("-------------------------LIST OF BOOKS FOR STUDENT CONTROLLER ---------------------------");	
		List<Books> books = null;
		Student theStudent = null;
		try {
			theStudent = studentService.getStudentByID(id);
			session.setAttribute("loggedInUser", theStudent);
			books = bookService.getBooks();
			
			theModel.addAttribute("booksForstudent", books);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "student/booksList";
	} 
	
	@RequestMapping(value="/showstudentBooks",method = RequestMethod.GET )
	public String showBooksListToStudent( Model theModel,HttpSession session) {
		
		List<Books> books = null;
		Student student = null;
		try {
		student = (Student)	session.getAttribute("loggedInUser");
			LOGGER.info("STUDENT FOR BOOKS LIST :::::::::: " + student);
					books =	student.getBooks();
					
			LOGGER.info("STUDENT FOR BOOKS LIST :::::::::: " + books);
					theModel.addAttribute("booksByID", books);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "student/BooksById";
	}
	
	

	@RequestMapping(value = "/IssueBook",method = {RequestMethod.POST,RequestMethod.GET})
	public String issueBook(@RequestParam("bookId") Integer bookID, HttpSession session) {
		Student student = null;
		Books book =null;
		if(bookID !=null) {

			student = (Student) session.getAttribute("loggedInUser");
			book = bookService.getBookByID(bookID);
			studentService.issueBook(student, book);
		}
		return "redirect:/Students/list";
	}
	
	@RequestMapping(value = "/viewBooks" ,method = {RequestMethod.GET})
	public String viewBooksIssueByUser(@RequestParam("studentId") Integer studentId,Model theModel,HttpSession session) {
	List<Books> books = null;
	Student student = null;
	try {
			if(studentId !=null) {
				student = studentService.getStudentByID(studentId);
				session.setAttribute("loggedInUser", student);
				
				books =	student.getBooks();
				theModel.addAttribute("booksByID", books);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "student/BooksById";
	}

	@RequestMapping(value = "/ReturnBook" , method = {RequestMethod.POST,RequestMethod.GET})
	public String returnBook(@RequestParam(value = "bookId") Integer bookId,Integer studentId,HttpSession session) {
		Books book = null;
		Student student = null;
		try {
			if(bookId !=null) {
				book = bookService.getBookByID(bookId);
				student = (Student) session.getAttribute("loggedInUser");
//				LOGGER.info("BOOK : " + book);				
//				LOGGER.info("Student : " + student);				
				studentService.returnBok(student, book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Students/viewBooks";
	}
	
	@RequestMapping(value = "/setPasswordform")
	public String setPasswordForm(Model theModel) {
		Student stu = new Student();
		theModel.addAttribute("passwordset",stu);
		return "Login/setPassword";
	}
	
	@RequestMapping(value="/setPassword",method = {RequestMethod.POST})
	public String setPasswordSaveStudent(@ModelAttribute("passwordset") Student studentPAss,HttpSession session) {
		try {
			LOGGER.info("Password IS getting ::: " + studentPAss);
			if(studentPAss !=null) {
				Student student = (Student)	session.getAttribute("loggedInUser");
				student.setPassword(studentPAss.getPassword());
				LOGGER.info("After Setting Password the Student IS ::::  " + student );
				studentService.SaveStudent(student);
				if (session != null) {
//					session.invalidate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login/loginForm";
	}
	
}
