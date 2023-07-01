package com.baek.findreply.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.findcomment.model.FindReplyVO;

public interface FindReplyService {
	List<FindReplyVO> listComment(HttpServletRequest request, HttpServletResponse response);
	void addComment(HttpServletRequest request, HttpServletResponse response);
	List<FindReplyVO> idlistComment(HttpServletRequest request, HttpServletResponse response);
	void del(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
}
