package com.vti.TestingSystem6.dto;

public class AccountDTO {
    private int id;
    private String userName;
    private int departmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(int departmentName) {
        this.departmentName = departmentName;
    }
}
