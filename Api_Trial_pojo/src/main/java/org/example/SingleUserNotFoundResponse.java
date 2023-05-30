package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.example.Data.*;
import static org.example.Data.singleUserEndPoint;

public class SingleUserNotFoundResponse {
    public static Response SingleUserNotFound(String header2){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", header2);

        Response singleUsersResponse = RestAssured.given().log().all().headers(header)
                .get(baseurl+SingleUserNotFoundEndPoint);
        singleUsersResponse.prettyPrint();
        return singleUsersResponse;
    }
}
