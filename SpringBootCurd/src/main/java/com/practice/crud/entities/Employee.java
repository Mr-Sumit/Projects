package com.practice.crud.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@Entity
public class Employee {
	

	@Id
	@GeneratedValue
	private Long id;
	private String empId;
	private String name;
	private Float salary;
	private String email;
	
	@ManyToOne
	private Department dept;
	
	public Employee( String empId, String name, Float salary, String email, Department dept) {
		super();
		
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}
}
