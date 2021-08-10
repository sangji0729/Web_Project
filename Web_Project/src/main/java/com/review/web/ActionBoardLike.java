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
import com.review.dao.ActionBoardDAO;


@WebServlet("/actionBoardLike")
public class ActionBoardLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ActionBoardLike() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//System.out.println(request.getParameter("ano"));
		//System.out.println(request.getParameter("alike"));
		//System.out.println(session.getAttribute("id"));
		//System.out.println(session.getAttribute("name"));
		
		if(session.getAttribute("name") != null && session.getAttribute("id") != null
				&& request.getParameter("ano") != null && Util.str2Int(request.getParameter("ano")) != 0) {
			
			int no = Util.str2Int(request.getParameter("no"));
			int ano = Util.str2Int(request.getParameter("ano"));
			int alike = Util.str2Int(request.getParameter("alike"));
			String id = (String)session.getAttribute("id");
			String name = (String)session.getAttribute("name");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("no", no);
			map.put("ano", ano);
			map.put("id", id);
			map.put("name", name);
			map.put("aip", Util.getIP(request));
			ActionBoardDAO dao = ActionBoardDAO.getInstance();
			
			int result = dao.LikeUpCheck(map);
			
			if(result == 1) {
				result = dao.likeUp(map);
				if(result == 1) {
					
					System.out.println(id + " 님 "+ano +"번째 글 추천클릭" + (alike+1));
					response.sendRedirect("./actionBoardDetail?ano="+ano);
				}else {
					
					response.sendRedirect("./error?code=LikeUpError");					
				}
			}else {
				//이미 추천을 한번 했다면 에러발생페이지로 넘어감 추후 알림창으로 바꿀예정
				response.sendRedirect("./actionBoardDetail?ano="+ano);


				
			}
		}
	}

}
