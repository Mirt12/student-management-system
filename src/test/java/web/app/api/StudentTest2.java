package web.app.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StudentTest2 {
    @Test
    public void testCreateStudentByNameAndEmail() {
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
    @Test
    public void testCreateStudentByFirstName(){
        Student body= new Student("Rajeshhh");
        String endpoint = "http://localhost:8080/students";
        given().header("Content-Type", "application/json").body(body).
                when().post(endpoint).
                then().assertThat().
                statusCode(200).
                body("firstName", equalTo("Rajeshhh")).
                log().body();
        //to check result:
        given().when().get(endpoint).then().log().all();
    }

    @Test
    public void testUpdateStudent1(){
        Student body = new Student("Jonatan", "Trucks", "john_truck2@anywhere.school");
        String endpoint = "http://localhost:8080/students/{id}";
        int id = 1;
        given().header("Content-Type", "application/json").body(body).
                when().put(endpoint, id).
                then().assertThat().
                statusCode(200).
                body("firstName", equalTo("Jonatan")).
                body("email", equalTo("john_truck2@anywhere.school")).
                log().body();
        //to check result after update:
        given().when().get("http://localhost:8080/students/").then().log().all();
    }

    @Test
    public void testUpdateStudent2(){
        Student body = new Student("Emmanuel", "Garcia", "emmanuel_ garcia@anywhere.school");
        String endpoint = "http://localhost:8080/students/{id}";
        int id = 2;
        given().header("Content-Type", "application/json").body(body).
                when().put(endpoint, id).
                then().assertThat().statusCode(200).
                body("firstName", equalTo("Emmanuel")).
                body("lastName", equalTo("Garcia")).
                body("email", equalTo("emmanuel_ garcia@anywhere.school")).
                log().body();
    }
    @Test
    public void testUpdateStudent3(){
        Student body = new Student("Shanti", "Jackson", "david_jackson@anywhere.school");
        String endpoint = "http://localhost:8080/students/{id}";
        int id = 3;
//        given().when().get("http://localhost:8080/students/").then().log().all();
        given().header("Content-Type", "application/json").body(body).
                when().put(endpoint, id).
                then().assertThat().statusCode(200).
                body("firstName", equalTo("Shanti")).
                body("lastName", equalTo("Jackson")).
                body("email", equalTo("david_jackson@anywhere.school")).
                log().body();
    }
    @Test
    public void testUpdateStudent3ByLastNameOnly(){
        Student body = new Student("Shanti", "Jackson'S", "david_jackson@anywhere.school");
        String endpoint = "http://localhost:8080/students/{id}";
        int id = 3;
        given().when().get("http://localhost:8080/students/").then().log().all();
        given().header("Content-Type", "application/json").body(body).
                when().put(endpoint, id).
                then().assertThat().statusCode(200).
                body("firstName", equalTo("Shanti")).
                body("lastName", equalTo("Jackson'S")).
                body("email", equalTo("david_jackson@anywhere.school")).
                log().body();
    }
}

