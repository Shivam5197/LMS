package com.Library.LibraryManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class MainController {

	@RequestMapping("/home")
	public String homePage() {
		return "templet/homePage";
	}
	
}
