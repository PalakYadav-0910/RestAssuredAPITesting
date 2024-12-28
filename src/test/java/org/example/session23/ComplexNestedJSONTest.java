package org.example.session23;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ComplexNestedJSONTest {

    @Test
    public void createUser() throws JsonProcessingException {

        ComplexNestedJSONPayloadPOJO requestPayload = new ComplexNestedJSONPayloadPOJO();
        requestPayload.setCompanyName("XYZ Ltd");
        requestPayload.setStreet("Arifac Avenue");
        requestPayload.setCity("RK Puram, Delhi");
        requestPayload.setState("New Delhi");
        requestPayload.setPincode(110066);

        //Bank Account List
        List<String> bankAccounts = new ArrayList<>();
        bankAccounts.add("HDFC");
        bankAccounts.add("SBI");
        bankAccounts.add("ICICI");

        requestPayload.setBankAccounts(bankAccounts);

        EmployeePOJO emp1 = new EmployeePOJO();
        EmployeePOJO emp2 = new EmployeePOJO();
        EmployeePOJO emp3 = new EmployeePOJO();

        EmployeeAddress emp1Address = new EmployeeAddress();
        EmployeeAddress emp2Address = new EmployeeAddress();
        EmployeeAddress emp3Address = new EmployeeAddress();

        //Set first Employee
        emp1.setFirstname("Suresh");
        emp1.setLastname("Mehra");
        emp1.setGender("Male");
        emp1.setAge(35);
        emp1.setSalary(10000.56);

        emp1Address.setStreet("Park Avenue");
        emp1Address.setCity("Vijaywada");
        emp1Address.setState("Andhra Pradesh");
        emp1Address.setPincode(530012);

        emp1.setAddress(emp1Address);

        //Set Second Employee
        emp2.setFirstname("Amit");
        emp2.setLastname("Gupta");
        emp2.setGender("Male");
        emp2.setAge(30);
        emp2.setSalary(340000);

        emp2Address.setStreet("Plot 7");
        emp2Address.setCity("Vijaywada");
        emp2Address.setState("Andhra Pradesh");
        emp2Address.setPincode(530012);

        emp2.setAddress(emp1Address);

        //Set Third Employee
        emp3.setFirstname("Ashish");
        emp3.setLastname("Das");
        emp3.setGender("Male");
        emp3.setAge(39);
        emp3.setSalary(550000);

        emp3Address.setStreet("Plot 8");
        emp3Address.setCity("Dwarka");
        emp3Address.setState("New Delhi");
        emp3Address.setPincode(110066);

        emp3.setAddress(emp1Address);

        //Employee List
        List<EmployeePOJO> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        requestPayload.setEmployeeList(employeeList);

        //Convert Class Object to JSON Object as String
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(requestPayload);

        System.out.println(jsonPayload);

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://httpbin.org");
        requestSpec.basePath("/post");

        //Perform POST Request
        requestSpec.contentType(ContentType.JSON);
        Response response = requestSpec.body(jsonPayload).post();

        System.out.println("----------Response Body---------");
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }
}
