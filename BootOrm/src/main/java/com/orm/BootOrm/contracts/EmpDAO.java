package com.orm.BootOrm.contracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orm.BootOrm.Model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpDAO implements EmpDAOInterface {
	@PersistenceContext
	private EntityManager emp;

	@Override
	public void persist(Employee e) {
		emp.persist(e);
	}

	@Override
	public List<Employee> identifyAll() {
		// select chesinapudu employee ane model class ivali not table
		return emp.createQuery("SELECT e FROM Employee e").getResultList();
	}

	@Override
	public void deleteById(Integer id) {
		Employee employee = emp.find(Employee.class, id);
		if (employee != null) {
			emp.remove(employee);
		}
	}
}