package model;

import java.util.ArrayList;

public class DAOTest {

	public static void main(String[] args) {
//		ProDAO dao =new ProDAO();
//		ArrayList<ProVO> array=dao.list(1,"이");
//		for(ProVO vo:array) {
//			System.out.println(vo.toString());
//		}
		
		//System.out.println("교수인원수:"+dao.total(""));
		
//		StuDAO dao =new StuDAO();
//		ArrayList<StuVO> array=dao.list(1,"4","year");
//		for(StuVO vo:array) {
//			System.out.println(vo.toString());
//		}
//		System.out.println("검색수"+dao.total("4", "year"));
//		CouDAO dao =new CouDAO();
//		ArrayList<CouVO> array=dao.list(1,"pname","이병렬");
//		for(CouVO vo:array) {
//			System.out.println(vo.toString());
//		}
//		System.out.println("검색수"+dao.total("pname","이병렬"));
//		
//		
//		ProDAO dao =new ProDAO();
//		ProVO vo =new ProVO();
//		vo.setPname("강감찬");
//		vo.setDept("컴정");
//		vo.setTitle("정교수");
//		vo.setHiredate("2023-08-02");
//		dao.insert(vo);
//		System.out.println("입력완료");
		
//		ProDAO dao =new ProDAO();
//		System.out.println(dao.read("221").toString());
		
		StuDAO dao =new StuDAO();
		ArrayList<EnrollVO> array=dao.list("92514023");
		for(EnrollVO vo:array) {
			System.out.println(vo.toString());
	}
	}
}

