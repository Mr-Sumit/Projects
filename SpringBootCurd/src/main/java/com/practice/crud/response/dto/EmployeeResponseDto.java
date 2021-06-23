package com.practice.crud.response.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.crud.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeResponseDto {
	private String empId;
	private String name;
	
	private Float salary;
	private String email;
	@JsonManagedReference
	private DepartmentResponseDto dept;
}
