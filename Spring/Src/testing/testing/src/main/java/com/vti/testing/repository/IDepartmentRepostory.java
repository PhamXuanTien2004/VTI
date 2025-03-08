package com.vti.testing.repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepostory extends JpaRepository<Department, Integer> {
}
