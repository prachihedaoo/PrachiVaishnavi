package com.spring.main.controller;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Employee;
import com.spring.app.main.service.EmployeeService;

@Controller
public class MyController {
	
	@RequestMapping("/")
public String showDashboard() {
		System.out.println("dashboard in controller..");
	return "WEB-INF/jsps/dashboard.jsp";
	}
	@RequestMapping("/employees")
	public String showEmployees(Model model,EmployeeService employeeservice) {
	//dependency injection {
			System.out.println("employees in controller..");
		//I want to pass some data to employees.jsp
		//null
			model.addAttribute("msg","Hello");
			model.addAttribute("price",20000D);
			Integer[] iarray=new Integer[] {1,2,3,4,5,6,7};
			
			model.addAttribute("iarray", iarray);
			List<Employee> list=employeeservice.getList();
			model.addAttribute("list",list);
			
					return "WEB-INF/jsps/employees.jsp";
	}
	@RequestMapping("/college")
	public String showColleges(HttpServletRequest request) {
		request.setAttribute("collegeName","ABC Institute of tech");
		String[] sarry=new String[] {"ABC Institute","PQR Institute"	};
		request.setAttribute("sarry",sarry);
		return "WEB-INF/jsps/college.jsp";
	}

		@RequestMapping("/student")
		public ModelAndView showStudent(ModelAndView mav) {
			//	System.out.println("student in controller..");
			mav.addObject("sname","Harry Potter");
			mav.setViewName("WEB-INF/jsps/student.jsp");
			List<String>list=new ArrayList<>();
			list.add("Ronald");
			list.add("Hermione");
			list.add("Harry");
			list.add("draco");
			list.add("nevile");
			list.add("Hagrid");
			list.add("Jenny");
			mav.addObject("slist",list);
			return mav;
		}
		@RequestMapping("/add-employee")
		public String readEmployeeDetails(@RequestParam("ename")String name,
				                        @RequestParam("ecity")String city,
				                        @RequestParam("esalary")double salary,
				                        HttpServletRequest request) {
			Employee e=new Employee();
			e.setName(name);
			e.setCity(city);
			
			e.setSalary(salary);
			System.out.println(e);
			String cpath=request.getContextPath();
			return "redirect: "+ cpath +"/employees";
			
					
			
		}
		@RequestMapping("/sample-link")
		public String sampleLink(@RequestParam("name") String name
								,HttpServletRequest request) {
			System.out.println(name);

			String cpath = request.getContextPath();
			return "redirect: "+ cpath + "/students";
		}
		
		

}

