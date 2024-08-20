package com.javaex.vo;

public class PersonVo {
	
	//Fields
	private int personID;
	private String name;
	private String hp;
	private String companyhp;
	
	//Constructor
	public PersonVo(int personID, String name, String hp, String companyhp) {
		this.personID = personID;
		this.name = name;
		this.hp = hp;
		this.companyhp = companyhp;
	}
	
	public PersonVo( String name, String hp, String companyhp) {
		this.name = name;
		this.hp = hp;
		this.companyhp = companyhp;
	}
	
	//Getter / Setter
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompanyhp() {
		return companyhp;
	}

	public void setCompanyhp(String companyhp) {
		this.companyhp = companyhp;
	}

	
	
	//General Methods
	@Override
	public String toString() {
		return "PersonVO [personID=" + personID + ", name=" + name + ", hp=" + hp + ", companyhp=" + companyhp + "]";
	}
}
