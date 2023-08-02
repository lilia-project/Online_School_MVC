package org.mvc.entity;

public enum ResourceType {
    URL(1),
    VIDEO(2),
    BOOK(3);
    private final int parameter;

    ResourceType(int parameter) {
        this.parameter = parameter;
    }

    public int getParameter() {
        return parameter;
    }
}
