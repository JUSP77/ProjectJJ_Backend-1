package com.perfumeReco.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Member {

    private int no;
    private String id;
    private String password;

    public Member() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
