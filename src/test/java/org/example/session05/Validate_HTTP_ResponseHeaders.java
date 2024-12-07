package org.example.session05;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validate_HTTP_ResponseHeaders {

    @Test(description = "Validate HTTP Response Headers : Non BDD Style")
    public void validateResponseHeaders(){

        //Get RequestSpecification
        RequestSpecification requestSpecification = RestAssured.given();

        //Specify Base Uri and Base Path
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users/2");

        //Create GET Request
        Response response = requestSpecification.get();

        //Get Single Response Header based on Attribute name
        String contentType = response.getHeader("Content-Type");
        System.out.println("Value of Content-Type attribute of Response Header : " + contentType);

        //Get All Response Headers and print keys and values
        Headers headersList = response.getHeaders();
        System.out.println("Response Headers are :");

        //Iterate over Headers List using advanced For Loop
        for(Header header: headersList){
            System.out.println(header.getName() + " : " + header.getValue());
        }

        //Validate Header : Content-Type
        Assert.assertEquals(contentType, "application/json; charset=utf-8",
                "Header: Content-Type Value Mismatch");

    }
}
