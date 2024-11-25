package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;

public interface EmployeeService {	

		public String setEmployee (String outputMsg); 
	
		public Employee createEmployee(Employee employee);

		public String readEmployee(Long employeeId);

		public Employee updateEmployee(Long employeeId, Employee employee) throws Exception;

		public String deleteEmployee(Long employeeId) throws Exception;

}
