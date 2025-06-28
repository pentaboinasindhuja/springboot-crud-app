//package com.example.firstapp.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.firstapp.model.Employee;
//
//public interface EmployeeRepository extends JpaRepository<Employee,Long>{
//
//}


package com.example.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
