package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhonebookController {
	//Fields
	
	//Constructors
	
	//Getters and Setters
	
	//[Methods]
	
	//Register Form
	@RequestMapping(value ="/writeform", method = {RequestMethod.GET, RequestMethod.POST} )
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		
		
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	public String write() {
		
		
		
		return null;
		
	}
}
