package model;

public class DBTest {

	public static void main(String[] args) {
		ProductDAO dao=new ProductDAO();
		for(ProductVO vo:dao.list(1)) {
			System.out.println(vo.toString());
		}
	}

}