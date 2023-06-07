package web.app.api;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {
    @Test
    public void testGetStudents() {
        String endpoint = "http://localhost:8080/students";
        ValidatableResponse response = given().when().get(endpoint).then();
        response.log().body();
        given().when().get(endpoint).then().assertThat().statusCode(200);
    }

    @Test
    public void testGetStudentWithId() {
//        StudentService studentService = new StudentService();
//        Student student = studentService.getStudentById(1);
//        assertEquals(1, student.id());
//        assertEquals("James", student.firstName());
//        assertEquals("Smith", student.lastName());
//        assertEquals("james_smith@anywhere.school", student.email());

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
