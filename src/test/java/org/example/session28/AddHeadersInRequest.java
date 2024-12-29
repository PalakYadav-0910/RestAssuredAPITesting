package org.example.session28;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddHeadersInRequest {

    @Test
    public void testMethod1(){

        RequestSpecification requestSpec = RestAssured.given();

        //First - Add Headers as Map
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Header1", "Value1");
        headersMap.put("Header2", "Value2");
        //requestSpec.headers(headersMap);

        //Second - Add Header using Headers Class
        //Header header = new Header("Header3", "Value4");
        //requestSpec.header(header);

        //Third - Add Header as key-value
        //requestSpec.header("Header4", "Value4");

        //Fourth - Add Multiple Headers using Headers Class
        Header header1 = new Header("Header1", "Value1");
        Header header2 = new Header("Header2", "Value2");
        Header header3 = new Header("Header3", "Value3");
        Header header4 = new Header("Header4", "Value4");

        //Create List of Headers
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(header1);
        headerList.add(header2);
        headerList.add(header3);
        headerList.add(header4);

        Headers headers = new Headers(headerList);
        requestSpec.headers(headers);

        requestSpec.log().headers();

        //Specify Url
        requestSpec.baseUri("https://reqres.in/api/users?page=1");

        //Perform get Request
        Response response = requestSpec.get();
        response.prettyPrint();

        //Validate Response Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

        //BDD Style (Given, When, Then)
        RestAssured
                .given()
                   .headers(headers)
                   .log().headers()
                .when()
                   .get("https://reqres.in/api/users?page=1")
                .then()
                   .log().body()
                   .statusCode(200);

    }
}
