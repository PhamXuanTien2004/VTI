package com.vti.testing.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // class là 1 entity
@Table(name = "Department") // config bảng
//@NoArgsConstructor // tạo constructor không tham số
//@Getter // getter của tất cả property
//@Setter // setter của tất cả property
public class Department {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "DepartmentID") // config cột (name: tên cột)
    private int id;
    @Column(name = "DepartmentName", length = 50, nullable = false) // length: độ dài tối đa | nullable <=> NOT NULL
    private String name;

    // constructor không tham số
    // getter, setter cho tất cả property

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}