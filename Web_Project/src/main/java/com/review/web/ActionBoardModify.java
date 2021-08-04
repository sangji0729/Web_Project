package com.review.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.review.Util.Util;
import com.review.dao.ActionBoardDAO;

@WebServlet("/actionBoardModify")
public class ActionBoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionBoardModify() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null && request.getParameter("ano") != null
				&& Util.str2Int(request.getParameter("ano")) != 0) {
			int ano = Util.str2Int(request.getParameter("ano"));
			String id = (String) session.getAttribute("id");
			System.out.println("오는 데이터는 : " + ano + " , " + id);
			
			//이미지
			/*
			String path = request.getSession().getServletContext().getRealPath("/");
			//String realPath = path + "upload/";아래로 수정
			String realPath = path + "upload" + File.separator;
			System.out.println("경로 : " + path);
			int size = 1024 * 1024 * 5;
			MultipartRequest multi = new MultipartRequest(request, realPath,
							size, "UTF-8", new DefaultFileRenamePolicy());
			
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			//String upFile = multi.getOriginalFileName("file1"); //실제 업로드시 파일 이름
			String saveFile = multi.getFilesystemName("file1");//저장된 이름
			//title과 content에 html코드 특수문자로 변경해주세요.
			
			System.out.println("title : " + title);
			System.out.println("cotnent : " + content);
			//System.out.println("업로드시 이름 : "+ upFile); 
			System.out.println("저장시 이름 : " + saveFile); 
			
			//저장시켜주세요
			
			//썸네일 만들겠습니다.
			String thumbnailPath = path + "thumbnail" + File.separator;
			//C:\workspaceJSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jul19web/upload/파일명
			BufferedImage inputImg 
							= ImageIO.read(new File(realPath + saveFile));
			
			//가로세로 크기 지정
			int width = 160;
			int height = 160;
			
			//이미지 확장자 확인
			String[] imgs = {"png", "gif", "jpg", "bmp"};
			
			for(String format : imgs) {
				BufferedImage outputImg 
								= new BufferedImage(width, height,
										BufferedImage.TYPE_INT_RGB);
				Graphics2D gr2d = outputImg.createGraphics();
				gr2d.drawImage(inputImg, 0, 0, width, height, null);

				//파일쓰기
				File thumb = new File(thumbnailPath + saveFile);
				//폴더가 없다면 생성
				if(thumb.exists()) {
					//thumb.mkdir();//폴더 생성
					thumb.mkdirs();//여러 폴더 생성
				}
				FileOutputStream fos = new FileOutputStream(thumb);
				ImageIO.write(outputImg, format, thumb);
				fos.close();
			}
			*/
			//이미지
			
			HashMap<String, Object> map = new HashMap<String,Object>();
			ActionBoardDAO dao = ActionBoardDAO.getInstance();
			
			map = dao.update(ano, id);
			RequestDispatcher rd = request.getRequestDispatcher("./actionBoardModify.jsp");
			request.setAttribute("map", map);
			rd.forward(request, response);

		} else {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		System.out.println(request.getParameter("title"));
		System.out.println(session.getAttribute("id"));
		System.out.println(request.getParameter("ano"));
		System.out.println(request.getParameter("content"));

		 String title = request.getParameter("title");
		 String id = (String)session.getAttribute("id"); 
		 String content = request.getParameter("content"); 
		 int ano = Util.str2Int(request.getParameter("ano"));
		  
		  HashMap<String, Object> map = new HashMap<String, Object>();
		  map.put("id", id); 
		  map.put("ano", ano); 
		  map.put("content", content);
		  map.put("title", title);
		  
		  ActionBoardDAO dao = ActionBoardDAO.getInstance();
		  
		  int result = dao.modify(map);
		  
		  if(result == 1) {
			  response.sendRedirect("./actionBoardDetail?ano="+ano);
		  }else {
			  response.sendRedirect("./error?code=updateError01");
		  }
		 
	}

}
