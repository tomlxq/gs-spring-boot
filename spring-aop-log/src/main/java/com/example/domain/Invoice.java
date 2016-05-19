package com.example.domain;

import java.util.Date;

/**
 * Created by tom on 2016/5/19.
 */
public class Invoice extends IdEntity {
    String no;//序列号
    Date date;
    Float salary;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
