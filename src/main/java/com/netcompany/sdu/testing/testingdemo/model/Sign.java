package com.netcompany.sdu.testing.testingdemo.model;

/**
 * Created by mrr on 27/11/2018.
 */
public enum Sign {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE(":"),
    MULTIPLY("*");

    private String name;

    Sign(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
