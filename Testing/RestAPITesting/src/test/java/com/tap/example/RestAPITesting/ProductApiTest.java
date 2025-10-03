package com.tap.example.RestAPITesting;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

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

    @Test
    public void getProductById_shouldReturnOne()
    {
        RestAssured.baseURI="http://localhost:9090";
        given()
        .when().get("/api/products/1")
        .then()
        .statusCode(200)
        .body("name", notNullValue())
        .body("price", greaterThan(13999f));
    }

    @Test
    public void createProduct_shouldreturn200()
    {
        RestAssured.baseURI="http://localhost:9090";
        String newProductJson="""
                {
                    "id":4,
                    "name":"Wireless Mouse",
                    "price":1500
                }
                """;

                given()
                    .contentType(ContentType.JSON)
                    .body(newProductJson)
                .when()
                    .post("/api/products")
                        .then()
                        .statusCode(200);
}


}
