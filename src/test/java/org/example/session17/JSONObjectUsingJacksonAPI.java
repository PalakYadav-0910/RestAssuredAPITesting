package org.example.session17;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class JSONObjectUsingJacksonAPI {

    @Test
    public void createUser() {

        /*{
                "firstname" : "Amod",
                "lastname" : "Mahajan",
                "age" : 28,
                "salary" : 10000.56,
                "isMarried" : true,
                "Hobbies" : ["Music", "Computer", "Games"],
                "TechSkill" : {
                    "Programming Language" : "Java",
                    "WebAutomation" : "Selenium",
                    "API Testing" : "Rest Assured"
        }
        }*/

        //Create Object Mapper Class Interface
        ObjectMapper objectMapper = new ObjectMapper();

        //Create Object Node i.e JSON Node
        ObjectNode userDetails = objectMapper.createObjectNode();

        userDetails.put("firstname", "Amod");
        userDetails.put("lastname", "Mahajan");
        userDetails.put("age", 28);
        userDetails.put("salary", 10000.56);
        userDetails.put("isMarried", true);

        //Adding Array List in JSON Object
        userDetails.set("Hobbies", objectMapper.convertValue(Arrays.asList("Music", "Computer", "Games"), JsonNode.class));

        //Create Object Node for TechSkill
        ObjectNode techSkill = objectMapper.createObjectNode();

        techSkill.put("Programming Language", "Java");
        techSkill.put("WebAutomation", "Selenium");
        techSkill.put("API Testing", "Rest Assured");

        userDetails.put("TechSkill", techSkill);

        //Print userDetails JSON Object

        try {
            String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(userDetails);
            System.out.println("Created JSON Object is : " + userDetailsAsString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Retrieve field values
        String firstName = userDetails.get("firstname").asText();
        System.out.println("Value of firstname field is : " + firstName);

        Boolean isMarried = userDetails.get("isMarried").asBoolean();
        System.out.println("Value of Is Married field is : " + isMarried);

        //Retrieved field Value of WebAutomation
        String webAutomation = userDetails.get("TechSkill").get("WebAutomation").asText();
        System.out.println("Value of Web Automation field is : " + webAutomation);

        //Print all field names
        System.out.println("-----------Print all fields names-----------\n");

        Iterator<String> fieldNamesIterator = userDetails.fieldNames();

        while (fieldNamesIterator.hasNext()) {
            System.out.println(fieldNamesIterator.next());
        }

        //Print all field values
        System.out.println("-----------Print all fields values-----------\n");

        Iterator<JsonNode> fieldValuesIterator = userDetails.elements();

        while (fieldValuesIterator.hasNext()) {
            System.out.println(fieldValuesIterator.next());
        }

        //Print all field names and values both
        System.out.println("-----------Print all field names and values both (Key, Value)-----------\n");

        Iterator<Map.Entry<String, JsonNode>> keyValueEntries = userDetails.fields();

        while (keyValueEntries.hasNext()) {
            Map.Entry<String, JsonNode> node = keyValueEntries.next();
            System.out.println("Key : " + node.getKey() + " , " + "Value : " + node.getValue());
        }

        //Remove field from JSON Object or Object Node
        String removedValue = userDetails.remove("salary").asText();
        System.out.println("Value of Removed JSON Node is : " + removedValue);

        //Print userDetails JSON Object after Remove

        try {
            String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(userDetails);
            System.out.println("JSON Object after Remove Method : " + userDetailsAsString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Update JSON Object or JSON Node
        userDetails.put("lastname", "Sharma");

        //Update nested JSON Object - Using Set Method
        techSkill.put("Programming Language", "C#");
        userDetails.set("TechSkill", techSkill);

        //Print userDetails JSON Object after Update

        try {
            String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(userDetails);
            System.out.println("JSON Object after Update Method : " + userDetailsAsString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //Perform Post Request
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(userDetails);

        Response response = requestSpec.post();

        System.out.println("---------Print HTTP Response Body-----------");
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 201, "Check for Status Code");

    }
}
