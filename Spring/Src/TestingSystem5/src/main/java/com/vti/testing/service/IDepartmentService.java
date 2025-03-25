package com.vti.testing.service;

import com.vti.testing.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllAddresses();
    public Department getDepartmentById(int id);

}
