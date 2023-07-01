package com.baek.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDAO {

	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)
	//1. 나 자신의 객체를 스태틱으로 선언
	private static UserDAO instance = new UserDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. getter를 통해서 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}
	//데이터베이스 연결주소
	//오라클 커넥터
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String uid="PROJSP";
	private String upw="PROJSP";

	public int  idcheck(String id) {
		int re=0;
		String sql="select * from users where id=?";

		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				re=1;
			}else {
				re=0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			} 
		}


		return re;
	}

	public void join(UserVO vo) {//회원가입 인서트
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into "
				+ "users values(?,?,?)";
		try {
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();	
			} catch (Exception e2) {
			} 
		}
	}
	public UserVO login(String id, String pw) {

		//성공시 객체 반환 , 실패시 null
		UserVO vo=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where id=? and pw=?";

		try {
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String id2=rs.getString("id");
				String pw2=rs.getString("pw");
				String ph=rs.getString("ph");
				vo = new UserVO(id2,pw2,ph);

			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}


		return vo;
	}
	public UserVO getInfo(String id) {
		UserVO vo=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where id = ?";
		//1. Connector

		//2. Pstmt-sql을 실행하기 위한 클래스

		//3. ResultSet
		try {


			conn=DriverManager.getConnection(url,uid,upw);
			pstmt=	conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {//한 행일 땐 if구문

				String id2=rs.getString("id");
				String pw=rs.getString("pw");
				String ph=rs.getString("ph");
				vo = new UserVO(id2,pw,ph);
			}else {//중복이 없다는 뜻
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}


		return vo;

	}
	public int del(String id,String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from users where id=? and pw=?";
		int result =0;
		try {


			conn=DriverManager.getConnection(url,uid,upw);
			pstmt=	conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result=pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}

		return result;

	}
	public int updateInfo(UserVO vo) {
		int result =0;
		String sql = "update users "
				+ "set pw= ?, ph=? where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getId());
			
			
			result=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return result;	
	}
	
	
}

