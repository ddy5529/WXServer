package com.ddy.wxServer.Model.roles;

public class UserEntity {
    public UserEntity(){
        this.user_sex = "";
        this.role_name = "";
        this.userName = "";
        this.passWord = "";
        this.userPhone = "";
    }
    public UserEntity( String user_sex, String role_name, String userName, String passWord, String userPhone) {
        this.user_sex = user_sex;
        this.role_name = role_name;
        this.userName = userName;
        this.passWord = passWord;
        this.userPhone = userPhone;
    }

    public UserEntity(int user_id, String user_sex, String role_name, String userName, String passWord, String userPhone) {
        this.user_id = user_id;
        this.user_sex = user_sex;
        this.role_name = role_name;
        this.userName = userName;
        this.passWord = passWord;
        this.userPhone = userPhone;
    }

    private int user_id;

    private String user_sex;

    private String role_name;

    private String userName;

    private String passWord;

    private String userPhone;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
