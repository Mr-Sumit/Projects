package com.practice.jpademo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jpademo.entities.Author;
import com.practice.jpademo.entities.User;

public interface IAuthorRepository extends JpaRepository<Author, Long>{

}
