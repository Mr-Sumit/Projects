package com.practice.crud.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.crud.entities.Employee;
import com.practice.crud.response.dto.EmployeeResponseDto;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findByEmpId(String empId);

	Optional<Employee> findByEmail(String email);
	
	List<Employee> findByNameContaining(String name);
	
	List<Employee> findByNameContainingIgnoreCaseAndSalary(String name, float salary);

	List<Employee> findBySalaryGreaterThan(float salary);

	List<Employee> findByDeptDeptNo(String deptNo);
}
