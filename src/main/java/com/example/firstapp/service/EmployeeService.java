package com.example.firstapp.service;

import java.util.List;
import com.example.firstapp.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
	Employee getEmployeeBydId(long employeeId);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
}
