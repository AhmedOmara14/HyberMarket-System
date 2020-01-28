/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

/**
 *
 * @author Ahmed
 */
public class user {

    private String fname, lname, Department, gender, user_name, password;
    private int id, age;

    public user(int id, String fname, String lname, int age, String Department, String gender, String user_name, String password) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.Department = Department;
        this.gender = gender;
        this.user_name = user_name;
        this.password = password;
    }

    public user(String user_name, String password, String Department) {
        this.user_name = user_name;
        this.password = password;
        this.Department = Department;
    }

    public user(int id, String fname, String lname, int age, String Department, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.Department = Department;
        this.gender = gender;

    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
