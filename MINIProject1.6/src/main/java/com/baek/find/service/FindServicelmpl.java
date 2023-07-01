package com.baek.find.service;


import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baek.find.model.FindDAO;
import com.baek.find.model.FindVO;
import com.mini.lookfor.model.LookForDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FindServicelmpl implements FindService{

	@Override
	public void writer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext context = request.getServletContext();
		String location = "/find_file";  
		String realPath = context.getRealPath(location);
		
		System.out.println(realPath);
		new File(realPath).mkdir();
		
		int maxSize = 1024 * 1024 * 5; // 키로바이트 * 메가바이트 * 기가바이트   
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String type = request.getParameter("anymal");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String area = request.getParameter("area");
		String content = request.getParameter("content");
		String fileName = multi.getFilesystemName("fileName"); 
		
		
		date = date+" "+time;
		FindDAO dao = FindDAO.getInstance();
		dao.writer(type, date, area,phone,title,content,id, fileName);

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
		response.sendRedirect("find_list.find");

	}

	@Override
	public List<FindVO> getList(HttpServletRequest request, HttpServletResponse response) {
		FindDAO dao=FindDAO.getInstance();

		List<FindVO> list=dao.getList();



		return list;
	}
	public FindVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");
		FindDAO dao = FindDAO.getInstance();
		FindVO vo = dao.getContent(num);

		return vo;
	}

	@Override
	public List<FindVO> getidList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getidList(id);
		
		
		return vo;
	}

	@Override
	public List<FindVO> getTitle(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getTitle(id);
		
		
		return vo;
	}

	@Override
	public List<FindVO> getArea(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("searchWord");
		FindDAO dao = FindDAO.getInstance();
		List<FindVO> vo = dao.getArea(id);
		
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("anymal");
		String ph = request.getParameter("ph");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String area = request.getParameter("area");
		
		date = date+" "+time;
		
		
		FindDAO dao = FindDAO.getInstance();
		dao.update(num,title,content,type,ph,date,time,area);
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		FindDAO dao = FindDAO.getInstance();
		dao.delete(num);
		
	}
}
