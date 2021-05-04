package com.Library.LibraryManagement.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	
	@RequestMapping("/error")
	public String ErrorPage() {
		return "Error/error";
	}

	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
