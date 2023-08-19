package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import model.*;

@WebServlet(value={"/book/search", "/book/insert", "/book/list", "/book/list.json", "/book/total"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DecimalFormat df= new DecimalFormat("#,###원");
	
    BookDAO dao=new BookDAO();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //한글인코딩
		
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		
		PrintWriter out=response.getWriter();//브라우저생성
		
		Gson gson=new Gson();
				
		switch(request.getServletPath()){
			case "/book/total":
				out.println(dao.total());
				break;
				
			case "/book/list.json":
				int page=Integer.parseInt(request.getParameter("page"));
				JSONObject json=new JSONObject();
				json.put("count", dao.total());
				json.put("items", gson.toJson(dao.list(page)));
				out.println(json);
				break;
				
//			case "/book/list.json":
//				int page=request.getParameter("page")==null ? 1: 
//					    Integer.parseInt(request.getParameter("page"));
//				
//				ArrayList<BookVO> array=dao.list(page);
//				
//				JSONArray jarray = new JSONArray();
//					for(BookVO vo : array) {
//						JSONObject json = new JSONObject();
//						json.put("seq", vo.getSeq());
//						json.put("title",vo.getTitle());
//						json.put("thumbnail",vo.getThumbnail());
//						json.put("price", vo.getPrice());
//						json.put("fprice",df.format(vo.getPrice()));
//						json.put("contents", vo.getContents());
//						json.put("publisher", vo.getPublisher());
//						jarray.add(json);
//					}
//					JSONObject jobj = new JSONObject();
//					jobj.put("count", dao.total());
//					jobj.put("items",jarray);
//					out.print(jobj);			
//				   break;
				
			case "/book/search":
				request.setAttribute("pageName", "/book/search.jsp");
				dis.forward(request, response);
				break;
			case "/book/list":
				request.setAttribute("pageName", "/book/list.jsp");
				dis.forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getServletPath()) {
		case "/book/insert": //REST API
			BookVO vo=new BookVO();
			vo.setIsbn(request.getParameter("isbn"));
			vo.setTitle(request.getParameter("title"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setThumbnail(request.getParameter("thumbnail"));
			vo.setUrl(request.getParameter("url"));
			vo.setPublisher(request.getParameter("publisher"));
			vo.setAuthors(request.getParameter("authors"));
			vo.setContents(request.getParameter("contents"));
			System.out.println(vo.toString());
			dao.insert(vo);
			break;
		}
	}

}