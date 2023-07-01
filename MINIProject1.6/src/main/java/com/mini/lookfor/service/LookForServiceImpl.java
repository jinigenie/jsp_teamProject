package com.mini.lookfor.service;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.find.model.FindDAO;
import com.baek.find.model.FindVO;
import com.mini.lookfor.model.LookForDAO;
import com.mini.lookfor.model.LookForVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class LookForServiceImpl implements LookForService {

	@Override
	public void write(HttpServletRequest request, HttpServletResponse response) throws Exception {

	request.setCharacterEncoding("utf-8");
		
//		String location = "C:\\Users\\user\\Desktop\\course\\jsp\\workspace\\MINIProject.zip_expanded\\MINIProject\\src\\main\\webapp\\lookfor_file";
		ServletContext context = request.getServletContext();
		String location = "/lookfor_file";  
		String realPath = context.getRealPath(location);
		
		System.out.println(realPath);
		new File(realPath).mkdir();
		
		int maxSize = 1024 * 1024 * 5; // 키로바이트 * 메가바이트 * 기가바이트   
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

		// 여기 DB에 넣는 부분
		String title = multi.getParameter("title");
		String id = multi.getParameter("id");
		String type = multi.getParameter("anymal");
		String date = multi.getParameter("date");
		String time = multi.getParameter("time");
		String area = multi.getParameter("area");
		String content = multi.getParameter("content");
		String fileName = multi.getFilesystemName("fileName"); 
		
		date = date+" "+time;
		
		System.out.println(date);
		System.out.println("여기는 LookForServiceImpl : " + fileName);
		LookForDAO dao = LookForDAO.getInstance();
		dao.writeLf(type, date, area, title, content, id, fileName);

		
		// 여기 파일 쓰는 부분
		Enumeration<?> files = multi.getFileNames(); // <input type="file">인 모든 파라메타를 반환
				
		String element = "";
		String filesystemName = "";
		String originalFileName = "";
		String contentType = "";
		long length = 0;		
				
		if (files.hasMoreElements()) { 
			
			element = (String)files.nextElement(); 
			
			filesystemName 			= multi.getFilesystemName(element); 
			originalFileName 		= multi.getOriginalFileName(element); 
			contentType 			= multi.getContentType(element);	
			length 					= multi.getFile(element).length();
			
		}
		response.sendRedirect("lookfor_list.lookfor");
	
	}

	@Override
	public List<LookForVO> getList(HttpServletRequest request, HttpServletResponse response) {

		LookForDAO dao = LookForDAO.getInstance();
		List<LookForVO> list = dao.getList();
		
		return list;
	}

	@Override
	public LookForVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		System.out.println(num);
		LookForDAO dao = LookForDAO.getInstance();
		LookForVO vo = dao.getContent(num);
		
		return vo;
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("anymal");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String area = request.getParameter("area");
		
		date = date+" "+time;
		
		
		LookForDAO dao = LookForDAO.getInstance();
		System.out.println(num +"-" + type);
		dao.update(type, date, area, num, title, content);
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");
		LookForDAO dao = LookForDAO.getInstance();
		dao.delete(num);
	}

	@Override
	public List<LookForVO> getTitle(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		LookForDAO dao = LookForDAO.getInstance();
		List<LookForVO> vo = dao.getTitle(id);
		
		
		return vo;
	}

	@Override
	public List<LookForVO> getArea(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		LookForDAO dao = LookForDAO.getInstance();
		List<LookForVO> vo = dao.getArea(id);
		
		
		return vo;
	}

	@Override
	public List<LookForVO> getidList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		LookForDAO dao = LookForDAO.getInstance();
		List<LookForVO> vo = dao.getidList(id);
		
		
		return vo;
	}

	
}
