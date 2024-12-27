package org.example.session21;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONArrayPOJOClassDemo {

    @Test
    public void createEmployeesJSONArray() throws JsonProcessingException {
        //create first employeeObject
        Employee emp1 = new Employee();

        emp1.setFirstName("Suresh");
        emp1.setLastname("Mehra");
        emp1.setGender("Male");
        emp1.setAge(35);
        emp1.setSalary(10000.56);


        //create second employeeObject
        Employee emp2 = new Employee();

        emp2.setFirstName("Ram");
        emp2.setLastname("Singh");
        emp2.setGender("Male");
        emp2.setAge(30);
        emp2.setSalary(34000.56);

        //create third employeeObject
        Employee emp3 = new Employee();

        emp3.setFirstName("Sita");
        emp3.setLastname("Gupta");
        emp3.setGender("Female");
        emp3.setAge(28);
        emp3.setSalary(39000.56);

        //Create List Of Employee
        List<Employee> listOfEmp = new ArrayList<Employee>();
        listOfEmp.add(emp1);
        listOfEmp.add(emp2);
        listOfEmp.add(emp3);

        //Convert Employee Class Objects to JSON Array Payload as String
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonArrayPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);

        System.out.println("-----Employee Class Objects to JSON Array Payload as String-----");
        System.out.println(jsonArrayPayload);

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify URL
        requestSpec.baseUri("https://reqres.in/api/users");

        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonArrayPayload);

        //Perform POST Request
        Response response = requestSpec.post();
        System.out.println("-------Response Body-------");
        response.prettyPrint();

        //Verify Status Code
        Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");

        //convert JsonArray to Employee class objects (Deserialization)

        ResponseBody responseBody = response.getBody();

        JsonPath jsonPathView = responseBody.jsonPath();

        List<Employee> allEmployees = jsonPathView.getList("json", Employee.class);

        System.out.println("----------Emoployee objects in ResponseBody----------------");

        for(Employee emp:allEmployees)
        {
            System.out.println(emp.getFirstName()+ " " + emp.getLastname());
        }

    }
}
