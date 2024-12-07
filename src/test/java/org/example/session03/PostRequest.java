package org.example.session03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest {

    @Test(description = "POST Request - Create User : BDD Style")
    public void testPostRequestBDDStyle(){

        //Creating JSON Request Body using json-simple dependency
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Palak");
        jsonData.put("job", "QA");

        //given, when, then
        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonData.toJSONString())
                .when().post()
                .then().statusCode(201).log().all();

    }
}
