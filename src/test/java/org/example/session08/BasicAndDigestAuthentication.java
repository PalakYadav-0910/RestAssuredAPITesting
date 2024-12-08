package org.example.session08;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAndDigestAuthentication {

    @Test(description = "Non-Pre-emptive Basic Authorization - Default Authorization : GET Request")
    public void basicAuthNonPreEmptiveDefaultAuth(){

        RequestSpecification requestSpecification = RestAssured.given();

        //Specify URL
        requestSpecification.baseUri("https://postman-echo.com");
        requestSpecification.basePath("/basic-auth");

        //Send GET Request
        Response response = requestSpecification.auth()
                            .basic("postman", "password")
                            .get();

        //Print Status Line and Response Body
        System.out.println("Response Status : " + response.statusLine());
        System.out.println("Response Body : " + response.getBody().asString());

    }

    @Test(description = "Pre-emptive Basic Authorization : GET Request")
    public void basicAuthPreEmptive(){

        RequestSpecification requestSpecification = RestAssured.given();

        //Specify URL
        requestSpecification.baseUri("https://postman-echo.com");
        requestSpecification.basePath("/basic-auth");

        //Send GET Request - Using preemptive
        Response response = requestSpecification.auth().preemptive()
                .basic("postman", "password")
                .get();

        //Print Status Line and Response Body
        System.out.println("Response Status : " + response.statusLine());
        System.out.println("Response Body : " + response.getBody().asString());

    }

    @Test(description = "Digest Authentication : GET Request")
    public void digestAuth(){

        RequestSpecification requestSpecification = RestAssured.given();

        //Specify URL
        requestSpecification.baseUri("https://httpbin.org");
        requestSpecification.basePath("/digest-auth/undefined/prachi/prachi");

        //Send GET Request - Using preemptive
        Response response = requestSpecification.auth()
                .digest("prachi", "prachi")
                .get();

        Assert.assertEquals(response.getStatusCode(), 200, "Check for Status Code");

        //Print Status Line and Response Body
        System.out.println("Response Status : " + response.statusLine());
        System.out.println("Response Body : " + response.getBody().asString());

    }

}