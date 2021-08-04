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
import com.review.dao.ActionBoardCommentDAO;


@WebServlet("/actionCommentWrite")
public class ActionCommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ActionCommentWrite() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("id"));
		//System.out.println(session.getAttribute("name"));
		//System.out.println(request.getParameter("ano"));
		//System.out.println(Util.str2Int2(request.getParameter("ano")));
		//System.out.println(request.getParameter("content"));
		
		if(request.getParameter("content") != null
				&& request.getParameter("ano") != null
				&& (Util.str2Int(request.getParameter("ano")) != 0)
				&& session.getAttribute("id") != null
				&& session.getAttribute("name") != null) {
			
			String id = (String)session.getAttribute("id");
			String content = request.getParameter("content");
			int ano = Util.str2Int(request.getParameter("ano"));
			String ip = Util.getIP(request);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			content = Util.strRe(content);
			
			map.put("id", id);
			map.put("content", content);
			map.put("ano", ano);
			map.put("ip", ip);
			ActionBoardCommentDAO dao = ActionBoardCommentDAO.getInstance();
			
			int result = dao.commentWrite(map);
			
			if(result == 1) {
				response.sendRedirect("./actionBoardDetail?ano="+ano);
			}else {
				response.sendRedirect("./error?code=1234");
			}
		}else {
			response.sendRedirect("./error?code=5555");
		}
		
	}

}
