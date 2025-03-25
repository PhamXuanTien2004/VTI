package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }

    @Override
    public List<Department> getDepartmentsTotalMemberByRange(int from, int to) {
        return departmentRepository.findByTotalMemberBetween(from, to);
    }
}
