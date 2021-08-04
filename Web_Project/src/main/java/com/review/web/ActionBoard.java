package com.review.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.Util.Util;
import com.review.dao.ActionBoardDAO;


@WebServlet("/actionBoard")
public class ActionBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ActionBoard() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Util.str2Int(request.getParameter("page"));
		}
		//페이지 넘기기
		RequestDispatcher rd 
				= request.getRequestDispatcher("actionBoard.jsp");
		//request.setAttribute("list", list2);
		ArrayList<HashMap<String, Object>> list =  ActionBoardDAO.getInstance().boardList((page - 1 ) * 5);
		request.setAttribute("list", list);
		
		if(list != null && list.size() > 0) {
			request.setAttribute("totalCount", list.get(0).get("totalcount"));
		}
		//page보내기
		request.setAttribute("page", page);
		
		rd.forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
