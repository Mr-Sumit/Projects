package com.practice.crud.response.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class DepartmentResponseDto {
	private String deptNo;
	private String name;
	@JsonBackReference
	private List<EmployeeResponseDto> employeeResponseDto;
	
}
