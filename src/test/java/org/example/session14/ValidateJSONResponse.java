package org.example.session14;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateJSONResponse {

    @Test
    public void addPet(){

        String jsonData = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        //https://petstore.swagger.io/v2/pet
        requestSpec.baseUri("https://petstore.swagger.io");
        requestSpec.basePath("/v2/pet");

        //Specify Headers
        requestSpec.header("accept", "application/json");
        requestSpec.header("Content-Type", "application/json");

        //Send Post Request
        Response response = requestSpec.body(jsonData)
                .post();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }
}
