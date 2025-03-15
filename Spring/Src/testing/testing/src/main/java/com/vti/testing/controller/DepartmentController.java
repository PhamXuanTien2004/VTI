package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // TODO: Homework (path {id})
    public Department getDepartmentById(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody Department department) { // @RequestBody: lấy thông tin client truyền trong body
        Department departmentCreated = departmentService.createDepartment(department);
        return new ResponseEntity<>(departmentCreated, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateDepartment(@PathVariable int id, @RequestBody Department department) { // @PathVariable lấy giá trị được truyền ở đường dẫn
        department.setId(id);
        Department departmentUpdated = departmentService.updateDepartment(department);
        return new ResponseEntity<>(departmentUpdated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Department id = " + id + " deleted", HttpStatus.OK);
    }
}