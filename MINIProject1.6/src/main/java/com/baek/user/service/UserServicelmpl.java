package com.baek.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.user.model.UserDAO;
import com.baek.user.model.UserVO;

public class UserServicelmpl implements UserService {

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {

		String id =request.getParameter("id");
		String pw=request.getParameter("pw");
		String phone=request.getParameter("phone");

		UserDAO dao=UserDAO.getInstance();

		int result =dao.idcheck(id);

		if(result==1) {
			return 1;
		}else {

			UserVO vo= new UserVO(id, pw, phone);
			dao.join(vo);
			return 0;
		}


	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String pw=request.getParameter("pw");


		UserDAO dao=UserDAO.getInstance();

		UserVO vo=dao.login(id, pw);


		return vo;
	}

	@Override
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session=request.getSession();

		String id = (String)session.getAttribute("user_id");
		
		UserDAO dao = UserDAO.getInstance();


		UserVO vo= dao.getInfo(id);

		return vo;
	}
	
	
	@Override
	public int del(HttpServletRequest request, HttpServletResponse response) {

		int result = 0;
		HttpSession session=request.getSession();

		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		UserDAO dao = UserDAO.getInstance();

		result = dao.del(id,pw);
		return result;
		
	}

	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 서비스와 DAO영역을 작성
		 * 1. 아이디 기반으로 회원정보를 수정
		 * 2. 성공 실패 여부를 컨트롤러로 반환
		 * 3. 수정 성공시에는 mypage로 리다이렉트, 실패시에는 modify로 리다이렉트
		 */
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ph = request.getParameter("ph");
		
		
		UserVO vo = new UserVO(id,pw,ph);
		
		UserDAO dao=UserDAO.getInstance();
		int a =dao.updateInfo(vo);
		
		return a;
	}

}
