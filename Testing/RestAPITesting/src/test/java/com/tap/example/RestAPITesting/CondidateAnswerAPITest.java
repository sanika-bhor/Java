package com.tap.example.RestAPITesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CondidateAnswerAPITest {
    
    @Test
    public void GetCandidateAnswers()
    {
        RestAssured.baseURI="http://localhost:5238";

        given()
        .when().get("/api/candidateanswer/assessmentanswers/candidates/1/testId/1")
        .then()
        .statusCode(200)
        .body("size()", greaterThan(0))
        .body("[0].id", equalTo(2));
    }

    @Test
    public void GetCandidateAnswerResult()
    {
        RestAssured.baseURI="http://localhost:5238";

        given()
        .when().get("/api/candidateanswer/assessmentanswers/candidates/1/tests/1/results")
        .then()
        .body("[0].testQuestionId",equalTo(2))
        .statusCode(200);
    }
}
