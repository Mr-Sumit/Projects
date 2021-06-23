package com.practice.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.response.dto.DepartmentResponseDto;
import com.practice.crud.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/")
	public List<DepartmentResponseDto> getAllDepartment(){
		return deptService.getAllDepartments();
	}
}
