package com.practice.crud.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Department {
	@Id
	@GeneratedValue
	Long id;
	private String deptNo;
	private String name;
	
	@OneToMany(mappedBy="dept")
	private List<Employee> emp;
	

}
