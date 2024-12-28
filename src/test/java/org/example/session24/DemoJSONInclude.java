package org.example.session24;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoJSONInclude {

    @Test
    public void createUser() throws JsonProcessingException {

        //Create User
        EmployeePOJO employeePOJO = new EmployeePOJO();
        employeePOJO.setFirstname("Suresh");
        //employeePOJO.setLastname("Mehra");----Default value of String is null
        employeePOJO.setGender("Male");
        //employeePOJO.setAge(35);----Default value of Integer is 0
        employeePOJO.setSalary(10000.56);
        //employeePOJO.setMarried(true);----Default value of Boolean is false

        //Empty Array
        //String[] hobbies = {};

        String[] hobbies = new String[2];
        hobbies[0] = "Reading";
        hobbies[1] = "Music";

        //Set Empty array
        employeePOJO.setHobbies(hobbies);

        //Empty List
        List<String> degrees = new ArrayList<>();
        degrees.add("BCA");
        degrees.add("MCA");

        //Set Empty List
        employeePOJO.setDegrees(degrees);

        //Empty Map
        HashMap<String, String> familyMembers = new HashMap<>();
        familyMembers.put("1", "Mother");
        familyMembers.put("2", "Father");

        //Set Empty Map
        employeePOJO.setFamilyMembers(familyMembers);

        //Convert Employee Class Object to JSON Payload as String
        ObjectMapper objectMapper = new ObjectMapper();

        String employeeJSON = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(employeePOJO);

        System.out.println(employeeJSON);

    }
}
