package org.example.session19;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OwnAPITesting {

    @BeforeClass
    public void setUp() {

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("http://localhost:3000");
        requestSpec.basePath("/users");

        RestAssured.requestSpecification = requestSpec;

    }

    @Test(priority = 1)
    public void readUserData() {

        //Perform Get Request
        Response response = RestAssured.get();

        //Print Response Body
        System.out.println("-----Response of GET Users-----\n");
        response.prettyPrint();

        //Validate Response Body
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }

    @Test(priority = 2)
    public void createUser(){

        //Create JSON Request Body
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Anil");
        jsonData.put("age", "45");

        //Perform POST Request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(jsonData.toJSONString()).post();

        //Print Response Body
        System.out.println("-----Response of Create User-----\n");
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");

    }

    @Test(priority = 3)
    public void updateUser(){

        //Create JSON Request Body
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Kavya");
        jsonData.put("age", "10");

        //Perform PUT Request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(jsonData.toJSONString())
                .put("/4896");

        //Print Response Body
        System.out.println("-----Response of Update User-----\n");
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }

    @Test(priority = 4)
    public void deleteUser(){

        //Perform Delete Request
        Response response = RestAssured.delete("/4896");

        //Print Response Body
        System.out.println("-----Response of Delete User-----\n");
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }

}
