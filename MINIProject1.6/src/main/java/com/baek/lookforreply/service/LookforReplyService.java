package com.baek.lookforreply.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.findcomment.model.FindReplyVO;
import com.baek.lookforcomment.model.LookforReplyVO;

public interface LookforReplyService {
	List<LookforReplyVO> listComment(HttpServletRequest request, HttpServletResponse response);
	void addComment(HttpServletRequest request, HttpServletResponse response);
	List<LookforReplyVO> idlistComment(HttpServletRequest request, HttpServletResponse response);
	void del(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
}
