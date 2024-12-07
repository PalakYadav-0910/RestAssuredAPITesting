package org.example.session03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.client.RedirectStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest {

    @Test(description = "GET Request - List Users")
    public void testGetRequest(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response Code : " + response.getStatusCode());
        System.out.println("Response Body : " + response.getBody().asPrettyString());
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Response Headers : " + response.getHeaders());
        System.out.println("Response Header Content Type : " + response.getHeader("Content-Type"));

        //Validate Status Code
        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

    }

    @Test(description = "Get Request - List Users : BDD Style")
    public void testGetRequestBDDStyle(){

        //given, when, then
        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.given().queryParam("page", "2")
                .when().get().then().statusCode(200).log().all();

    }
}
