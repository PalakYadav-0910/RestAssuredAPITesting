package org.example.session23;

import java.util.List;

public class ComplexNestedJSONPayloadPOJO {

    /*
    {
    "companyName" : "XYZ Ltd",
"Street" : "Arifac Avenue",
"City" : "RK Puram, Delhi",
"State" : "New Delhi",
"Pin Code" : 110066,
"bankAccounts" : ["HDFC", "SBI", "ICICI"],
    "employees" :
[
{
  "firstName" : "Suresh",
  "lastName" : "Mehra",
  "gender" : "Male",
  "age" : 35,
  "salary" : 10000.56,
  "Address" : {
                 "Street" : "Park Avenue",
				 "City" : "Vijawada",
				 "State" : "Andhra Pradesh",
				 "Pin Code" : 530012
			  }
},
{
  "firstName" : "Amit",
  "lastName" : "Gupta",
  "gender" : "Male",
  "age" : 30,
  "salary" : 340000,
  "Address" : {
                 "Street" : "Plot 7",
				 "City" : "Vijaywada",
				 "State" : "Andhra Pradesh",
				 "Pin Code" : 530012
			  }
},
{
  "firstName" : "Ashish",
  "lastName" : "Das",
  "gender" : "Male",
  "age" : 39,
  "salary" : 550000,
  "Address" : {
                 "Street" : "Plot 8",
				 "City" : "Dwarka",
				 "State" : "New Delhi",
				 "Pin Code" : 110066
			  }
}
]
}
     */

    private String companyName;
    private String street;
    private String city;
    private String state;
    private int pincode;
    private List<String> bankAccounts;
    private List<EmployeePOJO> employeeList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public List<String> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<String> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<EmployeePOJO> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeePOJO> employeeList) {
        this.employeeList = employeeList;
    }

}
