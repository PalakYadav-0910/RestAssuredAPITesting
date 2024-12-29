package org.example.session29;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoResponseSpec {

    ResponseSpecification responseSpec = null;

    @BeforeClass
    public void createResponseSpec(){

        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectStatusCode(200);
        responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
        responseBuilder.expectContentType(ContentType.JSON);
        responseBuilder.expectResponseTime(Matchers.lessThan(3000L));

        responseSpec = responseBuilder.build();

    }

    @Test
    public void getAllBookingIds(){

        RestAssured
                .given()
                   .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                   .get()
                .then()
                   .body("size()", Matchers.greaterThan(0)) //For Booking Id Count
                   /*.statusCode(200)
                   .statusLine("HTTP/1.1 200 OK")
                   .contentType(ContentType.JSON)
                   .time(Matchers.lessThan(3000L));*/
                   .spec(responseSpec);

    }

    @Test
    public void getBookingByFirstName(){

        RestAssured
                .given()
                  .baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
                .when()
                  .get()
                .then()
                  /*.statusCode(200)
                  .statusLine("HTTP/1.1 200 OK")
                  .contentType(ContentType.JSON)
                  .time(Matchers.lessThan(3000L));*/
                  .spec(responseSpec);

    }

}