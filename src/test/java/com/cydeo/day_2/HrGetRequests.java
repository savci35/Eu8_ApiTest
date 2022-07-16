package com.cydeo.day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init() {

        // save baseUrl inside this variable so that we don't need to type each http method
        RestAssured.baseURI = "http://3.90.66.60:1000/ords/hr";

    }

    @DisplayName("Get request to /regions")
    @Test
    public void test1() {

        Response response = RestAssured.get("/regions");


        System.out.println("response.statusCode() = " + response.statusCode());


    }
    /*
    Given accept type is application/json
    When user sends get request to /regions/2
    Then response status code must be 200
    and content type equals to application/json
    and response body contains Americas
      */

    @DisplayName("Get request to /regions/2")
    @Test
    public void test2() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().
                         get("/regions/2");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        //verify status code
        Assertions.assertEquals(200, response.statusCode());

        //verify content type
        Assertions.assertEquals("application/json", response.contentType());

        response.prettyPrint();

        //verify body contains Amerricas
      //  Assertions.assertTrue(response.body().asString().contains("Americas")); //aşağı ile aynı
        Assertions.assertEquals(response.body().asString().contains("Americas"),true);

    }
}
