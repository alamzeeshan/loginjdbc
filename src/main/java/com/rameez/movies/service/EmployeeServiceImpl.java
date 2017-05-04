package com.rameez.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameez.movies.dao.EmployeeDAO;
import com.rameez.movies.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("Inside EmployeeServiceImpl: getAllEmployees");
		List<Employee> allEmps = employeeDao.getAllEmployees();
		return allEmps;
	}

}
