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
import org.json.simple.JSONObject;import model.Database;
import model.ProductDAO;
import model.ProductVO;

//SON(제이슨, JavaScript Object Notation)이란 속성-값 쌍 또는 "키-값 쌍"으로 이루어진 데이터 오브젝트로  비동기 브라우저/서버 통신 을 위해, 넓게는 XML을 대체하는 주요 데이터 포맷

@WebServlet(value={"/pro/list","/pro/list.json","/pro/insert","/pro/delete","/pro/update"})
///pro/list.json에서 .jon은 사용자정의로 표현 자유
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao = new ProductDAO(); //DAO 객체 생성
	
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
	DecimalFormat df= new DecimalFormat("#,###");
	      
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //json 데이터를 출력하기위해서 브라우저를 생성
		RequestDispatcher dis= request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		case "/pro/list":
			request.setAttribute("pageName", "/pro/list.jsp");
			dis.forward(request, response);
			break;
		case "/pro/list.json":
			int page=request.getParameter("page")==null? 1:
				Integer.parseInt(request.getParameter("page"));
			//getParameter는 스트링만 가져올 수 있으므로 page를 정수로 변환
			String query= request.getParameter("query")==null?"":
				request.getParameter("query");
			
			ArrayList<ProductVO> array =  dao.list(page,query);
			//sql결과를 array에 저장하여 리턴받음
			
			//json-simple라이브러리의 JSONObject 클래스를 이용해서 json 객체를 만들수 있다.
			//ArrayList-> JSONArray로 변환
			JSONArray jArray = new JSONArray();
			//JSONArray는 JSON 객체의 배열
			
			for(ProductVO vo:array) { //어레이 내용을 하나씩 vo에 넣어서 처리				
				//JSONObject 객체를 만들고 put()매소드를 이용해서 데이터를 넣어줌
				JSONObject obj = new JSONObject();
				obj.put("code", vo.getCode()); //vo의 데이터를 JSONObject의 객체 obj에 하나씩 넣음
				obj.put("name",vo.getName());
				obj.put("price",vo.getPrice());
				obj.put("fprice", df.format(vo.getPrice()));
				obj.put("fdate", sdf.format(vo.getRdate()));
				jArray.add(obj);  //JSONArray json 배열에 저장
				
			}
			 JSONObject jobject = new JSONObject();
			 
			  jobject.put("items",jArray);  //배열 내용을 item에 저장
			  jobject.put("total",dao.total(query)); // 전체 상품수 저장
			  
			  out.print(jobject);	//items와 total을 브라우저에 출력		
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getServletPath()) {
		case "/pro/insert":
			ProductVO vo=new ProductVO();
			vo.setName(request.getParameter("name"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			System.out.println(vo.toString());
			dao.insert(vo);
			break;
		case "/pro/delete":
			int code=Integer.parseInt(request.getParameter("code"));
			dao.delete(code);
			break;
		case "/pro/update":
			vo=new ProductVO();
			vo.setCode(Integer.parseInt(request.getParameter("code")));
			vo.setName(request.getParameter("name"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			dao.update(vo);
			break;
					
		}
	}

}
