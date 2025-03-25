package com.vti.testing.repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{
    List <Department> findByNameContaining (String name);

    List<Department> findByTotalMemberBetween(int from, int to);
}
