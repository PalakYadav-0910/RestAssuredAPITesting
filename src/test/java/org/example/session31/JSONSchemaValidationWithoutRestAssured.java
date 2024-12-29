package org.example.session31;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;

public class JSONSchemaValidationWithoutRestAssured {

    @Test
    public void test(){

        /*
          <!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest -->
          <dependency>
          <groupId>org.hamcrest</groupId>
          <artifactId>hamcrest</artifactId>
          <version>3.0</version>
          <scope>test</scope>
          </dependency>

          <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
          <dependency>
          <groupId>io.rest-assured</groupId>
          <artifactId>json-schema-validator</artifactId>
          <version>5.5.0</version>
          </dependency>
        */

        String jsonObject = "{\n" +
                "\t\"id\": 2,\n" +
                "    \"email\": \"janet.weaver@reqres.in\",\n" +
                "    \"first_name\": \"Janet\",\n" +
                "    \"last_name\": \"Weaver\"\n" +
                "}";

        MatcherAssert.assertThat(jsonObject, JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\palayadav\\OneDrive - HARMAN\\Documents\\Learning\\API Testing\\schema2.json")));

        MatcherAssert.assertThat(jsonObject, JsonSchemaValidator.matchesJsonSchemaInClasspath("schema2.json"));

    }
}

