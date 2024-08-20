package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.phonebookDao;
import com.javaex.vo.PersonVo;

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
	
	@RequestMapping(value = "/write" , method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		phonebookDao dao = new phonebookDao();
		int count = dao.insertPerson(personVo);
		
		System.out.println(count);
		return "";
		
	}
	
	@RequestMapping(value = "/write2" , method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam(value = "name") String name, 
						@RequestParam(value = "hp") String hp, 
						@RequestParam(value = "company") String company ) {
		
		System.out.println("PhonebookController.write2()");
		
		PersonVo personVo = new PersonVo(name,hp,company);
		System.out.println(personVo);
		
		
		return "";
		
	}
}
