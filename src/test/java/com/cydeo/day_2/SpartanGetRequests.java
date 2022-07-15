package com.cydeo.day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SpartanGetRequests {

    String baseUrl ="http://3.90.66.60:8000";

  //  Given Accept type application/json
   // when user send GeT request to api/spartans end point
    //Then status code must 200
    // response Content Type must be application/json
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
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");


    }
}
