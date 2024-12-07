package org.example.session03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PatchRequest {

    @Test(description = "PATCH Request - For Partial Update : BDD Style")
    public void testPatchRequestBDDStyle(){

        //Create Request Body for Partial Update
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("job", "Tester");

        //given, when, then
        RestAssured.baseURI = "https://reqres.in/api/users/334";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when().patch()
                .then().statusCode(200).log().all();

    }
}
