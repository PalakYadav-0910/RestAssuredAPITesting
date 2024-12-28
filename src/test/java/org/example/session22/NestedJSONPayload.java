package org.example.session22;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedJSONPayload {

    @Test
    public void createUser() throws JsonProcessingException {

        /*
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
}
        */

        EmployeePOJO employeePOJO = new EmployeePOJO();
        employeePOJO.setFirstname("Suresh");
        employeePOJO.setLastname("Mehra");
        employeePOJO.setGender("Male");
        employeePOJO.setAge(35);
        employeePOJO.setSalary(10000.56);

        EmployeeAddress empAddress = new EmployeeAddress();
        empAddress.setStreet("Park Avenue");
        empAddress.setCity("Vijaywada");
        empAddress.setState("Andhra Pradesh");
        empAddress.setPincode(530012);

        employeePOJO.setAddress(empAddress);

        //Convert Class Object to JSON Object as String
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(employeePOJO);

        System.out.println("JSONPayload : " + jsonPayload);

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://httpbin.org");
        requestSpec.basePath("/post");
        requestSpec.contentType(ContentType.JSON);

        //Perform POST Request
        Response response = requestSpec.post();
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }
}