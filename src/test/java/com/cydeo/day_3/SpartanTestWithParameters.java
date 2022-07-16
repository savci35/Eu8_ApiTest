package com.cydeo.day_3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithParameters {

    @BeforeAll
    public static void init() {

        // save baseUrl inside this variable so that we don't need to type each http method
        RestAssured.baseURI = "http://3.90.66.60:8000";

    }
@Test
    public void test1(){

}



}
