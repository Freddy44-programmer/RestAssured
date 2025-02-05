package codewithfreddy;

import files.payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Main {
    public static void main(String[] args) {
        //validate if Add Place API is working as expected

        //given - all input details
        //when -submit the API -resource,http methods
        //Then - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
       String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                     .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
        System.out.println(response);
    }
}