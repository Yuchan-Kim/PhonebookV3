package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.phonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	//Fields
	@Autowired
	private phonebookDao dao;
	
	@Autowired
	private PhonebookService service;
	
	//Constructors
	
	//Getters and Setters
	
	//[Methods]
	@RequestMapping(value ="/delete", method = {RequestMethod.GET, RequestMethod.POST} )
	public String delete(@RequestParam(value = "num") int num) {
		
		System.out.println("Phonebookcontroller.delete()");
		
		//dao.deletePerson(num);
		
		service.exePersonDelet(num);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value ="/list", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		
		
//		List<PersonVo> personList = dao.getPersonList();
//		
//		System.out.println(personList);
//		
//		model.addAttribute("personList",personList);
		
		List<PersonVo> personList = service.exeGetPerson();
		
		model.addAttribute("personList",personList);
		
		return "list"; //Forwarding
	}
	
	
	@RequestMapping(value = "/editform",  method = {RequestMethod.GET, RequestMethod.POST})
	public String editForm(Model model, @RequestParam(value = "num") int num) {
	    PersonVo person = service.exeGetPersonInfo(num);
	    model.addAttribute("person", person);
	    return "editform";  // JSP 파일 이름 반환
	}
	
	
	

	@RequestMapping(value = "/edit",  method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(@RequestParam(value = "num") int num,
	                   @RequestParam(value = "name") String name,
	                   @RequestParam(value = "hp") String hp,
	                   @RequestParam(value = "company") String company) {
	    PersonVo personVo = new PersonVo(num, name, hp, company);
	   // dao.updatePerson(personVo);
	    
	    service.exeUpdatePerson(personVo);
	    return "redirect:/list"; 
	}

	
	
	@RequestMapping(value = "/write" , method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam(value = "name") String name, 
			@RequestParam(value = "hp") String hp, 
			@RequestParam(value = "company") String company ) {
		System.out.println("PhonebookController.write()");
		
		PersonVo personVo = new PersonVo(name,hp,company);
//		int count = dao.insertPerson(personVo);
//		
//		System.out.println(count);
		
		service.exeWritePerson(personVo);
		return "redirect:/list"; 
		
	}
	
	@RequestMapping(value = "/writeform" , method = {RequestMethod.GET, RequestMethod.POST})
	public String write2() {
		
		System.out.println("PhonebookController.writeform()");
		
		
		return "writeForm";
		
	}
}


