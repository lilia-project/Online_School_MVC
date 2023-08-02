package org.mvc.entity;

public enum Role {

    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String field;

    Role(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
