package com.tap.example.RestAPITesting;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ProductApiTest {
    
    @Test
    public void testGetAllProducts()
    {
        RestAssured.baseURI="http://localhost:9090";

        given()
            .when().get("/api/products")
            .then()
            .statusCode(200)
            .body("size()",greaterThan(0))
            .body("[0].name",notNullValue());
        
    }
}
