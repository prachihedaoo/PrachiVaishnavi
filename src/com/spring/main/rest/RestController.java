package com.spring.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.model.Employee;
import com.spring.app.main.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController

public class RestController {
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping(value="/api/hello",method=RequestMethod.GET)
	public String helloApi() {
		return "Hello Rest Api";
	}
	@RequestMapping(value="/api/grade/{marks}",method=RequestMethod.GET)
public String computeGradeApi(@PathVariable("marks") double marks)
{
	double totalMarks=500;
	double percent=(marks*100)/totalMarks;
	String grade=percent>75?"A":percent>60?"B":"C";
	return grade;
}
	@RequestMapping(value="/api/employees/all",method=RequestMethod.GET)
	public List<Employee> getAllEmployees()
	{
		List<Employee> list=employeeService.getList();
		return list;
	}
	@RequestMapping(value="/api/employee/one/{id}")
	public ResponseEntity<Object> getEmployeeId(@PathVariable("id") int id)
	{
		List<Employee> list=employeeService.getList();
		Employee employee=null;
		for(Employee e:list)
		{
			if(e.getId()==id)
			{
				employee=e;
				break;
			}
		}
		if(employee==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
		
	}
	 @RequestMapping(value = "/api/employee/add", method = RequestMethod.POST)
     public ResponseEntity<String> postEmployee(@RequestBody Employee employee){
         employeeService.saveEmployee(employee);
         return ResponseEntity.status(HttpStatus.OK).body("Employee added...");

     }
	 @RequestMapping(value="/api/employees/delete",method = RequestMethod.DELETE)
	    public ResponseEntity<String> deleteEmployee(@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
	        if(id == 0) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("HEY, Valid ID needed...");
	        }
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted..");

	    }    

	
}
