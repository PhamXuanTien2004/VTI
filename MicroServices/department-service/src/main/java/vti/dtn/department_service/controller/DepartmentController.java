package vti.dtn.department_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vti.dtn.department_service.entity.DepartmentEntity;
import vti.dtn.department_service.model.Department;
import vti.dtn.department_service.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getListDepartments() {
        List <DepartmentEntity> departmentEntities = departmentService.getListDepartments();
        return departmentEntities.stream()
                .map(departmentEntity -> new Department(
                        departmentEntity.getName(),
                        departmentEntity.getCreatedAt()))
                .toList();
    }
}
