package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.example.Data.*;

public class SingleUserResponse {
    public static JsonPath SingleUser(String header2){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", header2);
//        Map<String, String> queryParams = new HashMap<>();
//        queryParams.put(queryParam1, queryParam2);

        Response singleUsersResponse = RestAssured.given().log().all().headers(header)
                .get(baseurl+singleUserEndPoint);
        JsonPath singleUsersJson = singleUsersResponse.jsonPath();
        singleUsersResponse.prettyPrint();
        return singleUsersJson;
    }
}
