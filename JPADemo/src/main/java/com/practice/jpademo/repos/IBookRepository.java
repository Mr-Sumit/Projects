package com.practice.jpademo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jpademo.entities.Book;
import com.practice.jpademo.entities.User;

public interface IBookRepository extends JpaRepository<Book, Long>{

}
