package model;

import java.util.*;

public class StudentVO {
	private int scode;
	private String sname;
	private String addr;
	private String phone;
	private Date birth;
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "StudentVO [scode=" + scode + ", sname=" + sname + ", addr=" + addr + ", phone=" + phone + ", birth="
				+ birth + "]";
	}
	
	
	
	
	

}
