package model;

public class TestDB2 {

	public static void main(String[] args) {
		StudentDAO sdao=new StudentDAO();
		for(StudentVO vo: sdao.list()) {
			System.out.println(vo.toString());
		}
	}
}
