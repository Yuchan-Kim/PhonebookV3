package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class phonebookDao  {

	// 데이터베이스 연결 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 데이터베이스 연결 정보
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/phonebook_db";
	private final String id = "phonebook";
	private final String pw = "phonebook";

	// 데이터베이스 연결 설정
	private void getConnection() {
		try {
			Class.forName(driver); // JDBC 드라이버 로딩
			conn = DriverManager.getConnection(url, id, pw); // 연결 얻기
		} catch (ClassNotFoundException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
			System.out.println("            ❌ 오류: 드라이버 로딩 실패         ");
			System.out.println("   원인: " + e.getMessage() );
			System.out.println("─────────────────────────────────────────────────────");
		} catch (SQLException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
			System.out.println("            ❌ 오류: 데이터베이스 연결 실패       ");
			System.out.println("  원인: " + e.getMessage());
			System.out.println("─────────────────────────────────────────────────────");
		}
	}
	// 자원 해제
	private void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
			System.out.println("             ❌ 오류: 자원 해제 실패          ");
			System.out.println("  원인: " + e.getMessage());
			System.out.println("─────────────────────────────────────────────────────");
		}
	}

	//Bring person's information
	public PersonVo getPerson(int no) {

		this.getConnection();
		PersonVo person = null;
		try {
			String query = "";
			query += " select person_id, ";
			query += "	name, hp, company from person where person_id = ? ";

			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			//실행
			rs = pstmt.executeQuery();

			//결과처리
			while(rs.next()) {
				int personID = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				person = new PersonVo(personID,name,hp,company);


			}


		}catch (SQLException e) {
			System.out.println("error: " + e);
		}



		return person;

	}

	//Save new person's information to the database
	public int insertPerson(PersonVo personvo) {
		this.getConnection();
		int count = -1;
		System.out.println("Initiated DAO insertPerson method");

		try {
			//SQL 쿼리 준비 / 바인딩 / 실행

			//쿼리 준비
			String query = "";
			query += " insert into person ";
			query += "	value (null, ? , ? ,? ) ";


			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personvo.getName());
			pstmt.setString(2, personvo.getHp());
			pstmt.setString(3, personvo.getCompanyhp());

			//실행
			count = pstmt.executeUpdate();


		}catch (SQLException e) {
			System.out.println("Error : " + e);
		}

		return count;

	}

	public List<PersonVo> getPersonList() {

		List<PersonVo> personList = new ArrayList<PersonVo>();

		this.getConnection();


		try {
			//SQL 쿼리 준비 / 바인딩 / 실행

			//쿼리 준비
			String query = "";
			query += " select person_id, ";
			query += "	name, ";
			query += "	hp, ";
			query += " company ";
			query += " from person ";

			//바인딩 
			pstmt = conn.prepareStatement(query);

			//실행
			rs = pstmt.executeQuery();

			//결과처리
			while(rs.next()) {
				int personID = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				PersonVo person = new PersonVo(personID,name,hp,company);
				personList.add(person);

			}

		}catch (SQLException e) {
			System.out.println("Error : " + e);
		}


		this.close();
		return personList;

	}

	public int deletePerson(int no) {
		System.out.println(no);


		int count = -1;
		this.getConnection();

		try {

			String query ="";
			query += " delete from person ";
			query += " where person_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,no);

			count = pstmt.executeUpdate();

			System.out.println(count + "건 삭제.");

		}catch (SQLException e) {
			System.out.println("error: " + e);
		}

		this.close();

		return count;
	}

	public int updatePerson(PersonVo personVo) {
		int count = -1;
		this.getConnection();

		try {

			String query ="";
			query += " update person ";
			query += " set name = ? , hp = ? , company = ? where person_id = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,personVo.getName());
			pstmt.setString(2,personVo.getHp());
			pstmt.setString(3,personVo.getCompanyhp());
			pstmt.setInt(4,personVo.getPersonID());

			count = pstmt.executeUpdate();

			System.out.println(count + "건 수정.");

		}catch (SQLException e) {
			System.out.println("error: " + e);
		}

		this.close();


		return count;
	}



}





















