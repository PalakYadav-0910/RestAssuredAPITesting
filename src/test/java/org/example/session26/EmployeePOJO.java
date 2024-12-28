package org.example.session26;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//To ignore Unknown Properties in Serialisation/DeSerialisation Process
//@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePOJO {

    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private double salary;
    private boolean isMarried;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean getMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

}
