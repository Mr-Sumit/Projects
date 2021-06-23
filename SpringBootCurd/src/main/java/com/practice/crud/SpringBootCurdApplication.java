package com.practice.crud;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.crud.entities.Department;
import com.practice.crud.entities.Employee;
import com.practice.crud.repos.DepartmentRepo;
import com.practice.crud.repos.EmployeeRepo;

@SpringBootApplication
public class SpringBootCurdApplication {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	DepartmentRepo deptRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdApplication.class, args);
	}

	@PostConstruct
	public void insertData() {
//		employeeRepo.save(new Employee(1L,"emp1", "emp1 name","it", 1000.0F,"emp1@gmail.com"));
//		employeeRepo.save(new Employee(2L,"emp2", "emp2 name","admin", 500.0F,"emp2@gmail.com"));
		
		createDepts();
	}
	
	private void createDepts() {
		Department adminDept = new Department();
		adminDept.setName("Administration");
		adminDept.setDeptNo("001");
		deptRepo.save(adminDept);
		
		Department hrDept = new Department();
		hrDept.setName("HR");
		hrDept.setDeptNo("002");
		deptRepo.save(hrDept);
		
		Department itDept = new Department();
		itDept.setName("IT");
		itDept.setDeptNo("003");
		deptRepo.save(itDept);
		
		employeeRepo.save(new Employee("emp1", "emp1 name", 1000.0F,"emp1@gmail.com", adminDept));
		employeeRepo.save(new Employee("emp2", "emp2 name", 500.0F,"emp2@gmail.com", hrDept));
		employeeRepo.save(new Employee("emp3", "emp3 name", 500.0F,"emp2@gmail.com", adminDept));
	}
}
