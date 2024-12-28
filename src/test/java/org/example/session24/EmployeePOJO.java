package org.example.session24;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

//To exclude default values for fields for which values are not set
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)

//To exclude null values for fields for which values are not set
//@JsonInclude(JsonInclude.Include.NON_NULL)

//To exclude empty values for fields for which values are not set
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeePOJO {

    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private double salary;
    private boolean isMarried;
    private String[] hobbies;

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<String> degrees) {
        this.degrees = degrees;
    }

    public Map<String, String> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Map<String, String> familyMembers) {
        this.familyMembers = familyMembers;
    }

    private List<String> degrees;
    private Map<String, String> familyMembers;

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

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

}
