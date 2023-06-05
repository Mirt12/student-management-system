package web.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentTest {
    @Test
    public void createStudent() {
        Student student1 = new Student(9, "Aamir", "Khan", "aamir_khan@anywhere.school");
        //convert java class Object to JSON as String:
        ObjectMapper mapper = new ObjectMapper();
        String studentJson = null;
        try {
            studentJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String baseUrl = "http://localhost:8080";
        given().baseUri(baseUrl).contentType(ContentType.JSON).body(studentJson)
                .when().post("/students")
                .then().assertThat().statusCode(200).log().body();
        System.out.println("-------------");

        given().baseUri(baseUrl).contentType(ContentType.JSON)
                .when().get("/students")
                .then().assertThat().statusCode(200).log().body();
    }
}
