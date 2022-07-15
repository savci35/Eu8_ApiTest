package com.cydeo.day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SpartanGetRequests {

    String baseUrl = "http://3.90.66.60:8000";

    //  Given Accept type application/json
    // when user send GeT request to api/spartans end point
    //Then status code must 200
    //And response Content Type must be application/json
    //And response body should include spartans result


    @Test
    public void test1() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "/api/spartans");

        //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());  //response.statusCode() = 200

        // printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType()); //response.contentType() = application/json

        //print whole result body
        response.prettyPrint();


        // how to do API testing then?
        //verify status code 200
        Assertions.assertEquals(response.statusCode(), 200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(), "application/json");


    }


/*
  Given Accept type application/json
   when user send GeT request to api/spartans/3
   Then status code must 200
   And response Content Type must be application/json
   And response body should contain Fidole
    */

    @DisplayName("Get one spartan/api/spartans/3 and verify")
    @Test
    public void test2() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .given()
                .get(baseUrl + "/api/spartans/3");


        System.out.println("response.contentType() = " + response.contentType());


        System.out.println("response.statusCode() = " + response.statusCode());

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(), "application/json");

        //verify status code 200
        Assertions.assertEquals(response.statusCode(), 200);


        Assertions.assertTrue(response.body().asString().contains("Fidole"));

        response.prettyPrint();
    }



/*
  Given no headers provided
   when user sends GeT request to api/hello
   Then status code should be 200
   And Content type header should be "text/plain;charset=UTF-8"
   And header should contain date
   And Content-Length should be 17
   And body should be "Hello from Sparta"
    */

    @DisplayName("Get request to /api/hello")
    @Test
    public void test3() {
        //send request and save response inside the response object
        Response response = RestAssured.when().get(baseUrl + "/api/hello");


        //verify status code 200
        Assertions.assertEquals(200, response.statusCode());

        //verify content type
        Assertions.assertEquals("text/plain;charset=UTF-8", response.contentType());

        //verify we have headers named date
        //we use hasHeaderWithname to verify header exist or not
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        //how to get and header from response using header key?
        //we use the response.header(String headerName) method to get any header value
        System.out.println("response.headers(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println("response.header(\"Date\") = " + response.header("Date"));


         // verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));

        Assertions.assertEquals("Hello from Sparta",response.body().asString());
    }







}
