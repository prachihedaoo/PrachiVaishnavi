package com.spring.app.main.service;



import java.util.Arrays;
import java.util.List;

//import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
@Service
//@ComponentScan(basePackages = "com.spring.main.controller,com.spring.app.main.service")
public class EmployeeService {

public List<Employee> getList()
{
	Employee e11=new Employee(1,"Harry Potter","London",85000);
	Employee e22=new Employee(2,"Ronald Weasly","Kent",75000);
	
	Employee e33=new Employee(3,"Hermione Granger","London",90000);
	List<Employee> list = Arrays.asList(e11,e22,e33);

	return list;
}
public void saveEmployee(Employee employee)
{
	System.out.println("Employee data is inserted in db"+employee);
}
public void deleteEmployee(int id)
{
	System.out.println("Employee eith id:"+id+" deleted");
}
}