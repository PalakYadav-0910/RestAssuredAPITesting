package org.example.session30;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class JSONSchemaValidation {

    @Test
    public void testMethod(){

        String requestPayload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                   .baseUri("https://restful-booker.herokuapp.com/auth")
                   .contentType(ContentType.JSON)
                   .body(requestPayload)
                .when()
                   .post()
                .then()
                   .assertThat()
                   .body("token", Matchers.notNullValue())
                   .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\palayadav\\OneDrive - HARMAN\\Documents\\Learning\\API Testing\\schema.json")))
                   .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

    }
}
