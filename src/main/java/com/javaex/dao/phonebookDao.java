package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class phonebookDao  {
	
	@Autowired
	private SqlSession sqlsession;
	

	//Bring person's information
	public PersonVo getPerson(int no) {
		
		Map<String,Object> person = sqlsession.selectOne("phonebook.selectOne",  no);
		return (PersonVo) person;

	}

	//Save new person's information to the database
	public int insertPerson(PersonVo personvo) {
		System.out.println("PhonebookDao.insertPerson()");
		int count = sqlsession.insert("phonebook.insert", personvo);
		return count;

	}

	public List<PersonVo> getPersonList() {
		
		List<PersonVo> personList = sqlsession.selectList("phonebook.selectList");
		System.out.println(personList);
		return personList;

	}

	public int deletePerson(int no) {
		System.out.println("PhonrbookDao/deletePerson()");
		int count = sqlsession.delete("phonebook.delete",no);
		return count;
	}

	public int updatePerson(PersonVo personVo) {
		int count = sqlsession.update("phonebook.update",personVo);
		

		return count;
	}
	
	



}





















