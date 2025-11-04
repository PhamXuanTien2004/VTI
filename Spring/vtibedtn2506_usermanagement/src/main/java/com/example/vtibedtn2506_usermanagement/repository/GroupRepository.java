package com.example.vtibedtn2506_usermanagement.repository;

import com.example.vtibedtn2506_usermanagement.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> searchByNameGroup(String name);
}
