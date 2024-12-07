package org.example.session02;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGetRequest {

    @Test(description = "Get Request")
    public void testcase01(){

        Response res = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(res.asString());
        System.out.println("Status Code : " + res.getStatusCode());

    }
}
