package com.baek.find.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.model.FindVO;

public interface FindService {

	void writer (HttpServletRequest request, HttpServletResponse response) throws Exception;
	List<FindVO> getList(HttpServletRequest request, HttpServletResponse response);
	FindVO getContent(HttpServletRequest request, HttpServletResponse response);
	List<FindVO> getidList(HttpServletRequest request, HttpServletResponse response);
	List<FindVO> getTitle(HttpServletRequest request, HttpServletResponse response);
	List<FindVO> getArea(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
	
}
