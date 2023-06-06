package web.app.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StudentTest2 {
    @Test
    public void testCreateStudent() {
        String endpoint = "http://localhost:8080/students";
        Student body = new Student("Sergioo", "Teacher", "sergio_teacher@anywhere.school");
        given().
                header("Content-Type", "application/json").
                body(body).
                when().
                post(endpoint).
                then().
                assertThat().
                statusCode(200).
                body("firstName", equalTo("Sergioo")).
                body("lastName", equalTo("Teacher")).
                body("email", equalTo("sergio_teacher@anywhere.school")).log().body();
    }


}
