package com.luv2code.springboot.demo.mycoolapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import com.luv2code.springboot.demo.mycoolapp.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

@Override
public String setEmployee(String outputMsg) {
	System.out.println("INSIDE THE SERVICE IMPL, outputMsg=" + outputMsg);
	//Student student = new Student("Jose", "Martinez", "me@me.com");
	Employee employee = new Employee("Rochiel", "Bugal", "she@she.com", 29, "2yrs 5mo");
	employeeRepository.save(employee);
	return "Setting Employee";
}


@Override
public Employee createEmployee(Employee employee) {
	return employeeRepository.save(employee);
}

@Override
public String readEmployee(Long employeeId) {
	Optional<Employee> employee = employeeRepository.findById(employeeId);
	
    if (employee.isPresent()) {
    	return employee.toString();
    } else {
        return ("Employee id " + employeeId + " was not found!");
    }
}

@Override
public Employee updateEmployee(Long employeeId, Employee updateEmployee) throws Exception {
	Optional<Employee> currentEmployee = employeeRepository.findById(employeeId);
	
    if (currentEmployee.isPresent()) {
    	Employee FoundEmployee = currentEmployee.get();
    	FoundEmployee.setName(updateEmployee.getName());
    	FoundEmployee.setPrimaryAddress(updateEmployee.getPrimaryAddress());
    	FoundEmployee.setPrimaryContactInfo(updateEmployee.getPrimaryContactInfo());
    	FoundEmployee.setAge(updateEmployee.getAge());
    	FoundEmployee.setYearsAtCompany(updateEmployee.getYearsAtCompany());
    	
        employeeRepository.save(FoundEmployee);
        return FoundEmployee;
    } else {
        throw new Exception("Employee id " + employeeId + " was not found!");
    }
}

@Override
public String deleteEmployee(Long employeeId) throws Exception {
	Optional<Employee> employee = employeeRepository.findById(employeeId);
	
    if (employee.isPresent()) {
        employeeRepository.delete(employee.get());
        return "Employee deleted!";
    } else {
        throw new Exception("Employee id " + employeeId + " was not found!");
    }
} 
	
}



//@Service
//public class RestDemoServiceImpl implements RestDemoService {
//
//    @Autowired
//    private CountriesRepository countriesRepository; // Injects the DepartmentRepository dependency.
//    
//	public void setOutput (String outputMsg) {
//		System.out.println("The SERVICE Output is: " + outputMsg);
//		Countries countries = new Countries();
//		countries.setName("Puerto Rico");
//		countriesRepository.save(countries);
//	}