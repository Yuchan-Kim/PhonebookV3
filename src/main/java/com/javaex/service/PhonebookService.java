package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.phonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private phonebookDao dao;
	
	//전화번호 등록
	public int exeWritePerson(PersonVo personVo) {
		System.out.println("phonebookService.exeWritePerson()");

		int count = dao.insertPerson(personVo);
		
		return count;
	}
	
	
	//전화번호 전부 가져오기
	public List<PersonVo> exeGetPerson(){
		System.out.println("phonebookService.exeGetPerson()");
		
		List<PersonVo> personList = dao.getPersonList();
		
		return personList;
	}
	
	
	//삭제
	public int exePersonDelet(int num) {
		
		System.out.println("phonebookService.exePersonDelet");
		
		int count = dao.deletePerson(num);
		
		return count;
	}
	
	public int exeUpdatePerson(PersonVo personVo) {
		
		System.out.println("phonebookService.exeUpdatePerson");
		
		int count = dao.updatePerson(personVo);
		
		return count;
	}
	
	public PersonVo exeGetPersonInfo(int num) {
		return dao.getPerson(num);
	}
	
	public Map<String, Object> exeEditForm2(int no){
		System.out.println("PhonebookService.exxeEditForm2()");
		return null;
	}
	
	
	

}

