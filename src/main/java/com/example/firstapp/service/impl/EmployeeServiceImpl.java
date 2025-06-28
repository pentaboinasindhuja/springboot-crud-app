package com.example.firstapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.firstapp.exception.ResourceNotFoundException;
import com.example.firstapp.model.Employee;
import com.example.firstapp.repository.EmployeeRepository;
import com.example.firstapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	@Override
	public Employee getEmployeeBydId(long employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() ->
		new ResourceNotFoundException("Employee","Id","employeeId"));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id","id"));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
		
		
		
	}

	@Override
	public void deleteEmployee(long id) {
		//check employee exist in the database or not
		
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","id","id"));
		
		employeeRepository.deleteById(id);
		
	}
}
