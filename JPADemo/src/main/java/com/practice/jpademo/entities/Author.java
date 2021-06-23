package com.practice.jpademo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Author {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	
//	@OneToOne(mappedBy = "authors")
//	private Book book;
	
}
