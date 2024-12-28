package org.example.session25;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class DemoJSONIgnore {

    @Test
    public void createUser() throws JsonProcessingException {

        EmployeePOJO employeePOJO = new EmployeePOJO();
        employeePOJO.setFirstname("Suresh");
        employeePOJO.setLastname("Mehra");
        employeePOJO.setGender("Male");
        employeePOJO.setAge(35);
        employeePOJO.setSalary(10000.56);
        employeePOJO.setMarried(true);
        employeePOJO.setFullname("Suresh Mehra");

        //Serialization : Convert Employee Class Object to JSON Payload as String
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(employeePOJO);

        System.out.println("---------Class Object to JSON Object----------");

        System.out.println(jsonPayload);

        //DeSerialisation : Convert JSON Payload String to Employee Class Object
        String payload = "{\n" +
                "  \"firstname\" : \"Suresh\",\n" +
                "  \"lastname\" : \"Mehra\",\n" +
                "  \"gender\" : \"Male\",\n" +
                "  \"age\" : 35,\n" +
                "  \"salary\" : 10000.56,\n" +
                "  \"fullname\" : \"Suresh Mehra\",\n" +
                "  \"married\" : true\n" +
                "}";

        EmployeePOJO emp = objectMapper.readValue(payload, EmployeePOJO.class);

        System.out.println("---------JSON Object to Class Object----------");

        System.out.println("Firstname : " + emp.getFirstname());
        System.out.println("Lastname : " + emp.getLastname());
        System.out.println("Gender : " + emp.getGender());
        System.out.println("Age : " + emp.getAge());
        System.out.println("Salary : " + emp.getSalary());
        System.out.println("Married : " + emp.getMarried());
        System.out.println("FullName : " + emp.getFullname());

    }
}
