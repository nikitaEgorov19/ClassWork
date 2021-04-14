package com.example.core;

public class Person {
    private  String first_name;
    private String last_name;
    private String thrid_name;
    private int date_born;
    private String login;
    private int indificator;

    public Person(String first_name, String last_name, String thrid_name, int date_born, String login, int indificator) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.thrid_name = thrid_name;
        this.date_born = date_born;
        this.login = login;
        this.indificator = indificator;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getThrid_name() {
        return thrid_name;
    }

    public void setThrid_name(String thrid_name) {
        this.thrid_name = thrid_name;
    }

    public int getDate_born() {
        return date_born;
    }

    public void setDate_born(int date_born) {
        this.date_born = date_born;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIndificator() {
        return indificator;
    }

    public void setIndificator(int indificator) {
        this.indificator = indificator;
    }
}
