package model;

import java.util.*;

public class ProVO {
	private String pcode; //교수번호
	private String pname; //교수이름
	private String dept; //소속학과
	private String hiredate; //임용일자
	private String title; //직급
	private int salary; //급여

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public String toString() {
		return "ProVO [pcode=" + pcode + ", pname=" + pname + ", dept=" + dept + ", hiredate=" + hiredate + ", title="
				+ title + ", salary=" + salary + "]";
	}

	
	
	 
}
