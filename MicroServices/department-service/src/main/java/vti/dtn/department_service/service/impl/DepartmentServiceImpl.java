package vti.dtn.department_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vti.dtn.department_service.entity.DepartmentEntity;
import vti.dtn.department_service.repository.DepartmentRepository;
import vti.dtn.department_service.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentEntity> getListDepartments() {
        return departmentRepository.findAll();
    }
}
