package org.example.session26;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.session20.Employee;
import org.testng.annotations.Test;

public class DemoIgnoreUnknownProperties {

    @Test
    public void createUser() throws JsonProcessingException {

        //Properties which are not present in POJO Class are known as Unknown Properties.

        String payload = "{\n" +
                "  \"firstname\" : \"Suresh\",\n" +
                "  \"lastname\" : \"Mehra\",\n" +
                "  \"gender\" : \"Male\",\n" +
                "  \"age\" : 35,\n" +
                "  \"salary\" : 10000.56,\n" +
                "  \"isMarried\" : true,\n" +
                "  \"fullname\" : \"Suresh Mehra\"\n" +  //fullname -> Unknown Property
                "}";

        //First Method to ignore Unknown Properties is @JsonIgnoreProperties(ignoreUnknown = true) annotation.
        //Second method to ignore Unknown Properties is using Object Mapper when we dont have access to POJO Class.

        ObjectMapper objectMapper = new ObjectMapper();

        //Ignore Unknown Property - fullname
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //Convert JSON String (employeeJSON) to Class Object (Employee)
        EmployeePOJO emp = objectMapper.readValue(payload, EmployeePOJO.class);

        System.out.println("---------JSON Object to Class Object----------");

        System.out.println("Firstname : " + emp.getFirstname());
        System.out.println("Lastname : " + emp.getLastname());
        System.out.println("Gender : " + emp.getGender());
        System.out.println("Age : " + emp.getAge());
        System.out.println("Salary : " + emp.getSalary());
        System.out.println("isMarried : " + emp.getMarried());

    }

}
