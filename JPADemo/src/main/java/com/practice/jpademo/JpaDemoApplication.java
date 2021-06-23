package com.practice.jpademo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.jpademo.entities.Author;
import com.practice.jpademo.entities.Book;
import com.practice.jpademo.entities.User;
import com.practice.jpademo.repos.IAuthorRepository;
import com.practice.jpademo.repos.IBookRepository;
import com.practice.jpademo.repos.IUserRepository;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
	
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IAuthorRepository authorRepo;
	@Autowired
	private IBookRepository bookRepo;
	
	
//	@PostConstruct
//	public void createUser() {
//		userRepo.save(new User("User1", "user1@gmail.com","MyPwd", 123456789L));
//	}
	
	@PostConstruct
	public void createAuthor() {
		Author author = new Author();
		author.setName("Jk Rowling");
		author.setEmail("jkr@gmail.com");
		
		authorRepo.save(author);
		
		Author author1 = new Author();
		author1.setName("Jk Rowling 1");
		author1.setEmail("jkr1@gmail.com");
		authorRepo.save(author1);
		
		Book book1 = new Book();
		book1.setName("Harry potter 1");
		book1.setNoOfPages(200);
		book1.setPrice(2000F);
		// book1.setAuthors(author);
		// author.setBook(book1);
		book1.setAuthors(Arrays.asList(author, author1));
		
		
		bookRepo.save(book1);
		
	}
	

}
