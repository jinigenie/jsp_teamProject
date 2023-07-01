package com.baek.lookforcomment.model;

import com.baek.find.model.FindDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LookforReplyDAO {
	//싱글톤 형태의 클래스로 생성하는 편이 좋다.(싱글톤 - 여러개 호출되어도 한개의 객체만 반환)
	//1. 나 자신의 객체를 스태틱으로 선언
	private static LookforReplyDAO instance = new LookforReplyDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private LookforReplyDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3. getter를 통해서 객체를 반환
	public static LookforReplyDAO getInstance() {
		return instance;
	}
	//데이터베이스 연결주소
	//오라클 커넥터
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String uid="PROJSP";
	private String upw="PROJSP";

	public ArrayList<LookforReplyVO> listComment(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 부모글 번호를 조건으로 받기
			String sql = "select * from lfreply where parentidx=?";
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();

			ArrayList<LookforReplyVO> clist = new ArrayList<LookforReplyVO>();

			while ( rs.next() ) {

				LookforReplyVO dto = new LookforReplyVO(rs.getString("idx"),
						rs.getString("parentidx"),rs.getString("body"),
						rs.getString("id"),rs.getTimestamp("regdate"));


				clist.add(dto);

			}

			return clist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public void addComment(LookforReplyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into lfreply"
				+ " values (REPLYSQ.nextVal, ?, ?, ?, sysdate)";
		try {


			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getParentidx());
			pstmt.setString(2, vo.getBody());
			pstmt.setString(3, vo.getId());

			pstmt.executeUpdate(); // 성공시 1 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
			}


		}

	}
	public List<LookforReplyVO> idlistCommentLK(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 부모글 번호를 조건으로 받기
			String sql = "select * from lfreply where id=?";
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			ArrayList<LookforReplyVO> clist = new ArrayList<LookforReplyVO>();

			while ( rs.next() ) {

				LookforReplyVO dto = new LookforReplyVO(rs.getString("idx"),
						rs.getString("parentidx"),rs.getString("body"),
						rs.getString("id"),rs.getTimestamp("regdate"));

				clist.add(dto);

			}

			return clist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public void del(String idx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from lfreply where idx=?";
		try {


			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.executeUpdate(); // 성공시 1 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
			}


		}



	}
	public void delall(String parentidx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from lfreply where parentidx=?";
		try {


			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, parentidx);
			pstmt.executeUpdate(); // 성공시 1 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
			}


		}
	}
}
