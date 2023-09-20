package com.orm.BootOrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orm.BootOrm.Model.Employee;
import com.orm.BootOrm.Repository.EmpRepo;

@RestController
public class EmpController {
	EmpRepo empserv;

	@Autowired
	public EmpController(EmpRepo empserv) {
		this.empserv = empserv;
	}

	@GetMapping("/emps")
	public List<Employee> getAllBooks() {
		return empserv.listAll();
	}

	@PostMapping("/emps")
	public void createEmp(@RequestBody Employee emp) {
		empserv.add(emp);
	}

	@PutMapping("/emps/{empno}")
	public ResponseEntity<Object> UpdateEmp(@RequestBody Employee emp, @PathVariable Integer empno) {
		empserv.deleteEmployeeById(empno);
		empserv.add(emp);
		return new ResponseEntity<>("book is updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("/emps/{empno}")
	public ResponseEntity<Object> deleteEmp(@PathVariable Integer empno) {
		empserv.deleteEmployeeById(empno);
		return new ResponseEntity<>("book is deleted successsfully", HttpStatus.OK);
	}

}
