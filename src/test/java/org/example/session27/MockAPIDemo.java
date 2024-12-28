package org.example.session27;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class MockAPIDemo {

    @Test
    public void test(){

        // https://run.mocky.io/v3/b4407df4-918e-486d-aaa3-cb97f940e258

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://run.mocky.io");
        requestSpec.basePath("/v3/b4407df4-918e-486d-aaa3-cb97f940e258");

        //Perform GET Request
        Response response = requestSpec.get();

        //Print Response Body
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");


    }

    @Test
    public void test2(){

        // https://run.mocky.io/v3/b4407df4-918e-486d-aaa3-cb97f940e258

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://run.mocky.io");
        requestSpec.basePath("/v3/b4407df4-918e-486d-aaa3-cb97f940e258");

        //Perform GET Request
        MockAPI_ResponsePOJO response = requestSpec.get().as(MockAPI_ResponsePOJO.class);

        System.out.println("---------JSON Object to Class Object----------");

        System.out.println("Firstname : " + response.getFirstname());
        System.out.println("Lastname : " + response.getLastname());
        System.out.println("Gender : " + response.getGender());
        System.out.println("Age : " + response.getAge());
        System.out.println("Salary : " + response.getSalary());
        System.out.println("isMarried : " + response.getMarried());
        System.out.println("Hobbies:");

        String [] hobbiesStr = response.getHobbies();

        for(int i=0; i<hobbiesStr.length;i++)
        {
            System.out.println(hobbiesStr[i]);
        }

        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String,String> entry : response.getFamilyMembers().entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }

}
