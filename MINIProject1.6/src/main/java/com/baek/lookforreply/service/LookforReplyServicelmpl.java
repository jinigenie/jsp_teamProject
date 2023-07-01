package com.baek.lookforreply.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.findcomment.model.FindReplyDAO;
import com.baek.findcomment.model.FindReplyVO;
import com.baek.lookforcomment.model.LookforReplyDAO;
import com.baek.lookforcomment.model.LookforReplyVO;

public class LookforReplyServicelmpl implements LookforReplyService{

	@Override
	public List<LookforReplyVO> listComment(HttpServletRequest request, HttpServletResponse response) {

		LookforReplyDAO dao=LookforReplyDAO.getInstance();

		List<LookforReplyVO> list=dao.listComment(request.getParameter("num"));


		return list;
	}

	
	@Override
	public void addComment(HttpServletRequest request, HttpServletResponse response) {
		
		String body=request.getParameter("body");//내용
		//게시물 번호
		//id
		String articleIdx=request.getParameter("content_num");//내용
		String nickname=request.getParameter("id");//내용
		LookforReplyVO vo=new LookforReplyVO(null, articleIdx, body, nickname, null);
		LookforReplyDAO dao =LookforReplyDAO.getInstance();
		
		dao.addComment(vo);
	}


	@Override
	public List<LookforReplyVO> idlistComment(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		LookforReplyDAO dao=LookforReplyDAO.getInstance();

		List<LookforReplyVO> list=dao.idlistCommentLK(id);


		return list;
	}


	@Override
	public void del(HttpServletRequest request, HttpServletResponse response) {

		String idx = request.getParameter("idx");
		LookforReplyDAO dao=LookforReplyDAO.getInstance();
		
		dao.del(idx);
		
	}


	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String parentidx = request.getParameter("num");
		LookforReplyDAO dao=LookforReplyDAO.getInstance();
		
		dao.delall(parentidx);
		
	}

}
