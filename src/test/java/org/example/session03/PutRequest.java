package org.example.session03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutRequest {

    @Test(description = "PUT Request - Update User : BDD Style")
    public void testPutRequestBDDStyle(){

        //Creating Request Body for Update
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Prachi");
        jsonObject.put("job", "Teacher");

        //given, when, then
        RestAssured.baseURI = "https://reqres.in/api/users/334";
        RestAssured.given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when().put()
                .then().statusCode(200).log().all();

    }
}
