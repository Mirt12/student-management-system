package web.app.api;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;

public class Task1CreateJson {
    @Test
    public void createNewUser() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/web/app/api/payLoad.json"));
        //convert byte array to string
        String body = new String(b);
        System.out.println(body);
        //base URL
        RestAssured.baseURI = "http://localhost:8080";
        //input details with header and body
        given().header("Content-type", "application/json").body(body)
                //adding post method
                .when().post("/students").then().log().all()
                //verify status code as 201
                .assertThat().statusCode(200);
    }

    @Test
    public void createFirstNameUser() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/web/app/api/payLoad2.json"));
        //convert byte array to string
        String body = new String(b);
        System.out.println(body);
        //base URL
        RestAssured.baseURI = "http://localhost:8080";
        //input details with header and body
        given().header("Content-type", "application/json").body(body)
                //adding post method
                .when().post("/students").then().log().all()
                //verify status code as 201
                .assertThat().statusCode(200);
    }
}
