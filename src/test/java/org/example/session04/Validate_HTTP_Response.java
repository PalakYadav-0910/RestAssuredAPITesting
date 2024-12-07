package org.example.session04;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validate_HTTP_Response {

    @Test(description = "Validate HTTP Response - Get Single User : Non BDD Style")
    public void validateResponseNonBDDStyle(){

        //Specify Base Url
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request Specification of Request
        RequestSpecification requestSpecification = RestAssured.given();

        //Call Get Method
        Response response = requestSpecification.get();

        //Get Response Status Code
        int statusCode = response.getStatusCode();

        //Validate Response Status Code
        Assert.assertEquals(statusCode, 200, "Incorrect Status Code");

        //Get Response Status Line
        String responseStatusLine = response.getStatusLine();

        //Validate Response Status Line
        Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK",
                "Incorrect Status Line");

    }

    @Test(description = "Validate HTTP Response using Validatable Response - Get Single User : Non BDD Style")
    public void validateResponseUsingValidatableResponseNonBDDStyle(){

        //Specify Base Url
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request Specification of Request
        RequestSpecification requestSpecification = RestAssured.given();

        //Call Get Method
        Response response = requestSpecification.get();

        ValidatableResponse validatableResponse = response.then();

        //Status Code
        validatableResponse.statusCode(200);

        //Status Line
        validatableResponse.statusLine("HTTP/1.1 200 OK");

    }

    @Test(description = "Validate HTTP Response - Get Single User : BDD Style")
    public void validateResponseBDDStyle(){

        //given, when, then
        RestAssured
                .given()
                       .baseUri("https://reqres.in/api/users/2")
                .when()
                       .get()
                .then()
                       .statusCode(200)
                       .statusLine("HTTP/1.1 200 OK")
                .log().all();

    }

}
