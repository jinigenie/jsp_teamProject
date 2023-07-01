package com.baek.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baek.find.model.FindVO;
import com.baek.user.model.UserVO;

public interface UserService {
	int join(HttpServletRequest request, HttpServletResponse response);
	UserVO login(HttpServletRequest request, HttpServletResponse response);
	UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
	int del (HttpServletRequest request, HttpServletResponse response);
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
}
