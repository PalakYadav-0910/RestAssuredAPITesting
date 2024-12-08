package org.example.session06;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValidateJSONResponseBody {

    @Test(description = "Validate JSON Response Body - GET Request - List Users")
    public void validateJSONResponseBody(){

        //Create Request Specification
        RequestSpecification requestSpecification = RestAssured.given();

        //Specify Base Uri and Base Path
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users?page=2");

        //Create GET Request and get Response
        Response response = requestSpecification.get();

        //Read Response Body
        ResponseBody responseBody = response.getBody();

        String responseBodyString = responseBody.asString();
        System.out.println("Response Body : " + responseBodyString);

        //Check for presence of George in Response Body
        Assert.assertEquals(responseBodyString.contains("George"), true,
                "Check for presence of George");

        //Get JSON Path View of Response Body
        JsonPath jsonPathView = responseBody.jsonPath();

        String firstname = jsonPathView.get("data[0].first_name");

        Assert.assertEquals(firstname, "George", "Check for presence of firstname as George");

        //Print the value of some other node
        System.out.println("Email Address of Janet : " + jsonPathView.get("data[1].email"));
    }
}
