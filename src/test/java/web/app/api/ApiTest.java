package web.app.api;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void testGetPizzaPage() {
        String endpoint = "http://localhost:8080/students";
        ValidatableResponse response = given().when().get(endpoint).then();
        response.log().body();
        given().when().get(endpoint).then().assertThat().statusCode(200);
    }

    @Test
    public void testGetStudentWithId() {
        String endpoint = "http://localhost:8080/students";
        given().queryParam("id", 1)
                .when().get(endpoint)
                .then().assertThat().statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", equalTo("James"))
                .body("lastName", equalTo("Smith"))
                .body("email", equalTo("james_smith@anywhere.school"))
                .log().body();
    }

    @Test
    public void testGetStudentWithParameterDirectly(){
        String endpoint = "http://localhost:8080/students?id=1";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void testGetSecondStudentById(){
      String endpoint = "http://localhost:8080/students";
      given().queryParam("id", 2)
              .when().get(endpoint)
              .then().assertThat().statusCode(200)
              .body("email", equalTo("helen_brown@anywhere.school"))
              .log().body();
    }
}
