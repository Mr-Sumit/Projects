package com.practice.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.repos.DepartmentRepo;
import com.practice.crud.response.dto.DepartmentResponseDto;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;
	
	
	public List<DepartmentResponseDto> getAllDepartments(){
		
			List<DepartmentResponseDto> allDepartment = new ArrayList<DepartmentResponseDto>();
			ModelMapper modelMapper = new ModelMapper();
			
			deptRepo.findAll().forEach(dept -> {
				allDepartment.add(modelMapper.map(dept, DepartmentResponseDto.class));
			});
			return allDepartment;
		
	}
}
