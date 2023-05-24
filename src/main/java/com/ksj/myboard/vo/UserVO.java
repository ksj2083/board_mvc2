package com.ksj.myboard.vo;

public class UserVO {

    private int no;
    private String email;
    private String password;

    public UserVO(int no, String email, String password) {
        this.no = no;
        this.email = email;
        this.password = password;
    }

    public UserVO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserVO() {}

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
