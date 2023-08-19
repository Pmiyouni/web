package model;

import java.sql.*;
import java.util.*;



public class StudentDAO {
	public List<StudentVO> list(){
		List<StudentVO> array= new ArrayList<>();
		try {
			String sql="select * from students order by scode desc";
			
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentVO vo= new StudentVO();
				vo.setScode(rs.getInt("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setAddr(rs.getString("addr"));
				vo.setPhone(rs.getString("phone"));
				vo.setBirth(rs.getTimestamp("birth"));
				array.add(vo);
			}
			
			
		}catch(Exception e) {
			System.out.println("학생목록오류"+e.toString());
		}
		return array;
	}

}
