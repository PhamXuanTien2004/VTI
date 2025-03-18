package com.vti.testing.entity;

import jakarta.persistence.AttributeConverter;

public class ArticleStatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getSql();
    }

    @Override
    public Status convertToEntityAttribute(String sql) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.getSql().equals(sql)) {
                return status;
            }
        }
        return null;
    }
}