package com.vti.testing.service;

import com.vti.testing.entity.Department;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(int id);

    Department getDepartmentById (int id);
}