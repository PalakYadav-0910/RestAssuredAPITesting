package org.example.session20;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerializationAndDeSerialization {

    @Test
    public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {

        Employee emp1 = new Employee();
        emp1.setFirstname("Prachi");
        emp1.setLastname("Gupta");
        emp1.setGender("female");
        emp1.setAge(25);
        emp1.setSalary(10000);

        //Convert Employee Class Object to JSON Payload as String
        ObjectMapper objectMapper = new ObjectMapper();

        String employeeJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

        System.out.println("---------Class Object to JSON Object----------");
        System.out.println(employeeJSON);

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://httpbin.org/post");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(employeeJSON);

        //Perform POST Request
        Response response = requestSpec.post();

        //Print Response
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

        //Convert JSON String (employeeJSON) to Class Object (Employee)
        Employee emp2 = objectMapper.readValue(employeeJSON, Employee.class);

        System.out.println("---------JSON Object to Class Object----------");

        System.out.println("Firstname : " + emp2.getFirstname());
        System.out.println("Lastname : " + emp2.getLastname());
        System.out.println("Gender : " + emp2.getGender());
        System.out.println("Age : " + emp2.getAge());
        System.out.println("Salary : " + emp2.getSalary());

    }
}
