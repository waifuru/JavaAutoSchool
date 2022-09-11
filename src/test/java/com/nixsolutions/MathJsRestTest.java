package com.nixsolutions;

import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MathJsRestTest {

    private static final String BASE_URL = "http://api.mathjs.org/v4/";
    private static final String EXPRESSION_BODY = "{\"expr\":\"%s\"}";

    private final RequestSpecification given = given()
            .header("User-Agent", "Learning RestAssured")
            .header("content-type", "application/json");

    @Test
    public void testAdd() {
        String expression = String.format(EXPRESSION_BODY, "15 + 45");
        given.body(expression)
                .when().post(BASE_URL)
                .then().body("result", equalTo("60"));
    }

    @Test
    public void testSubtract() {
        String expression = String.format(EXPRESSION_BODY, "68 - 56");
        given.body(expression)
                .when().post(BASE_URL)
                .then().body("result", equalTo("12"));
    }

    @Test
    public void testMultiply() {
        String expression = String.format(EXPRESSION_BODY, "45 * 2");
        given.body(expression)
                .when().post(BASE_URL)
                .then().body("result", equalTo("90"));
    }

    @Test
    public void testDivide() {
        String expression = String.format(EXPRESSION_BODY, "60 / 3");
        given.body(expression)
                .when().post(BASE_URL)
                .then().body("result", equalTo("20"));
    }

    @Test
    public void testDivideByZero() {
        String expression = String.format(EXPRESSION_BODY, "60 / 0");
        given.body(expression)
                .when().post(BASE_URL)
                .then().body("result", equalTo("Infinity"));
    }

    @Test
    public void testSqrt() {
        given.queryParam("expr", "sqrt(16)")
                .when().get(BASE_URL)
                .then().body(equalTo("4"));
    }

}
