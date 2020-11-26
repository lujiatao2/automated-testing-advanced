package com.lujiatao.c09;

public class Person {

    private String idCard;
    private String name;

    public Person(String idCard, String name) {
        this.idCard = idCard;
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
