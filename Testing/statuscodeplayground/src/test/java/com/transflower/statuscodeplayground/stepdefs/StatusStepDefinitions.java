package com.transflower.statuscodeplayground.stepdefs;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class StatusStepDefinitions {

    private Response response;

    @Given("the Product API is available")
    public void the_product_api_is_available() {
        // Set the base URI for the API
        RestAssured.baseURI = "http://localhost:9090";
    }

    @When("I send GET request to {string}")
    public void iSendGetRequestTo(String path) {
        response = RestAssured
                .given()
                .when()
                .get(path);
    }

    @When("I send POST request to {string}")
    public void iSendPostRequestTo(String path) {
        response = RestAssured
                .given()
                .when()
                .post(path);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        int actualStatus = response.getStatusCode();
        Assert.assertEquals(
                actualStatus,
                expectedStatus,
                "❌ Expected HTTP status " + expectedStatus + " but got " + actualStatus);
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String expectedText) {
        String body = response.getBody().asString();
        Assert.assertTrue(
                body.toLowerCase().contains(expectedText.toLowerCase()),
                "❌ Response body did not contain expected text: " + expectedText + "\nActual body: " + body);
    }
}
