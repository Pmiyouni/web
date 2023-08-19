package model;
import java.util.*;
import java.sql.*;

public class CouDAO {
	//점수 수정
	public void update(GradeVO vo) {
	try {
		
		String sql="update enrollments set grade=? where scode=? and lcode=?";
		PreparedStatement ps=Database.CON.prepareStatement(sql);
		ps.setInt(1, vo.getGrade());	
		ps.setString(2, vo.getScode());
		ps.setString(3, vo.getLcode());			
		ps.execute();
		
	}catch(Exception e) {
		System.out.println("점수수정:" + e.toString());
	}
}
	
	//성적목록
	public ArrayList<GradeVO> list(String lcode) {	
		ArrayList<GradeVO> array = new ArrayList<GradeVO>();
		try {
			String  sql= "select * from view_enroll_stu ";
		         	sql+=" where lcode=? order by scode";
		        
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);	
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GradeVO vo =new GradeVO();
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setGrade(rs.getInt("grade"));
				vo.setEdate(rs.getString("edate"));
				vo.setDept(rs.getString("dept"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("성적목록:" + e.toString());
		}
		
		
		
		return array;
	}
	//강좌 목록 읽기
	public ArrayList<CouVO> all() {
		ArrayList<CouVO> array = new ArrayList<CouVO>();
		try {
			String 	sql="select * from view_cou order by lname";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CouVO vo= new CouVO();
				vo.setLcode(rs.getString("lcode"));
				vo.setLname(rs.getString("lname"));
				vo.setHours(rs.getInt("hours"));
				vo.setRoom(rs.getString("room"));
				vo.setInstructor(rs.getString("instructor"));
				vo.setCapacity(rs.getInt("capacity"));
				vo.setPersons(rs.getInt("persons"));
				vo.setPname(rs.getString("pname"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("강좌목록:" + e.toString());
		}
		return array;
	}

//	강좌 수정
	public void update(CouVO vo) {
		try {
			
			String sql="update courses set lname=?,room=?,hours=?,capacity=?,persons=?,instructor=? where lcode=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getLname());
			ps.setString(2, vo.getRoom());
			ps.setInt(3, vo.getHours());
			ps.setInt(4, vo.getCapacity());
			ps.setInt(5, vo.getPersons());
			ps.setString(6, vo.getInstructor());
			ps.setString(7, vo.getLcode());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("강좌수정:" + e.toString());
		}
	}

//	//강좌등록
	
	public void insert(CouVO vo) {
		try {
			String code=getCode();
			String sql="insert into courses(lcode,lname,room,hours,capacity,persons,instructor) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, vo.getLname());
			ps.setString(3, vo.getRoom());
			ps.setInt(4, vo.getHours());
			ps.setInt(5, vo.getCapacity());
			ps.setInt(6, vo.getPersons());
			ps.setString(7, vo.getInstructor());
			ps.execute();
		}catch(Exception e) {
			System.out.println("강좌등록:" + e.toString());
		}
	}
	
	//강좌번호 구하기
	public String getCode() {
		String code="";
		try {
			String mcode="";
			String 	sql ="select max(lcode) mcode from courses";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) mcode=rs.getString("mcode");
			code ="N"+(Integer.parseInt(mcode.substring(1))+1);
			//강좌번호를 1번째부터 끝까지 추출하여 +1 (0번째는 알파벳)
			
		}catch(Exception e) {
			System.out.println("강좌등록:" + e.toString());
		}
		return code;
	}
	//해당 강좌정보읽기
		public CouVO read(String lcode) {
			CouVO vo=new CouVO();
			try {
				String 	sql ="select * from view_cou";
						sql+=" where lcode=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, lcode);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					vo.setLcode(rs.getString("lcode"));
					vo.setLname(rs.getString("lname"));
					vo.setHours(rs.getInt("hours"));
					vo.setRoom(rs.getString("room"));
					vo.setInstructor(rs.getString("instructor"));
					vo.setCapacity(rs.getInt("capacity"));
					vo.setPersons(rs.getInt("persons"));
					vo.setPname(rs.getString("pname"));
					
				}
			}catch(Exception e) {
				System.out.println("강좌정보:" + e.toString());
			}
			return vo;
		}
	
	//검색수
		public int total(String key, String query) {
			int total=0;
			try {
				String  sql= "select count(*) cnt from view_cou ";
			        	sql+="where " + key + " like ? ";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, "%" + query + "%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					total=rs.getInt("cnt");
				}
			}catch(Exception e) {
				System.out.println("검색수:" + e.toString());
			}
			return total;
		}
		
	
	//강좌목록
	public ArrayList<CouVO> list(int page, String key, String query){
		ArrayList<CouVO> array=new ArrayList<CouVO>();
		try {
			String  sql= "select * from view_cou ";
		         	sql+="where " + key + " like ? ";
		        	sql+="limit ?, 5";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CouVO vo=new CouVO();
				vo.setLcode(rs.getString("lcode"));
				vo.setLname(rs.getString("lname"));
				vo.setHours(rs.getInt("hours"));
				vo.setRoom(rs.getString("room"));
				vo.setInstructor(rs.getString("instructor"));
				vo.setCapacity(rs.getInt("capacity"));
				vo.setPersons(rs.getInt("persons"));
				vo.setPname(rs.getString("pname"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("강좌목록:" + e.toString());
		}
		
		return array;
	}
}