package com.sunyk.base.domain;

public class EasyObject {
    private String var;


    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "EasyObject{" +
                "var='" + var + '\'' +
                '}';
    }
}
