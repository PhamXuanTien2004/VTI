package com.example.vtibedtn2506_usermanagement.repository;

import com.example.vtibedtn2506_usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
}
