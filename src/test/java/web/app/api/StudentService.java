package web.app.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StudentService {
    private String endpoint = "http://localhost:8080/students";

    public Student getStudentById(int id) {
        // Make a GET request to the API endpoint with the specified id
        Response response = given()
                .queryParam("id", id)
                .when()
                .get(endpoint);
        // Parse the response into a Student object
        Student student = response.as(Student.class);
        return student;
    }
}

