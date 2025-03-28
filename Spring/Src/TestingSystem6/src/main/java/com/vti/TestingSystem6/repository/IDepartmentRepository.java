package com.vti.TestingSystem6.repository;

import com.vti.TestingSystem6.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository <Department, Integer> {
}
