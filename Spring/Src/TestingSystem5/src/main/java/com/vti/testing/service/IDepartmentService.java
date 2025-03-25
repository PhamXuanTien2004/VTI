package com.vti.testing.service;

import com.vti.testing.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    public Department getDepartmentById(int id);

    public List<Department> getDepartmentByName (String name);

    List<Department> getDepartmentsTotalMemberByRange(int from, int to);
}
