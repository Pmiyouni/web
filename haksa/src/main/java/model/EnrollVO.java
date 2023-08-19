package model;

import java.util.*;

public class EnrollVO extends CouVO{
	private String lcode; //강좌번호
	private String scode; //학생번호
	private String edate; //수강신청일
	private int grade; //성적
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EnrolVO [lcode=" + lcode + ", scode=" + scode + ", edate=" + edate + ", grade=" + grade
				+ ", getLname()=" + getLname() + ", getHours()=" + getHours() + ", getCapacity()=" + getCapacity()
				+ ", getPersons()=" + getPersons() + ", getPname()=" + getPname() + "]";
	}
	
}
