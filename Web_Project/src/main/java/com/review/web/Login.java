package com.review.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.dao.LoginDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		LoginDAO dao = LoginDAO.getInstance();

		HashMap<String, Object> member = dao.login(id, pw);

		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.get("id"));
			session.setAttribute("pw", member.get("pw"));
			session.setAttribute("name", member.get("name"));

			// 관리자등급 = 1, 일반등급 = 2
			if ((int) member.get("grade") == 1) {
				session.setAttribute("grade", member.get("grade"));
			}
			System.out.println("로그인한 아이디 : " + session.getAttribute("id"));
			System.out.println("로그인한 이름 : " + session.getAttribute("name"));
			System.out.println("로그인한 비밀번호 : " + session.getAttribute("pw"));
			System.out.println("로그인한 등급 : " + session.getAttribute("grade"));

			response.sendRedirect("./actionBoard");

		} else {
			response.sendRedirect("./login");
		}

	}

}
