package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //class thuộc layer Service
public class DepartmentService implements IDepartmentService {
    @Autowired //tự động khỏi tạo đối tượng
    private IDepartmentRepostory departmentRepostory;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepostory.findAll();
    }
}
