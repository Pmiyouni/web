package model;
import java.util.*;
public class DAOTest {

	public static void main(String[] args) {
		ProductDAO dao=new ProductDAO();
//		ArrayList<ProductVO> array=dao.list(1,"냉장고");
//		for(ProductVO vo:array) {
//			System.out.println(vo.toString());
//		}
		System.out.println("검색수:"+dao.total("고"));
	}

}