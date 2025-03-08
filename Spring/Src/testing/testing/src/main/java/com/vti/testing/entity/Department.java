package com.vti.testing.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // class là 1 entity
@Table (name = "Department") //config bảng
@NoArgsConstructor // tạo contructor không tham số
//@Getter //getter cho tất cả các properties
//@Setter //setter cho tất cả các properties
public class Department {
    @Id //PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    @Column(name = "DepartmentID") //config cột (name = "tên cột")
    private int id;

    @Column(name ="DepartName" , length = 50, nullable = false) //length = độ dài tối đa | nulltable =  NOT NULL
    private String name;

    //contructor không tham số
    //getter, setter cho tất cả thuộc tính (property)

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
