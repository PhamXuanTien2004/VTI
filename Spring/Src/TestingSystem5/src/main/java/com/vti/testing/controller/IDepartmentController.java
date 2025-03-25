package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class IDepartmentController {
    @Autowired
    private IDepartmentService departmentService;


    @GetMapping
    public List<Department> getAllAddresses() {
        List<Department> departments = departmentService.getAllAddresses();
        return departmentService.getAllAddresses();
    }

    @GetMapping("{id}")
    public Department getDepartmentById(@PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        return departmentService.getDepartmentById(id);
    }
}
