package com.practice.crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.crud.entities.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
