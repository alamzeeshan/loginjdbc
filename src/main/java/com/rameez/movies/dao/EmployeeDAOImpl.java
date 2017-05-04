package com.rameez.movies.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rameez.movies.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("Inside EmployeeDAOImpl: getAllEmployees");
		return getHardcodedEmps();
	}

	private List<Employee> getHardcodedEmps() {
		List<Employee> empList = new ArrayList<>();
		
		Employee emp1 = new Employee("Sango", "25", 10198.32);
		Employee emp2 = new Employee("Rameez", "26", 12198.99);
		
		
		empList.add(emp1);
		empList.add(emp2);
		
		return empList;
	}

}
