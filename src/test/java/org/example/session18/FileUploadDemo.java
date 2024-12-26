package org.example.session18;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadDemo {

    @Test
    public void uploadFile(){

        //Create File Object
        File testFileUpload = new File("C:\\Users\\palayadav\\OneDrive - HARMAN\\Documents\\Learning\\API Testing\\testFileUpload.txt");
        File testFileUpload2 = new File("C:\\Users\\palayadav\\OneDrive - HARMAN\\Documents\\Learning\\API Testing\\testFileUpload2.txt");

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://httpbin.org");
        requestSpec.basePath("/post");

        requestSpec.multiPart("files", testFileUpload);
        requestSpec.multiPart("files", testFileUpload2);

        requestSpec.contentType("multipart/form-data");

        //Perform POST Operation
        Response response = requestSpec.post();

        //Print Response Body
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }

    @Test
    public void uploadImage(){

        //https://petstore.swagger.io/v2/pet/1/uploadImage

        //Create File Object
        File testFileUpload = new File("C:\\Users\\palayadav\\Downloads\\swagger.jpeg");

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify Url
        requestSpec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");

        requestSpec.multiPart("files", testFileUpload);
        requestSpec.header("accept", "application/json");

        requestSpec.contentType("multipart/form-data");

        //Perform POST Operation
        Response response = requestSpec.post();

        //Print Response Body
        response.prettyPrint();

        //Validate Status Code
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code");

    }

}
