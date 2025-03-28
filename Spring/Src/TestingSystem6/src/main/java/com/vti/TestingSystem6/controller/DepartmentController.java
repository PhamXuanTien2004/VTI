package com.vti.TestingSystem6.controller;

import com.vti.TestingSystem6.dto.AccountDTO;
import com.vti.TestingSystem6.dto.DepartmentDTO;
import com.vti.TestingSystem6.entity.Account;
import com.vti.TestingSystem6.entity.Department;
import com.vti.TestingSystem6.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public List<DepartmentDTO> getAll(){
        List<Department> departments = departmentService.getAll();
        return modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>() {
        }.getType());
    }
}
