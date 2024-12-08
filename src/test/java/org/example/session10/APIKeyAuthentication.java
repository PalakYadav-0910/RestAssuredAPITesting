package org.example.session10;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIKeyAuthentication {

    @Test(description = "API Key Authentication : GET Request")
    public void apiKeyAuthentication(){

        //Website Url - https://openweathermap.org/current
        //Request Url - https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://api.openweathermap.org");
        requestSpec.basePath("/data/2.5/weather");
        requestSpec.queryParam("q", "delhi")
                   .queryParam("appid", "ed9997485c5aebf644a45kef046becfceb6e6");

        Response response = requestSpec.get();

        Assert.assertEquals(response.getStatusCode(), 200, "Check for Status Code");

        //Print Status Line and Response Body
        System.out.println("Response Status : " + response.statusLine());
        System.out.println("Response Body : " + response.getBody().asString());

    }

}
