package org.example.session09;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BearerTokenAuthentication {

    @Test(description = "Bearer Token Authentication : POST Request - Create User")
    public void bearerTokenAuthentication(){

        //Create RequestSpecification
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in");
        requestSpecification.basePath("/public/v2/users");

        //Create JSON RequestBody or Payload
        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("name", "Palak");
        jsonPayload.put("gender", "Female");
        jsonPayload.put("email", "palak@gmail.com");
        jsonPayload.put("status", "Active");

        String bearerToken = "Bearer 0f1291e266928b7c2acbfbd13cdcfe37fda879ec5674741383dd4ea57cdf5a62";

        //Set Authorization in Headers
        requestSpecification.headers("Authorization", bearerToken)
                .contentType(ContentType.JSON)
                .body(jsonPayload.toJSONString());

        //Perform POST Request
        Response response = requestSpecification.post();

        Assert.assertEquals(response.getStatusCode(), 201, "Check for Status Code");

        //Print Status Line and Response Body
        System.out.println("Response Status : " + response.statusLine());
        System.out.println("Response Body : " + response.getBody().asString());

    }

}
