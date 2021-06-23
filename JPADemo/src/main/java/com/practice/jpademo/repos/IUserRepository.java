package com.practice.jpademo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.jpademo.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
