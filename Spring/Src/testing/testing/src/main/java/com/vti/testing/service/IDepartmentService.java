package com.vti.testing.service;

import com.vti.testing.entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(int id);

    ResponseEntity<Object> getDepartmentById (int id);
}