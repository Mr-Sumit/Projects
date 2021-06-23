package com.practice.crud.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.entities.Employee;
import com.practice.crud.repos.EmployeeRepo;
import com.practice.crud.response.dto.EmployeeResponseDto;
import com.practice.crud.services.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private EmployeeService empService;
	
	
	// private List<Employee> employeeList;
	
//	private List<Employee> listEmployees(){
//		this.employeeList = new ArrayList<Employee>(); 
//		this.employeeList.add(new Employee(1L,"emp1", "emp1 name","it", 1000.0F,"emp1@gmail.com"));
//		this.employeeList.add(new Employee(2L,"emp2", "emp2 name","admin", 500.0F,"emp2@gmail.com"));
//		return this.employeeList;
//	}
	
	@GetMapping("/")
	public List<EmployeeResponseDto> getEmployees(){
		return empService.getEmployees();
	}
	
//	@GetMapping("/{id}")
//	public Optional<Employee> getEmployeeById(@PathVariable Long id){		
//		return empService.getEmployeeById(id);
//	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeByEmpId(@PathVariable String empId){		
		return empService.getEmployeeByEmpId(empId);
		
		
	}
	
	@GetMapping("/byemail/{email}")
	public EmployeeResponseDto getEmployeeByEmail(@PathVariable String email){		
		EmployeeResponseDto empResponseDto = empService.getEmployeeByEmail(email);
		return empResponseDto;
	}
	@GetMapping("/byName/{name}/bySalary/{salary}")
	public List<EmployeeResponseDto> getEmployeeByNameAndSalary(@PathVariable String name, @PathVariable Float salary){		
		return  empService.getEmployeeByNameAndSalary(name, salary);
		
	}
	
	@GetMapping("/byDept/{deptNo}")
	public List<EmployeeResponseDto> getEmployeeByDeptNo(@PathVariable String deptNo){
		
		return empService.getEmployeeByDeptNo(deptNo);
		
	}
	
	
//	@PostMapping("/")
//	public List<Employee> createEmployees(@RequestBody Employee emp){
//		// this.listEmployees();
//		// this.empService.
//	}
	
//	@PostMapping("/{id}")
//	public List<Employee> updateEmployees(@PathVariable Long empId,@RequestBody Employee emp){
//		Employee updateEmployee = this.getEmployeeById(empId).get();
//		updateEmployee.setEmpId(emp.getEmpId());
//		updateEmployee.setDept(emp.getDept());
//		updateEmployee.setName(emp.getName());
//		updateEmployee.setSalary(emp.getSalary());
//		return this.employeeList;
//	}
	
//	@DeleteMapping("/{empId}")
//	public List<Employee> deleteEmployees(@PathVariable String empId){
//		this.employeeList.removeIf(emp -> emp.getEmpId().equals(empId));
//		return this.employeeList;
//	}
}
