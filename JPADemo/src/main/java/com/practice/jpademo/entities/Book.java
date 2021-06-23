package com.practice.jpademo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Float price;
	private Integer noOfPages;
//	@OneToOne
//	private Author authors;
	
	@OneToMany
	private List<Author> authors;
	
}
