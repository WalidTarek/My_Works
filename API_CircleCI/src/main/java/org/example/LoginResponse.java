package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.example.Data.baseurl;
import static org.example.Data.loginEndPoint;

public class LoginResponse {
    public static Response login (String username, String password){
        Response loginResponse = RestAssured.given().log().all().contentType("application/json").body("{\n" +
                "    \"email\": \""+username+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}").post(baseurl+loginEndPoint);
        System.out.println(loginResponse.statusCode());
//        loResponse.prettyPrint();
        return loginResponse;
    }
    public static String loginToken (String username, String password){
        Response loginResponse = RestAssured.given().log().all().contentType("application/json").body("{\n" +
                "    \"email\": \""+username+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}").post(baseurl+loginEndPoint);
        //    System.out.println(loginResponse.statusCode());
//        loResponse.prettyPrint();
        String tokenResponse=loginResponse.jsonPath().getString("token");
        return tokenResponse;
    }
}
