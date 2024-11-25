package com.luv2code.springboot.demo.mycoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;



// public interface UserRepository extends CrudRepository<User, Integer>
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
