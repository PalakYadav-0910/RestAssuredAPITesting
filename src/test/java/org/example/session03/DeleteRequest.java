package org.example.session03;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteRequest {

    @Test(description = "DELETE Request - Delete User : BDD Style")
    public void testDeleteRequestBDDStyle(){

        RestAssured.baseURI = "https://reqres.in/api/users/334";
        RestAssured.given()
                .when().delete()
                .then().statusCode(204).log().all();

    }

}
