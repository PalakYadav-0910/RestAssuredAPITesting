package org.example.session16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONArrayDemo {

    @Test(enabled = false)
    public void createUserUsingJSONArray(){

        //Create JSON Objects for users using JSONObject
        /*{
                "firstname" : "Prachi",
                "lastname" : "Gupta",
                "age" : 28,
                "salary" : 10000.56
        }*/

        JSONObject userObject1 = new JSONObject();
        userObject1.put("firstname", "Prachi");
        userObject1.put("lastname", "Gupta");
        userObject1.put("age", 28);
        userObject1.put("salary", 10000.56);

        JSONObject userObject2 = new JSONObject();
        userObject2.put("firstname", "Prerna");
        userObject2.put("lastname", "Singh");
        userObject2.put("age", 29);
        userObject2.put("salary", 20000.12);

        JSONObject userObject3 = new JSONObject();
        userObject3.put("firstname", "Abhishek");
        userObject3.put("lastname", "Kumar");
        userObject3.put("age", 30);
        userObject3.put("salary", 30000.34);

        //Create JSON Array using JSONArray

        JSONArray usersPayload = new JSONArray();
        usersPayload.add(userObject1);
        usersPayload.add(userObject2);
        usersPayload.add(userObject3);

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //Perform Post Request
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(usersPayload);

        Response response = requestSpec.post();

        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");

    }


    @Test
    public void createJSONArrayUsingList(){

        //Create JSON Objects for users using HashMap
        /*{
                "firstname" : "Prachi",
                "lastname" : "Gupta",
                "age" : 28,
                "salary" : 10000.56
        }*/

        Map<String, Object> userObject1 = new HashMap<String, Object>();
        userObject1.put("firstname", "Prachi");
        userObject1.put("lastname", "Gupta");
        userObject1.put("age", 28);
        userObject1.put("salary", 10000.56);

        Map<String, Object> userObject2 = new HashMap<String, Object>();
        userObject2.put("firstname", "Prerna");
        userObject2.put("lastname", "Singh");
        userObject2.put("age", 29);
        userObject2.put("salary", 20000.12);

        Map<String, Object> userObject3 = new HashMap<String, Object>();
        userObject3.put("firstname", "Abhishek");
        userObject3.put("lastname", "Kumar");
        userObject3.put("age", 30);
        userObject3.put("salary", 30000.34);

        //Create JSON Array using List

        List<Map<String, Object>> jsonArrayList = new ArrayList<>();
        jsonArrayList.add(userObject1);
        jsonArrayList.add(userObject2);
        jsonArrayList.add(userObject3);

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //Perform Post Request
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonArrayList);

        Response response = requestSpec.post();

        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");

    }

}
