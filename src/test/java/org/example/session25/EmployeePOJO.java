package org.example.session25;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//To ignore or exclude multiple properties in Serialization/DeSerialization Process
@JsonIgnoreProperties(value = {"gender", "fullname"})
public class EmployeePOJO {

    //To ignore or exclude the property in Serialization and not DeSerialization Process
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String firstname;
    private String lastname;
    private String gender;
    private int age;

    //To ignore or exclude the property in DeSerialization and not Serialization Process
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double salary;

    private boolean isMarried;

    //To ignore or exclude the property in Serialization/DeSerialization Process
    @JsonIgnore
    private String fullname;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
