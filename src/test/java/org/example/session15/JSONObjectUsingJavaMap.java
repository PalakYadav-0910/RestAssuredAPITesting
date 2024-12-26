package org.example.session15;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSONObjectUsingJavaMap {

    @Test
    public void createAuthToken(){

        //Create JSON Object using Java Map
        /*{
            "username" : "admin",
            "password" : "password123"
        }
       */

        Map<String, String> authToken = new HashMap<String, String>();
        authToken.put("username", "admin");
        authToken.put("password", "password123");

        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(authToken)
                .post();

        response.prettyPrint();

        //Verify Status Code
        Assert.assertEquals(response.statusCode(),200, "Check for Status Code");

    }


    @Test
    public void createUser(){

        /*{
                "firstname" : "Amod",
                "lastname" : "Mahajan",
                "age" : 28,
                "salary" : 10000.56,
                "isMarried" : true,
                "Hobbies" : ["Music", "Computer", "Games"],
            "Address" : [
            {
                 "AddressType" : "Home",
                 "City" : "Mumbai"
            },
            {
                  "AddressType" : "Office",
                  "City" : "Delhi"
            }
			 ],
            "TechSkill" :
                 {
                    "Programming Language" : "Java",
                    "WebAutomation" : "Selenium",
                    "API Testing" : "Rest Assured"
                 }
        }*/

        HashMap<String, Object> userData = new HashMap<String, Object>();
        userData.put("firstname", "Amod");
        userData.put("lastname", "Mahajan");
        userData.put("age", 28);
        userData.put("salary", 10000.56);
        userData.put("isMarried", true);

        ArrayList<String> hobbies = new ArrayList<String>();
        hobbies.add("Music");
        hobbies.add("Computer");
        hobbies.add("Games");

        userData.put("Hobbies", hobbies);

        HashMap<String, String> address1 = new HashMap<String, String>();
        address1.put("AddressType", "Home");
        address1.put("City", "Mumbai");

        HashMap<String, String> address2 = new HashMap<String, String>();
        address2.put("AddressType", "Office");
        address2.put("City", "Delhi");

        ArrayList<Object> addresses = new ArrayList<Object>();
        addresses.add(address1);
        addresses.add(address2);

        userData.put("Address", addresses);

        HashMap<String, String> techSkills = new HashMap<String, String>();
        techSkills.put("Programming Language", "Java");
        techSkills.put("WebAutomation", "Selenium");
        techSkills.put("API Testing", "Rest Assured");

        userData.put("TechSkill", techSkills);

        Response response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(userData)
                .post();

        response.prettyPrint();

        //Verify Status Code
        Assert.assertEquals(response.statusCode(),201 ,"Check for Status Code");

    }

}
