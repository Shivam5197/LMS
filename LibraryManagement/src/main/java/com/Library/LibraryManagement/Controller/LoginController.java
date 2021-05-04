package com.Library.LibraryManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Library.LibraryManagement.DTO.StudentDTO;
import com.Library.LibraryManagement.Entity.Student;
import com.Library.LibraryManagement.Service.LoginMailServices;
import com.Library.LibraryManagement.Utils.Constants;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	private LoginMailServices loginService;
	
	@Autowired
	public LoginController(LoginMailServices loginService ) {
		this.loginService =loginService;
	}
	
	@RequestMapping("/admin")
	public String showAdminPage() {
		
		return "Admin/adminPage";
	}
	
	@RequestMapping("/loginForm")
	public String showLoginForm(Model theModel) {
		StudentDTO student = new StudentDTO();
		theModel.addAttribute("mainLogin" ,student );
		return "Login/loginform";
	}
	
	@RequestMapping(value = "/validateLogin",method = {RequestMethod.POST,RequestMethod.GET})
	public String validateLogin(@ModelAttribute("mainLogin") StudentDTO studentDto,HttpSession session,Model theModel) {
		LOGGER.info("VALIDATE LOGIN CALLED IN CONTROLLLER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Student student = null;
		String returnPage ="";
		List<String> errorList = new ArrayList<String>();
		try {
			if(studentDto !=null) {
				student = new Student();
				if(studentDto.getUserName() !=null) {
					if(studentDto.getPassword() !=null) {
					student = loginService.validateLogin(studentDto, errorList);
						if(errorList.isEmpty()) {
							LOGGER.info("ERROR LIST IS EMPTY +++++++++++++++++++++++++++++++++++++++++++");
							session.setAttribute("loggedInUser", student);
								if(student.getUserType() == Constants.UserType.ADMIN) {
									returnPage = "redirect:/admin";
								}else if(student.getUserType() == Constants.UserType.LIBRARY_MANAGER) {
									returnPage = "redirect:/BookManagement/list";
								}else {
									returnPage = "redirect:/Students/showstudentBooks";
								}
						}else {
							theModel.addAttribute("error", "Bad Credentials");
							LOGGER.info("BAD CREDENTIALS ");
							returnPage ="redirect:/login/loginForm";
						}
					}else {
						theModel.addAttribute("error", "Please Enter valid Password");
						LOGGER.info("Please Enter valid Password ");

						returnPage ="redirect:/login/loginForm";
					}
				}else {
					LOGGER.info("Please Enter valid UserNAme ");

					theModel.addAttribute("error", "Please Enter valid Username");
					returnPage ="redirect:/login/loginForm";
				}
			}else {
				LOGGER.info("Please Enter valid UserNAme AND PAss ");

				theModel.addAttribute("error", "Please Enter Username and Password");
				returnPage ="redirect:/login/loginForm";
			}
		} catch (Exception e) {
			LOGGER.info("Exception: " + e.getMessage());
			theModel.addAttribute("error", "Internal Server Error");
			returnPage ="redirect:/login/loginForm";
		}
		LOGGER.info("RETURN PAGE IS  :::::::::::::::::::: " + returnPage);
		return returnPage;
	}
	
	
}
