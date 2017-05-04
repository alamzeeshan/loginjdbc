package com.rameez.movies.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rameez.movies.dao.LoginDaoImpl;
import com.rameez.movies.model.Dog;
import com.rameez.movies.model.Employee;
import com.rameez.movies.service.EmployeeService;


@Controller
public class HomeController {
	
	/*@Autowired
	EmployeeService empService;*/
	
	LoginDaoImpl dao;

	public HomeController() {
		super();
		dao=new LoginDaoImpl();
	}

	@RequestMapping("/")
	public String applicationEntry() {
		System.out.println("*******applicationEntry***********");
		return "index";
	}	
	
	@RequestMapping("/model")
	public ModelAndView modelTest(HttpServletRequest request, 
	        HttpServletResponse response, HttpSession session) {
		
		Employee emp = new Employee("Sango", "25", 10198.32);
		Dog dog = new Dog("Tommy", "Bulldog");
		emp.setDog(dog);
		
		ModelAndView mv = new ModelAndView();

		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("NameStringKey", "Rameez");
		modelMap.addAttribute("myemp", emp);
		request.setAttribute("ReqKey", "In Request");
		
		mv.addAllObjects(modelMap);
		
		mv.setViewName("modelpage");
		return mv;
	}
	
	
		@RequestMapping(value="/employee", method=RequestMethod.GET)
	public ModelAndView getEmployees() {
		System.out.println("Inside HomeController : getEmployees()");
		
		//List<Employee> empList = empService.getAllEmployees();
		//Employee emp = new Employee("Rameez", "25", 10989.33);
		
		String message = "Hellow From rameez";
		
		ModelAndView mv = new ModelAndView();
		
		//DATA
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("msg", message);
		modelMap.addAttribute("msg1", "MSG1");
		modelMap.addAttribute("msg2", "MSG2");
//		/request.setAttribute("msg2", "MSG2");
		
		
		mv.addAllObjects(modelMap);
		
		
		//VIEW
		mv.setViewName("employeePage");
		
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("In login");
		request.getSession().invalidate();
		
		String viewName="";
		ModelMap modelMap = new ModelMap();
		
		ModelAndView mv = new ModelAndView();
		String user = request.getParameter("user");
		String password = request.getParameter("pwd");
		System.out.println(user);
		System.out.println(password);
		
		
		String result=dao.authorise(user, password);
		
		if (result.startsWith("Error")) //error
		{
			viewName="index";
			//modelMap.addAttribute("result", result);
			request.setAttribute("result", result);
		} else { // success
			viewName="welcome";
			modelMap.addAttribute("username", user);
			request.getSession().setAttribute("username", user);
		}
		mv.addAllObjects(modelMap);
		mv.setViewName(viewName);
		return mv;
	}
	
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView getStudent() {
		System.out.println("Inside HomeController : getStudent()");
		
		//List<Employee> empList = empService.getAllEmployees();
		//Employee emp = new Employee("Rameez", "25", 10989.33);
		
		String message = "Hellow From student";
		
		ModelAndView mv = new ModelAndView();
		
		//DATA
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("msg", message);
		modelMap.addAttribute("msg1", "MSG1");
		modelMap.addAttribute("msg2", "MSG2");
//		/request.setAttribute("msg2", "MSG2");
		
		
		mv.addAllObjects(modelMap);
		
		
		//VIEW
		mv.setViewName("student");
		
		return mv;
	}
	
}
