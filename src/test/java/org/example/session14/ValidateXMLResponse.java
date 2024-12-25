package org.example.session14;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import java.util.List;

public class ValidateXMLResponse {

    @Test
    public void addPet(){

        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Pet>\n" +
                "\t<id>0</id>\n" +
                "\t<Category>\n" +
                "\t\t<id>0</id>\n" +
                "\t\t<name>string</name>\n" +
                "\t</Category>\n" +
                "\t<name>doggie</name>\n" +
                "\t<photoUrls>\n" +
                "\t\t<photoUrl>string</photoUrl>\n" +
                "\t</photoUrls>\n" +
                "\t<tags>\n" +
                "\t\t<Tag>\n" +
                "\t\t\t<id>0</id>\n" +
                "\t\t\t<name>string</name>\n" +
                "\t\t</Tag>\n" +
                "\t</tags>\n" +
                "\t<status>available</status>\n" +
                "</Pet>";

        //Create RequestSpecification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify URL
        //https://petstore.swagger.io/v2/pet
        requestSpec.baseUri("https://petstore.swagger.io");
        requestSpec.basePath("/v2/pet");

        //Specify Headers
        requestSpec.header("accept", "application/xml");
        requestSpec.header("Content-Type", "application/xml");

        //Perform POST Request
        Response response = requestSpec.body(xmlData)
                .post();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

        //Using Hamcrest Framework Matchers Class for assertion
        response.then().body("Pet.name", Matchers.equalTo("doggie"));

    }

    @Test
    public void getTravellersData(){

        //create request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //http://restapi.adequateshop.com/api/Traveler?page=1
        //specify url
        requestSpec.baseUri("http://restapi.adequateshop.com");
        requestSpec.basePath("/api/Traveler");

        //add query parameter
        requestSpec.queryParam("page", "1");

        //specify header
        requestSpec.header("accept","application/xml");

        //perform get request
        Response response = requestSpec.get();

        response.prettyPrint();


        //Approach 1
        //	response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name", Matchers.equalTo("vano"));


        //Approach 2
        XmlPath objXmlPath = new XmlPath(response.asString());

        String travellerName = objXmlPath.get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        Assert.assertEquals(travellerName, "Developer", "check for traveller name.");

        //Verify total travelers to be 10

        List<String> listOfTravellers = objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");

        int totalTravelerCount = listOfTravellers.size();

        Assert.assertEquals(totalTravelerCount, 10,"check for total no. of traveller on page-1");


        //verify for name vano in travellers list
        List<String> listOfTravellersName = objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

        //print all the names in the travellers list

        boolean found = false;
        for (String traveller :listOfTravellersName )
        {
            System.out.println(traveller);

            if(traveller.equals("vano"))
            {
                found = true;
                break;
            }

        }

        Assert.assertEquals(found, true);

    }

}
