package com.vti.testing.entity;

public enum Status {
    OPEN("O"), REVIEW("REV"), APPROVED("A"), REJECTED("REJ");
    private String sql;

    Status(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}