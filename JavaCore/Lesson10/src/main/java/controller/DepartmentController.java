package controller;

import entity.Department;
import service.DepartmentService;
import service.IDepartmentService;

import java.util.List;

public class DepartmentController {
    private IDepartmentService departmentService = new DepartmentService();

    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    public Department getDepartmentById(int id) {
        return departmentService.getDepartmentById(id);
    }

    public boolean createDepartment (Department department){
        return departmentService.createDepartment(department);
    };

    public boolean updateDepartment (int id, Department department){
        department.setId(id);
        return departmentService.updateDepartment(department);
    }

    public boolean deleteDepartment( int id){
        return departmentService.deleteDepartment(id);
    }
}