package com.orm.BootOrm.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "ishwarya")
@Entity // here to write different names for class and database table
public class Employee {
	@Id
	private Integer empno;
	@Column(name = "ename")
	private String eName;
	private String job;
	private Integer mgr;
	private Double sal;

	public Employee() {
		super();
	}

	public Employee(Integer empno, String eName, String job, Integer mgr, Double sal) {
		super();
		this.empno = empno;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Empolyee [empno=" + empno + ", eName=" + eName + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + "]";
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

}
