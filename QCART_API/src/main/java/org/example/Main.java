package org.example;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Main {
    public static Object getUsers(){
      Object users=  given().baseUri("https://645279c3a2860c9ed40d65e4.mockapi.io/api/v1/")
                .when().get("users")
                .then().log().all();
return users;
    }
    public static void main(String[] args) {
        getUsers();
    }
}