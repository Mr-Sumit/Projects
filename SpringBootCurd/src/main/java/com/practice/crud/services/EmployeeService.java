package com.practice.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.crud.entities.Employee;
import com.practice.crud.repos.EmployeeRepo;

import com.practice.crud.response.dto.EmployeeResponseDto;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	public List<EmployeeResponseDto> getEmployees(){
		List<EmployeeResponseDto> employees = new ArrayList<EmployeeResponseDto>();
		ModelMapper modelMapper = new ModelMapper();
		
		empRepo.findAll().forEach(emp -> {
			employees.add(modelMapper.map(emp, EmployeeResponseDto.class));
		});
		return employees;
	}

	public Optional<Employee> getEmployeeById(Long id) {

		return empRepo.findById(id);
	}
	
	public ResponseEntity<EmployeeResponseDto> getEmployeeByEmpId(String empId) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<Employee> empByEmpId = empRepo.findByEmpId(empId);
		
		if(!empByEmpId.isEmpty()) {
			return new ResponseEntity(empByEmpId.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}

	public EmployeeResponseDto getEmployeeByEmail(String email) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(empRepo.findByEmail(email).get(), EmployeeResponseDto.class);
		
	}
	
	public List<EmployeeResponseDto> getEmployeeByNameAndSalary(String name, Float sal){
		ModelMapper modelMapper = new ModelMapper();
		List<EmployeeResponseDto> employees = new ArrayList<EmployeeResponseDto>();
		empRepo.findByNameContainingIgnoreCaseAndSalary(name, sal).forEach(emp -> {
			employees.add(modelMapper.map(emp, EmployeeResponseDto.class));
		});
		return employees;
	}

	public List<EmployeeResponseDto> getEmployeeByDeptNo(String deptNo) {
		List<EmployeeResponseDto> employees = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		empRepo.findByDeptDeptNo(deptNo).forEach(emp -> {
			employees.add(modelMapper.map(emp, EmployeeResponseDto.class));
		});
		return null;
	}
}
