package org.acme.scheduler;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CountResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/count")
          .then()
             .statusCode(200)
             .body(is("count: 1"));
    }

}