package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class ProductController extends HttpServlet {

	@WebServlet(value = { "/pro/list", "/pro/insert" })
	private static final long serialVersionUID = 1L;
	ProductDAO dao = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dis = null;		
		switch(request.getServletPath()) {
			request.setAttribute("array", dao.list());



		
		 "/pro/list":case



			                     request.setAttribute("array", dao.list());
		                    	request.setAttribute("array", dao.list());
			request.setAttribute("array", dao.list());
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("array", dao.list());
			request.setAttribute("array", dao.list());

			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			request.setAttribute("pageName", "pro/list.jsp");
			
			break;
		case "/pro/insert":
			request.setAttribute("pageName", "pro/insert.jsp");
			request.setAttribute("pageName", "pro/insert.jsp");
			request.setAttribute("pageName", "pro/insert.jsp");
			request.setAttribute("pageName", "pro/insert.jsp");
			//dis= request.getRequestDispatcher("insert.jsp");
		//	pro폴더에서 찾아야 하므로 /pro/list.jsp를 앞에 주어야 함(절대경로)
		// 아니면 pro폴더를 만들고 그 아래 jsp 파일을 저장하면 list.jsp로 함
			break;
		}
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
