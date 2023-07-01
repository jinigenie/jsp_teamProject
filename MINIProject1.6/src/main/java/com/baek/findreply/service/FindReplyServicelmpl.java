package com.baek.findreply.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.findcomment.model.FindReplyDAO;
import com.baek.findcomment.model.FindReplyVO;

public class FindReplyServicelmpl implements FindReplyService{

	@Override
	public List<FindReplyVO> listComment(HttpServletRequest request, HttpServletResponse response) {

		FindReplyDAO dao=FindReplyDAO.getInstance();

		List<FindReplyVO> list=dao.listComment(request.getParameter("num"));


		return list;
	}

	
	@Override
	public void addComment(HttpServletRequest request, HttpServletResponse response) {
		
		String body=request.getParameter("body");//내용
		//게시물 번호
		//id
		String articleIdx=request.getParameter("content_num");//내용
		String nickname=request.getParameter("id");//내용
		FindReplyVO vo=new FindReplyVO(null, articleIdx, body, nickname, null);
		FindReplyDAO dao =FindReplyDAO.getInstance();
		
		dao.addComment(vo);
	}


	@Override
	public List<FindReplyVO> idlistComment(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		FindReplyDAO dao=FindReplyDAO.getInstance();

		List<FindReplyVO> list=dao.idlistComment(id);


		return list;
	}


	@Override
	public void del(HttpServletRequest request, HttpServletResponse response) {

		String idx = request.getParameter("idx");
		FindReplyDAO dao=FindReplyDAO.getInstance();
		
		dao.del(idx);
		
	}


	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String parentidx = request.getParameter("num");
		FindReplyDAO dao=FindReplyDAO.getInstance();
		
		dao.delall(parentidx);
		
	}

}
