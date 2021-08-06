package com.review.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.Util.Util;
import com.review.dao.LogDAO;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logout() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("로그아웃 : " + session.getAttribute("id"));
		
		String id = (String)session.getAttribute("id");
		HashMap<String, Object> log = new HashMap<String, Object>();
		//log.put("name", request.getParameter("name"));
		log.put("id", id);
		log.put("target", "로그아웃");
		log.put("etc", "로그아웃 성공");
		log.put("ip", Util.getIP(request));
		LogDAO.insertLog(log);
		
		if(session.getAttribute("id") != null) {
			session.removeAttribute("id");
		}
		if(session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		if(session.getAttribute("grade") != null) {
			session.removeAttribute("grade");
		}
		
		response.sendRedirect("./actionBoard");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
