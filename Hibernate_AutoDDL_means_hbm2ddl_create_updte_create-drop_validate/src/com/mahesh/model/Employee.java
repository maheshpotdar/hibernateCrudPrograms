package com.mahesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empid", unique = true)
	private int eid;

	@Column(name = "empname", nullable = true, length = 25, unique = false)
	private String empName;

	@Column(name = "empAddress", nullable = true, length = 25, unique = false)
	private String empAddress;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empName=" + empName + ", empAddress=" + empAddress + "]";
	}

}
