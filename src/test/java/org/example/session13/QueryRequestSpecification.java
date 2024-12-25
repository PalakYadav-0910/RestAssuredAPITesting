package org.example.session13;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestSpecification {

    @Test
    public void createUser(){

        //Create Request Body
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Prachi");
        jsonData.put("job", "QA");

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify URL
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonData.toJSONString());
        requestSpec.header("Header1", "Header1Value");

        //Retrieve RequestSpecification
        QueryableRequestSpecification queryableRequestSpec = SpecificationQuerier
                                                             .query(requestSpec);

        //Get Base URI
        String baseUri = queryableRequestSpec.getBaseUri();
        System.out.println("Base URI : " + baseUri);

        //Get Base Path
        String basePath = queryableRequestSpec.getBasePath();
        System.out.println("Base Path : " + basePath);

        //Get Request Body
        String requestBody = queryableRequestSpec.getBody();
        System.out.println("Request Body : " + requestBody);

        //Get Request Headers
        Headers allHeaders = queryableRequestSpec.getHeaders();
        System.out.println("--------------Request Headers--------------");

        for(Header header : allHeaders){
            System.out.println("Header Name : " + header.getName() + "\t" + "Header Value : " + header.getValue());
        }

    }
}
