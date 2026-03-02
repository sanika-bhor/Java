package com.tap.example.RestAPITesting;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
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
        .when().get("/api/products/3")
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


@Test
public void updateProduct_shouldReturn200()
{
    RestAssured.baseURI="http://localhost:9090";
    String updateProductJson="""
            {
                    "id": 1,
                    "name": "Wireless",
                    "price": 19000
                }
            """;

        given()
        .contentType(ContentType.JSON)
        .body(updateProductJson)
        .when()
        .put("/api/products/1")
        .then()
        .statusCode(200);
}

@Test
public void deleteProduct_shouldReturn200()
{
    RestAssured.baseURI="http://localhost:9090";
    given()
    .when()
    .delete("/api/products/2")
    .then()
    .statusCode(200)
    .body(equalTo("true"));
}

}
