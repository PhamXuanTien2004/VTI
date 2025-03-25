package com.vti.testing.repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{
    List <Department> findByNameContaining (String name);
    @Query("FROM Department WHERE totalMember BETWEEN ?1 AND ?2")
    List<Department> findByTotalMemberBetween(int from, int to);
}
