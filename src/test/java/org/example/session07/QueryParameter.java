package org.example.session07;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueryParameter {

    @Test(description = "Query Parameters - GET Request : List Users")
    public void queryParameter(){

        //Get RequestSpecification for given request
        RequestSpecification requestSpecification = RestAssured.given();

        //Specify Url
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        requestSpecification.queryParam("page", 2)
                            .queryParam("id", 10);

        //Perform GET Request
        Response response = requestSpecification.get();

        ResponseBody responseBody = response.getBody();
        String responseBodyString = responseBody.asString();
        System.out.println("Response Body : " + responseBodyString);

        //Verify if in Response firstname is Byron
        JsonPath jsonPathView = response.jsonPath();
        String firstname = jsonPathView.get("data.first_name");
        System.out.println("FirstName : " + firstname);
        Assert.assertEquals(firstname, "Byron", "Check for firstname");

    }
}
