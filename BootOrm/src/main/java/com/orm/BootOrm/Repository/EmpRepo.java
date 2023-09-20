package com.orm.BootOrm.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orm.BootOrm.Model.Employee;
import com.orm.BootOrm.contracts.EmpDAO;

@Repository
public class EmpRepo {
	@Autowired
	private EmpDAO empdao;

	@Transactional
	public void add(Employee e) {
		empdao.persist(e);
	}

	@Transactional
	public void addAll(Collection<Employee> empList) {
		for (Employee emp : empList) {
			empdao.persist(emp);
		}
	}

	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return empdao.identifyAll();

	}

	@Transactional
	public void deleteEmployeeById(Integer id) {
		empdao.deleteById(id);
	}
}
