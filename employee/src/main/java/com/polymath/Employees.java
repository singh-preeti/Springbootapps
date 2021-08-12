package com.polymath;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employees { //POJO
 @Id
	private int eid;
	private String ename;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Employees(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
