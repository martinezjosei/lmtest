package com.luv2code.springboot.demo.mycoolapp.controller;

//import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import com.luv2code.springboot.demo.mycoolapp.service.EmployeeService;

@RestController
//@SessionAttributes("name")
public class LoginController {

	@Autowired
	EmployeeService employeeService;
	

    @GetMapping("/")
    public String showWelcome(ModelMap model) {
    	System.out.println("USER IS: " + getLoggedInUsername());
    	//model.put("name", getLoggedInUsername());
        return "welcome";
    }
    
    private String getLoggedInUsername() {
    	Authentication authentication = 
    	SecurityContextHolder.getContext().getAuthentication();
    	 return authentication.getName();
    }
    

    // **** CRUD Operations  ******

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee, ModelMap model) {
    	//System.out.println("MODEL GET: "  + (String)model.get("name"));
    	System.out.println("IN THE CREATE: User=" + getLoggedInUsername());
    	return employeeService.createEmployee(employee);
    }
    
    @GetMapping("/read/{id}")
    public String readEmployee(@PathVariable (name="id") long id, ModelMap model) {
    	System.out.println("MODEL GET: "  + model.get("name"));
    	return employeeService.readEmployee(id);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable(name = "id") long id, @RequestBody Employee employee ) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee); 
        } catch (Exception e) {
            // Return a descriptive error response with an appropriate HTTP status.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error updating employee: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (name="id") long id) {
        try {
			return employeeService.deleteEmployee(id);
		} catch (Exception e) {
			return e.getMessage();
		}
    }


}






