package com.orm.BootOrm.contracts;

import java.util.List;

import com.orm.BootOrm.Model.Employee;

public interface EmpDAOInterface {
	void persist(Employee e);

	List<Employee> identifyAll();

	void deleteById(Integer empno);
}
