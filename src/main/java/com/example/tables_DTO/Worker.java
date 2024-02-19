package com.example.tables_DTO;

import java.util.Date;

public class Worker {
    private int id;
    private String name;
    private Date birthday;
    private String level;
    private int salary;

    private String type;

    public Worker(int id, String name, Date birthday, String level, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public Worker(String name, Date birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                        ", name= " + name +
                        ", birthday= " + birthday +
                        ", level= " + level +
                        ", salary=" + salary;
    }
}
