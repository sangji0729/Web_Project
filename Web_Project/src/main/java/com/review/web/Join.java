package com.review.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.dao.ActionBoardDAO;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Join() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("id") != null && request.getParameter("name") != null
				&& request.getParameter("email") != null && request.getParameter("pw") != null) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pw", pw);
			map.put("name", name);
			map.put("email", email);
			
			ActionBoardDAO dao = ActionBoardDAO.getInstance();
			
			int result = dao.join(map);
			
			if(result == 1) {
				
				response.sendRedirect("./joinAction.jsp");
			}else {
				response.sendRedirect("./join.jsp");
			}
		}else {
			response.sendRedirect("./error?code=joinError");
		}
	}

}
