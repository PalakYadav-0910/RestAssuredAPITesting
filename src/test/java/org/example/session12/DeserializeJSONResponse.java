package org.example.session12;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializeJSONResponse {

    @Test
    public void createUser(){

        //https://reqres.in/api/users

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //Create Request Body
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Prachi");
        jsonData.put("job", "QA");

        //Perform POST Request
        Response response = requestSpec.contentType(ContentType.JSON)
                .body(jsonData.toJSONString())
                .post();

        ResponseBody responseBody = response.getBody();

        //DeSerialize Response Body i.e json Response Body to Class Object

        //Class <T> is a generic form of any class of Type T which is also referred to as Template Class.

        JSONPostRequest_Response responseClass = responseBody.as(JSONPostRequest_Response.class);

        Assert.assertEquals(responseClass.getName(), "Prachi", "Check for name");
        Assert.assertEquals(responseClass.getJob(), "QA", "Check for job");

    }
}
