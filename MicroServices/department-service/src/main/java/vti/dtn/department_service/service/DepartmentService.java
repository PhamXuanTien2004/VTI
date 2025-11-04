package vti.dtn.department_service.service;

import vti.dtn.department_service.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getListDepartments();
}
